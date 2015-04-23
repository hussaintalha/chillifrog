package com.wealthtax.chillifrog.config.countryconfig;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

public class CountryServiceImpl implements CountryService{

	public CountryDAO countryDAO;


	public void setCountryDAO(CountryDAO countryDAO) {
		this.countryDAO = countryDAO;
	}

	@Override
	@Transactional
	public void addCountry(Country c) {
		this.countryDAO.addCountry(c);	

	}

	@Override
	@Transactional
	public void updateCountry(Country c) {
		this.countryDAO.updateCountry(c);
	}

	@Override
	@Transactional
	public List<Country> listCountrys() {
		return this.countryDAO.listCountrys();
	}

	@Override
	@Transactional
	public Country getCountryById(int id) {
		return this.countryDAO.getCountryById(id);
		}

	@Override
	@Transactional
	public void removeCountry(int id) {
        this.countryDAO.removeCountry(id);
		
	}

}
