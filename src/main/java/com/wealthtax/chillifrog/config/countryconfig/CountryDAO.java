package com.wealthtax.chillifrog.config.countryconfig;

import java.util.List;
public interface CountryDAO {
	public void addCountry(Country c);
    public void updateCountry(Country c);
    public List<Country> listCountrys();
    public Country getCountryById(int id);
    public void removeCountry(int id);
}


