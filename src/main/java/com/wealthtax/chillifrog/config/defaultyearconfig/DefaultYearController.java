package com.wealthtax.chillifrog.config.defaultyearconfig;

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
public class DefaultYearController {
	private DefaultYearService defaultYearService;

	@Autowired(required = true)
	@Qualifier(value = "defaultYearService")
	public void setDefaultYearService(DefaultYearService defaultYearService) {
		this.defaultYearService = defaultYearService;
	}

	@RequestMapping(value = "/defaultyear", method = RequestMethod.GET)
	public String listDefaultYear(Model model, Map<String, List<Integer>> map) {
		int currentYear = CollectionUtil.getCurrentYear();
		System.out.println("get current yar =" + currentYear);
		map.put("yearList", CollectionUtil.getYearList(1950, currentYear));

		model.addAttribute("defaultYear", new DefaultYear());
		model.addAttribute("listDefaultYear",
				this.defaultYearService.listDefaultYears());
		return "defaultYearpage";
	}

	@RequestMapping(value = "/defaultyear/add", method = RequestMethod.POST)
	public String addDefaultYear(
			@ModelAttribute("defaultYear") DefaultYear defaultYear) {

		if (defaultYear.getDefaultYearID() == 0) {
			// new inflation, add it
			this.defaultYearService.add(defaultYear);
			;
		} else {
			// existing inflation, call update
			this.defaultYearService.update(defaultYear);
		}

		return "redirect:/defaultyear";

	}

	@RequestMapping("/removedefaultyear/{id}")
	public String removeDefaultyear(@PathVariable("id") int id) {
		this.defaultYearService.delete(id);
		return "redirect:/defaultyear";
	}

	@RequestMapping("/editdefaultyear/{id}")
	public String editDefaultyear(@PathVariable("id") int id, Model model) {

		model.addAttribute("defaultYear",
				this.defaultYearService.getDefaultYearByID(id));
		model.addAttribute("listDefaultYear",
				this.defaultYearService.listDefaultYears());
		int currentYear = CollectionUtil.getCurrentYear();
		model.addAttribute("yearList",
				CollectionUtil.getYearList(1950, currentYear));
		return "defaultYearpage";
	}

}
