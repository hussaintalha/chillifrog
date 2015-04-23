package com.wealthtax.chillifrog.config.dividenttaxratesconfig;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

public class DividentTaxRatesServiceImpl implements DividentTaxRatesService{
	
	public DividentTaxRatesDAO dividentTaxRatesDAO;

	public DividentTaxRatesDAO getDividentTaxRatesDAO() {
		return dividentTaxRatesDAO;
	}

	public void setDividentTaxRatesDAO(DividentTaxRatesDAO dividentTaxRatesDAO) {
		this.dividentTaxRatesDAO = dividentTaxRatesDAO;
	}

	
	@Override
    @Transactional
	public void addDividentTaxRates(DividentTaxRates c) {
           this.dividentTaxRatesDAO.addDividentTaxRates(c);		
		
	}

	@Override
	@Transactional
	public void updateDividentTaxRates(DividentTaxRates c) {
            this.dividentTaxRatesDAO.updateDividentTaxRates(c);
	}

	@Override
	@Transactional
	public List<DividentTaxRates> listDividentTaxRates() {
	return this.dividentTaxRatesDAO.listDividentTaxRates();	
	}

	@Override
	@Transactional
	public DividentTaxRates getDividentTaxRatesById(int id) {
		return this.dividentTaxRatesDAO.getDividentTaxRatesById(id);
	
	}

	@Override
	@Transactional
	public void removeDividentTaxRates(int id) {
		this.dividentTaxRatesDAO.removeDividentTaxRates(id);
	}

}
