package com.wealthtax.chillifrog.config.capitalgainstaxrateconfig;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.wealthtax.chillifrog.utils.CollectionUtil;

@Controller
public class CapitalGainsTaxRateController {
	private CapitalGainsTaxRateService capitalGainsTaxRateService;

	@Autowired(required = true)
	@Qualifier(value = "capitalGainsTaxRateService")
	public void setCapitalGainsTaxRateService(
			CapitalGainsTaxRateService capitalGainsTaxRateService) {
		this.capitalGainsTaxRateService = capitalGainsTaxRateService;
	}

	@RequestMapping(value = "/capitalgain", method = RequestMethod.GET)
	public String listCapitalGainsTaxRate(Model model,
			Map<String, List<Integer>> map) {
		int currentYear = CollectionUtil.getCurrentYear();
		System.out.println("get current yar =" + currentYear);
		map.put("yearList", CollectionUtil.getYearList(1950, currentYear));

		model.addAttribute("capitalGainsTaxRate", new CapitalGainsTaxRate());
		model.addAttribute("listCapitalGainsTaxRate",
				this.capitalGainsTaxRateService.listCapitalGainsTaxRates());
		return "capitalgains";
	}

	@RequestMapping(value = "/capitalgain/add", method = RequestMethod.POST)
	public String addCapitalGain(
			@ModelAttribute("capitalGainsTaxRate") CapitalGainsTaxRate capitalGainsTaxRate) {

		System.out.println("Year: ===>" + capitalGainsTaxRate.getYearValue());
		System.out.println("capitalGainsTax Rate :====>"
				+ capitalGainsTaxRate.getCapitalgainstaxRate());
		if (capitalGainsTaxRate.getCapitalGainrateID() == 0) {
			// new capitalGainsTaxRate, add it
			this.capitalGainsTaxRateService.add(capitalGainsTaxRate);
		} else {
			// existing capitalGainsTaxRate, call update
			this.capitalGainsTaxRateService.update(capitalGainsTaxRate);
		}

		return "redirect:/capitalgain";

	}

	@RequestMapping("/removecapitalgain/{id}")
	public String removecapitalgain(@PathVariable("id") int id) {
		this.capitalGainsTaxRateService.removeCapitalGainsTaxRate(id);
		;
		return "redirect:/capitalgain";
	}

	@RequestMapping("/editcapitalgain/{id}")
	public String editCapitalGainsTaxRate(@PathVariable("id") int id,
			Model model) {

		model.addAttribute("capitalGainsTaxRate",
				this.capitalGainsTaxRateService.getCapitalGainsTaxRateById(id));
		model.addAttribute("listCapitalGainsTaxRate",
				this.capitalGainsTaxRateService.listCapitalGainsTaxRates());
		int currentYear = CollectionUtil.getCurrentYear();
		model.addAttribute("yearList", CollectionUtil.getYearList(1950, currentYear));
       
		return "capitalgains";
	}

}
