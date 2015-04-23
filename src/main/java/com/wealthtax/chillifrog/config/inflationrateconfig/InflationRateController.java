package com.wealthtax.chillifrog.config.inflationrateconfig;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cglib.core.CollectionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wealthtax.chillifrog.config.countryconfig.CountryService;
import com.wealthtax.chillifrog.utils.CollectionUtil;

@Controller
public class InflationRateController {
	
	private InflationRateService inflationRateService;
	
	@Autowired(required=true)
    @Qualifier(value="inflationRateService")
	public void setInflationRateService(InflationRateService inflationRateService) {
		this.inflationRateService = inflationRateService;
    }
	
	@RequestMapping(value = "/inflation", method = RequestMethod.GET)
    public String listInflation(Model model, Map<String,List<Integer>> map) {
		int currentYear=CollectionUtil.getCurrentYear();
		System.out.println("get current yar ="+currentYear);
		map.put("yearList",CollectionUtil.getYearList(1950, currentYear));
		
        model.addAttribute("inflationRate", new InflationRate());
        model.addAttribute("listInflationRate", this.inflationRateService.listInflationRate());
        return "inflationRate";
    }
	
	@RequestMapping(value= "/inflation/add", method = RequestMethod.POST)
    public String addInflation(@ModelAttribute("inflationRate") InflationRate inflationRate){
         
		System.out.println("Year: ===>"+inflationRate.getYearValue());
		System.out.println("inflation Rate:====>"+inflationRate.getInflationRate());
        if(inflationRate.getInflationRateID()== null){
            //new inflation, add it
            this.inflationRateService.add(inflationRate);
        }else{
            //existing inflation, call update
             this.inflationRateService.update(inflationRate);       
        	}
         
        return "redirect:/inflation";
         
    }

	@RequestMapping("/removeInflation/{id}")
    public String removeInflation(@PathVariable("id") int id){       
        this.inflationRateService.delete(id);
        return "redirect:/inflation";
    }
  
    @RequestMapping("/editInflation/{id}")
    public String editInflation(@PathVariable("id") int id, Model model){
    	
        model.addAttribute("inflationRate", this.inflationRateService.getInflationRateByID(id));
        model.addAttribute("listInflationRate", this.inflationRateService.listInflationRate());
        int currentYear = CollectionUtil.getCurrentYear();
		model.addAttribute("yearList", CollectionUtil.getYearList(1950, currentYear));
        return "inflationRate";
    }

}
