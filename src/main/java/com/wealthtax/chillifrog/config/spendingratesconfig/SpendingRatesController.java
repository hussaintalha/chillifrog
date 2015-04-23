package com.wealthtax.chillifrog.config.spendingratesconfig;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SpendingRatesController {
	@Autowired
	private SpendingRatesService spendingRatesService;

	public void setSpendingRatesService(
			SpendingRatesService spendingRatesService) {
		this.spendingRatesService = spendingRatesService;
	}

	@RequestMapping(value = "/spendingrateconfigs", method = RequestMethod.GET)
	public String listSpendingRates(Model model) {
		SpendingRates spending = new SpendingRates();
		List<SpendingRates> list = this.spendingRatesService
				.listSpendingRates();
		if (list != null && !list.isEmpty()) {
			spending = list.get(0);
			model.addAttribute("id", spending.getSpendingRateID());
		} else {
			model.addAttribute("id", 0);
		}
		model.addAttribute("spendingrate", spending);
		return "spendingrate";
	}

	@RequestMapping(value = "/spendingrateconfig/add", method = RequestMethod.POST)
	public String addSpendingRate(
			@ModelAttribute("spendingRates") SpendingRates spend) {
		this.spendingRatesService.add(spend);
		return "redirect:/spendingrateconfigs";
	}

	@RequestMapping(value = "/spendingrateconfig/update", method = RequestMethod.POST)
	public String edtSpendingRates(
			@ModelAttribute("spendingRates") SpendingRates spend) {
		List<SpendingRates> list = this.spendingRatesService
				.listSpendingRates();
		if (list != null && !list.isEmpty()) {
			spend.setUpdatedDate(new Date());
			spend.setSpendingRateID(list.get(0).getSpendingRateID());
		}
		this.spendingRatesService.update(spend);
		return "redirect:/spendingrateconfigs";
	}

}
