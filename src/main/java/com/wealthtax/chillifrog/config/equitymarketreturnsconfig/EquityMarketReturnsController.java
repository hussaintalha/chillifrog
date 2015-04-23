package com.wealthtax.chillifrog.config.equitymarketreturnsconfig;

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
public class EquityMarketReturnsController {
private EquityMarketReturnsService equityMarketReturnsService;
	
	@Autowired(required=true)
    @Qualifier(value="equityMarketReturnsService")
	public void setEquityMarketReturnsService(
		EquityMarketReturnsService equityMarketReturnsService) {
	this.equityMarketReturnsService = equityMarketReturnsService;
}
	
	@RequestMapping(value = "/equityMarket", method = RequestMethod.GET)
    public String listEquityMarketReturns(Model model, Map<String,List<Integer>> map) {
		int currentYear=CollectionUtil.getCurrentYear();	
		System.out.println("get current yar ="+currentYear);
		map.put("yearList",CollectionUtil.getYearList(1950, currentYear));
		
        model.addAttribute("equityMarketReturns", new EquityMarketReturns());
        model.addAttribute("listEquityMarketReturns", this.equityMarketReturnsService.listEquityMarketReturns());
        return "equityMarketReturns";
    }
	
	@RequestMapping(value= "/equityMarket/add", method = RequestMethod.POST)
    public String addEquityMarket(@ModelAttribute("equityMarketReturns") EquityMarketReturns equityMarketReturns){
         
		System.out.println("Year: ===>"+equityMarketReturns.getYearValue());
		System.out.println("inflation Rate:====>"+equityMarketReturns.getEquityMarketID());
        if(equityMarketReturns.getEquityMarketID()== 0){
            //new inflation, add it
            this.equityMarketReturnsService.add(equityMarketReturns);
        }else{
            //existing inflation, call update
             this.equityMarketReturnsService.update(equityMarketReturns);       
        	}
         
        return "redirect:/equityMarket";
         
    }

	@RequestMapping("/removeequityMarket/{id}")
    public String removeEquityMarket(@PathVariable("id") int id){       
        this.equityMarketReturnsService.delete(id);
        return "redirect:/equityMarket";
    }
  
    @RequestMapping("/editequityMarket/{id}")
    public String editEquityMarketReturns(@PathVariable("id") int id, Model model){
    	//EquityMarketReturns equityMarketReturns1 = this.equityMarketReturnsService.getEquityMarketByID(id);
    	//System.out.println("year Value:====>"+equityMarketReturns1.getYearValue());
        model.addAttribute("equityMarketReturns", this.equityMarketReturnsService.getEquityMarketByID(id));
        model.addAttribute("listEquityMarketReturns", this.equityMarketReturnsService.listEquityMarketReturns());
        int currentYear = CollectionUtil.getCurrentYear();
		model.addAttribute("yearList", CollectionUtil.getYearList(1950, currentYear));
        return "equityMarketReturns";
    }


}
