package com.wealthtax.chillifrog.config.incometaxrateconfig;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wealthtax.chillifrog.utils.CollectionUtil;

@Controller
public class IncomTaxRateController {
	@Autowired
	private IncomeTaxService incomeTaxService;

	public void setIncomeTaxService(IncomeTaxService incomeTaxService) {
		this.incomeTaxService = incomeTaxService;
	}
	@RequestMapping(value = "/incometax", method = RequestMethod.GET)
    public String listIncomeTax(Model model, Map<String,List<Integer>> map) {
		int currentYear=CollectionUtil.getCurrentYear();
		System.out.println("get current yar ="+currentYear);
		map.put("yearList",CollectionUtil.getYearList(1950, currentYear));
		
        model.addAttribute("incomeTaxRate", new IncomeTaxRate());
        model.addAttribute("listIncomeTaxRate", this.incomeTaxService.listIncomeTaxRate());
        return "incometaxrate";
    }
	
	@RequestMapping(value= "/incometax/add", method = RequestMethod.POST)
    public String addIncomeTax(@ModelAttribute("incomeTaxRate") IncomeTaxRate incomeTaxRate){
         
		System.out.println("Year: ===>"+incomeTaxRate.getYearValue());
		System.out.println("inflation Rate:====>"+incomeTaxRate.getIncometaxRate());
        if(incomeTaxRate.getIncomeTaxID()== 0){
            //new inflation, add it
            this.incomeTaxService.add(incomeTaxRate);
        }else{
            //existing inflation, call update
             this.incomeTaxService.update(incomeTaxRate);       
        	}
         
        return "redirect:/incometax";
         
    }

	@RequestMapping("/removeIncometax/{id}")
    public String removeIncomeTax(@PathVariable("id") int id){       
        this.incomeTaxService.delete(id);
        return "redirect:/incometax";
    }
  
	@RequestMapping("/editIncometax/{id}")
    public String editIncomeTax(@PathVariable("id") int id, Model model){
    	
        model.addAttribute("incomeTaxRate", this.incomeTaxService.getIncomeTaxRateByID(id));
        model.addAttribute("listIncomeTaxRate", this.incomeTaxService.listIncomeTaxRate());
        int currentYear = CollectionUtil.getCurrentYear();
		model.addAttribute("yearList", CollectionUtil.getYearList(1950, currentYear));
       
        return "incometaxrate";
    }


	
}
