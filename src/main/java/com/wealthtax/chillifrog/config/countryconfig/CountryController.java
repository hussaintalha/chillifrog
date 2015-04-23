package com.wealthtax.chillifrog.config.countryconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CountryController {
	  
    private CountryService countryService;
     
    @Autowired(required=true)
    @Qualifier(value="countryService")
    public void setCountryService(CountryService cs){
        this.countryService = cs;
    }
     
    @RequestMapping(value = "/countries", method = RequestMethod.GET)
    public String listCountrys(Model model,@ModelAttribute("country") Country country) {
        model.addAttribute("country", new Country());
        model.addAttribute("listCountrys", this.countryService.listCountrys());
        return "country";
    }
     
    //For add and update person both
    @RequestMapping(value= "/country/add", method = RequestMethod.POST)
    public String addCountry(@ModelAttribute("country") Country c){
         
        if(c.getId() == 0){
            //new person, add it
            this.countryService.addCountry(c);
        }else{
            //existing person, call update
            this.countryService.updateCountry(c);        }
         
        return "redirect:/countries";
         
    }
     
    @RequestMapping("/removeCountry/{id}")
    public String removeCountry(@PathVariable("id") int id){       
        this.countryService.removeCountry(id);
        return "redirect:/countries";
    }
  
    @RequestMapping("/editCountry/{id}")
    public String editPerson(@PathVariable("id") int id, Model model){
        model.addAttribute("country", this.countryService.getCountryById(id));
        model.addAttribute("listCountrys", this.countryService.listCountrys());
        return "country";
    }


}
