package com.wealthtax.chillifrog.assets;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wealthtax.chillifrog.util.Constant;
import com.wealthtax.chillifrog.util.Currency;
import com.wealthtax.chillifrog.util.RoundingOff;
import com.wealthtax.chillifrog.util.UtilDAO;

@Controller
@RequestMapping("/assets")
public class AssetsController {

	private static final Logger logger = LoggerFactory
			.getLogger(AssetsController.class);

	private AssetsService assetsService;

	@Autowired(required = true)
	@Qualifier("assetsService")
	public void setAssetsService(AssetsService assets) {
		this.assetsService = assets;
	}

	@Autowired
	private UtilDAO utilDAO;


	@RequestMapping(method = RequestMethod.GET)
	public String listAssets(Model model) {

		model.addAttribute("assets", new Assets());
		List <Assets> assets = this.assetsService.listOfPropertyAssets(Constant.PROFILE_ID);
		model.addAttribute("propertylistAssets",this.propertyClassAssests(assets));
		model.addAttribute("illliquidlistAssets",this.illliquidClassAssests(assets));
		model.addAttribute("liquidlistAssets",
				this.assetsService.listOfLiquidAssets(Constant.PROFILE_ID));
		model.addAttribute("listAssetType",
				this.assetsService.listOfAssetTypes());
		model.addAttribute("currency", this.utilDAO.listOfCurrency());

		return "assets";
	}

	// For add and update person both
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addAssets(@ModelAttribute("assets") Assets asset,
			@RequestParam String date) {

		int day = Integer.parseInt(date.substring(0, 2));
		int month = Integer.parseInt(date.substring(2, 4));
		int year = Integer.parseInt(date.substring(4, 8));

		asset.setPurchaseDay(day);
		asset.setPurchaseMonth(month);
		asset.setPurchaseYear(year);
		asset.setAssetValue(asset.getRoundedValueofHolding());
		asset.setValueOfHolding(asset.getRoundedValueofHolding());
		asset.setCurrencyTo("USD");
		
		if (asset.getId() == 0) {
			// new person, add it
			if (asset.getAssetClass().equals(Constant.LIQUID_ASSET)) {
				Networthcashother networthcashother = this
						.setDataNetworthcashother(asset);
				this.assetsService.addAssets(networthcashother);
			} else {
				this.assetsService.addAssets(asset);
			}
		} else {
			// existing person, call update
			if (asset.getAssetClass().equals(Constant.LIQUID_ASSET)) {
				Networthcashother networthcashother = this
						.setDataNetworthcashother(asset);
				this.assetsService.updateAssets(networthcashother);
			} else {
				this.assetsService.updateAssets(asset);
			}
		}
		return "redirect:/assets";

	}

	@RequestMapping(value = "/edit", method=RequestMethod.GET)
	public String editAssets(@RequestParam("id") int id,@RequestParam("assetClass") String assetClass, Model model) {
	
		model.addAttribute("assets", this.assetsService.getAssetsById(id,assetClass));

		List <Assets> assets = this.assetsService.listOfPropertyAssets(Constant.PROFILE_ID);
		model.addAttribute("propertylistAssets",this.propertyClassAssests(assets));
		model.addAttribute("illliquidlistAssets",this.illliquidClassAssests(assets));
		model.addAttribute("liquidlistAssets",
				this.assetsService.listOfLiquidAssets(Constant.PROFILE_ID));
		model.addAttribute("listAssetType",
				this.assetsService.listOfAssetTypes());
		model.addAttribute("currency", this.utilDAO.listOfCurrency());
		return "assets";
	}

	@RequestMapping(value = "/remove", method=RequestMethod.GET)
	public String removeAssets(@RequestParam("id") int id,@RequestParam("assetClass") String assetClass) {

		this.assetsService.removeAssets(id,assetClass);
		return "redirect:/assets";
	}

	@RequestMapping(value = "/fxrate", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody
	double getFxrate(@RequestParam String currency) {
		System.out.println("Enter in Fx RATE");
		Currency fxRate = utilDAO.getFxRate(currency);
		return fxRate.getExch_rate_per_usd();
	}

	@RequestMapping(value = "/roundingOff", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody double getRoundedValue(@RequestParam String actualAmount) {
		System.out.println("Enter in Rounded value" + actualAmount);
		return assetsService.roundActualAmount(Double.parseDouble(actualAmount));
	}
	
	
	private Networthcashother setDataNetworthcashother(Assets asset) {
		
		Networthcashother networthcash = new Networthcashother();
		networthcash.setId(asset.getId());
		networthcash.setAssetName(asset.getAssetName());
		networthcash.setAssetValue(asset.getAssetValue());
		networthcash.setAssetDescription(asset.getAssetDescription());
		networthcash.setAssetRemarks(asset.getAssetRemarks());
		networthcash.setIncludeInAssetSwatch(asset.isIncludeInAssetSwatch());
		networthcash.setValueOfHolding(asset.getValueOfHolding());
		networthcash.setLastUpdated(asset.getLastUpdated());
		networthcash.setEditorNotes(asset.getEditorNotes());
		networthcash.setAssetTypeID(asset.getAssetTypeID());
		networthcash.setVersion(asset.getVersion());
		networthcash.setValueofHolidingLocalCurrency(asset
				.getValueofHolidingLocalCurrency());
		networthcash.setRoundedValueofHolding(asset.getRoundedValueofHolding());
		networthcash.setCurrencyFrom(asset.getCurrencyFrom());
		networthcash.setCurrencyTo(asset.getCurrencyTo());
		networthcash.setCurrencyRate(asset.getCurrencyRate());
		networthcash.setAssetClass(asset.getAssetClass());
		networthcash.setProfileId(asset.getProfileId());
		networthcash.setPurchaseDay(asset.getPurchaseDay());
		networthcash.setPurchaseMonth(asset.getPurchaseMonth());
		networthcash.setPurchaseYear(asset.getPurchaseYear());
		networthcash.setValueofHoldingForeign(asset.getValueofHoldingForeign());
		return networthcash;
	}

	private List<Assets> propertyClassAssests (List<Assets> assets){
		List <Assets> propertList= new ArrayList<Assets>();
		for (Assets asset : assets){
			if (asset.getAssetClass().equals(Constant.PROPERTY_ASSET)){
				propertList.add(asset);
			}
		}
		return propertList;
	}
	
	private List<Assets> illliquidClassAssests (List<Assets> assets){
		List <Assets> liquidList=new ArrayList<Assets>();
		for (Assets asset : assets){
			if (asset.getAssetClass().equals(Constant.ILLLIQUID_ASSET)){
				liquidList.add(asset);
			}
		}
		return liquidList;
	}
	
}
