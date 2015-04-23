package com.wealthtax.chillifrog.config.taxformulainforconfig;


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
public class TaxFormulaInformationController {

	private TaxFormulaInformationService taxFormulaInformationService;

	@Autowired(required = true)
	@Qualifier(value = "taxFormulaInformationService")
	public void setTaxFormulaInformationService(
			TaxFormulaInformationService taxFormulaInformationService) {
		this.taxFormulaInformationService = taxFormulaInformationService;
	}

	@RequestMapping(value = "/taxformulas", method = RequestMethod.GET)
	public String listTaxFormulaInformation(Model model,Map<String, List<Integer>> map) {
		model.addAttribute("taxFormulaInformation", new TaxFormulaInformation());
		int currentYear = CollectionUtil.getCurrentYear();
        System.out.println("get current year"+currentYear);
		//model.addAttribute("yearList", CollectionUtil.getYearList(1950, currentYear));
		model.addAttribute("listTaxFormulaInformation",
				this.taxFormulaInformationService.listTaxFormulaInformation());
		
		map.put("yearList", CollectionUtil.getYearList(1950, currentYear));
		return "taxformula";
	}

	// For add and update person both
	@RequestMapping(value = "/taxFormulaInformation/add", method = RequestMethod.POST)
	public String addTaxFormulaInformation(
			@ModelAttribute("taxFormulaInformation") TaxFormulaInformation tax) {

		if (tax.getTaxFormulId() == 0) {
			// new person, add it
			this.taxFormulaInformationService.addTaxFormulaInformation(tax);
		} else {
			// existing person, call update
			this.taxFormulaInformationService.updateTaxFormulaInformation(tax);
		}

		return "redirect:/taxformulas";

	}

	@RequestMapping("/removeTaxFormulaInformation/{taxFormulId}")
	public String removeTaxFormulaInformation(
			@PathVariable("taxFormulId") int taxFormulId) {
		this.taxFormulaInformationService
				.removeTaxFormulaInformation(taxFormulId);
		return "redirect:/taxformulas";
	}

	@RequestMapping("/editTaxFormulaInformation/{taxFormulId}")
	public String editTaxFormulaInformation(
			@PathVariable("taxFormulId") int taxFormulId, Model model) {
		model.addAttribute("taxFormulaInformation", this.taxFormulaInformationService
				.getTaxFormulaInformationById(taxFormulId));
		model.addAttribute("listTaxFormulaInformation",
				this.taxFormulaInformationService.listTaxFormulaInformation());
		int currentYear = CollectionUtil.getCurrentYear();
		model.addAttribute("yearList", CollectionUtil.getYearList(1950, currentYear));
		return "taxformula";
	}

}
