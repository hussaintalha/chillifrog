package com.wealthtax.chillifrog.config.dividenttaxratesconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DividentTaxRatesController {

	private DividentTaxRatesService dividentTaxRatesService;

	/*
	 * private CountryService countryService;
	 * 
	 * @Autowired(required=true)
	 * 
	 * @Qualifier(value="countryService") public void
	 * setCountryService(CountryService cs){ this.countryService = cs; }
	 */

	@Autowired(required = true)
	@Qualifier(value = "dividentTaxRatesService")
	public void setDividentTaxRatesService(
			DividentTaxRatesService dividentTaxRatesService) {
		this.dividentTaxRatesService = dividentTaxRatesService;
	}

	@RequestMapping(value = "/dividenttaxrates", method = RequestMethod.GET)
	public String listDividentTaxRates(Model model) {
		model.addAttribute("dividenttaxrates", new DividentTaxRates());
		// model.addAttribute("countryList", countryService.listCountrys());
		model.addAttribute("listDividentTaxRates",
				this.dividentTaxRatesService.listDividentTaxRates());
		return "dividenttaxrates";
	}

	// For add and update person both
	@RequestMapping(value = "/dividenttaxrates/add", method = RequestMethod.POST)
	public String addDividentTaxRates(
			@ModelAttribute("dividenttaxrates") DividentTaxRates d) {

		if (d.getDividentTaxID() == 0) {
			// new person, add it
			this.dividentTaxRatesService.addDividentTaxRates(d);
		} else {
			// existing person, call update
			this.dividentTaxRatesService.updateDividentTaxRates(d);
		}

		return "redirect:/dividenttaxrates";

	}

	@RequestMapping("/removeDividentTaxRates/{id}")
	public String removeCountry(@PathVariable("id") int id) {
		this.dividentTaxRatesService.removeDividentTaxRates(id);
		return "redirect:/dividenttaxrates";
	}

	@RequestMapping("/editDividentTaxRates/{id}")
	public String editDividentTaxRates(@PathVariable("id") int id, Model model) {
		model.addAttribute("dividenttaxrates",
				this.dividentTaxRatesService.getDividentTaxRatesById(id));
		model.addAttribute("listDividentTaxRates",
				this.dividentTaxRatesService.listDividentTaxRates());
		return "dividenttaxrates";
	}
}
