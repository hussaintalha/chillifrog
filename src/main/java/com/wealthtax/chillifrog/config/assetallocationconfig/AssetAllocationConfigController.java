package com.wealthtax.chillifrog.config.assetallocationconfig;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AssetAllocationConfigController {
	
	@Autowired
	private AssetAllocationConfigService assetAllocationConfigService;

	@Qualifier(value = "assetAllocationConfigService")
	public void setAssetAllocationConfigService(AssetAllocationConfigService cs) {
		this.assetAllocationConfigService = cs;
	}

	@RequestMapping(value = "/assetallocationconfigs", method = RequestMethod.GET)
	public String listAssetAllocationConfigs(Model model) {
		AssetAllocationConfig allocationConfig = new AssetAllocationConfig();
		List<AssetAllocationConfig> list = this.assetAllocationConfigService.listAssetAllocationConfigs();
		if(list != null && !list.isEmpty()){
			allocationConfig = list.get(0);
			model.addAttribute("id", allocationConfig.getAssetConfigID());
		}else{
			model.addAttribute("id", 0);
		}
		model.addAttribute("assetAllocationConfig", allocationConfig);
		return "assetallocation_tabs";
	}

	// For add assetallocationconfig both

	@RequestMapping(value = "/assetAllocationConfig/add", method = RequestMethod.POST)
	public String addAssetAllocationConfig(
			@ModelAttribute("assetAllocationConfig") AssetAllocationConfig ac) {
		this.assetAllocationConfigService.addAssetAllocationConfig(ac);
		return "redirect:/assetallocationconfigs";
	}
	
  
    @RequestMapping(value="/assetAllocationConfig/update", method = RequestMethod.POST)
    public String editallocationconfig(@ModelAttribute("assetAllocationConfig") AssetAllocationConfig ac){
    	List<AssetAllocationConfig> list = this.assetAllocationConfigService.listAssetAllocationConfigs();
		if(list != null && !list.isEmpty()){
			ac.setUpdatedDate(new Date());
			ac.setAssetConfigID(list.get(0).getAssetConfigID());
		}
    	this.assetAllocationConfigService.updateAssetAllocationConfig(ac);
    	return "redirect:/assetallocationconfigs";
    }
}
