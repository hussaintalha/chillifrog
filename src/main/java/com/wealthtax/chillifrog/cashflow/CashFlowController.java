package com.wealthtax.chillifrog.cashflow;

import java.util.List;
import java.util.concurrent.Exchanger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wealthtax.chillifrog.util.Currency;
import com.wealthtax.chillifrog.util.UtilDAO;

@Controller
@RequestMapping("/cashFlow")
public class CashFlowController {

    private CashFlowService cashFlowService;

    @Autowired(required = true)
    @Qualifier("cashFlowService")
    public void setCashFlowService(CashFlowService cashFlowService) {
        this.cashFlowService = cashFlowService;
    }
    
    @Autowired
    UtilDAO utilDAO;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String listcashFlow(Model model) {
        model.addAttribute("cashFlow", new CashFlow());
        model.addAttribute("listCashFlow", this.cashFlowService.listCashFlow());
        model.addAttribute("cashflowType", this.cashFlowService.getCashFlowType());
        model.addAttribute("currency", this.utilDAO.listOfCurrency());
for (Currency c : utilDAO.listOfCurrency()){
	if (c.getIso_currency().equals("MYR")){
		System.out.println(c.getExch_rate_per_usd());
	}
}
        return "cashFlow";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addCashFlow(@ModelAttribute("cashFlow") CashFlow cashFlow,
    		@RequestParam String date) {
    		System.out.println("Cash FLow Amount:"+cashFlow.getFxAmountforeign());
		int day = Integer.parseInt(date.substring(0, 2));
		int month = Integer.parseInt(date.substring(2, 4));
		int year = Integer.parseInt(date.substring(4, 8));
		cashFlow.setTransactionDay(day);
		cashFlow.setTransactionMonth(month);
		cashFlow.setTransactionYear(year);
    	
        if (cashFlow.getOthercashflowID() == null || cashFlow.getOthercashflowID() == 0) {
            cashFlowService.addCashFlow(cashFlow);
        } else {
            cashFlowService.updateCashFlow(cashFlow);
        }

        return "redirect:/cashFlow/";

    }

    @RequestMapping("/remove/{id}")
    public String removeCashFlow(@PathVariable("id") int id) {
        cashFlowService.removeCashFlow(id);
        return "redirect:/cashFlow/";
    }

    @RequestMapping("/edit/{id}")
    public String editCashFlow(@PathVariable("id") int id, Model model) {
        model.addAttribute("cashFlow", cashFlowService.getCashFlowById(id));
        model.addAttribute("listCashFlow", cashFlowService.listCashFlow());
        model.addAttribute("cashflowType", this.cashFlowService.getCashFlowType());
        model.addAttribute("currency", this.utilDAO.listOfCurrency());
        return "cashFlow";
    }

    @RequestMapping(value = "/fxrate", method = RequestMethod.GET,produces = "application/json")
    public @ResponseBody double getFxrate (@RequestParam String currency){
	  System.out.println("Enter in Fx RATE");
	  Currency fxRate = utilDAO.getFxRate(currency);
	  return fxRate.getExch_rate_per_usd();
  }
    @RequestMapping (value = "/actualAmountforeign", method = RequestMethod.GET, produces  = "application/json")

    public @ResponseBody double calculateActualAmount(@RequestParam String baseCurrency, @RequestParam String foreignCurrency,
    		@RequestParam double totalAmount){
    	System.out.println(baseCurrency+":"+foreignCurrency+":"+totalAmount);
    	List <Currency> currency = utilDAO.listOfCurrency();
    	double exchRateBaseCurrency = 0;
    	double exchRateForeignCurrency = 0;
    	double actualAmount = 0;
    	for (Currency c : currency){
    		if (c.getIso_currency().equals(baseCurrency)){
    		exchRateBaseCurrency = c.getExch_rate_per_usd();	
    		} else if (c.getIso_currency().equals(foreignCurrency)){
    			exchRateForeignCurrency = c.getExch_rate_per_usd();
    		}
    	}
    	actualAmount = (totalAmount / exchRateBaseCurrency);
    	actualAmount = (actualAmount * exchRateForeignCurrency);
    	return actualAmount;
    }
    
}
