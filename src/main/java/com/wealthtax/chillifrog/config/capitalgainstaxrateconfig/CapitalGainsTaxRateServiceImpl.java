package com.wealthtax.chillifrog.config.capitalgainstaxrateconfig;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



public class CapitalGainsTaxRateServiceImpl implements
		CapitalGainsTaxRateService {
	@Autowired
	private CapitalGainsTaxRateDAO capitalGainsTaxRateDAO;

	public void setCapitalGainsTaxRateDAO(
			CapitalGainsTaxRateDAO capitalGainsTaxRateDAO) {
		this.capitalGainsTaxRateDAO = capitalGainsTaxRateDAO;
	}

	@Override
	@Transactional
	public void add(CapitalGainsTaxRate capitalGainsTaxRate) {
		this.capitalGainsTaxRateDAO.add(capitalGainsTaxRate);

	}

	@Override
	@Transactional
	public void update(CapitalGainsTaxRate capitalGainsTaxRate) {

		this.capitalGainsTaxRateDAO.update(capitalGainsTaxRate);
	}

	@Override
	@Transactional
	public List<CapitalGainsTaxRate> listCapitalGainsTaxRates() {

		return this.capitalGainsTaxRateDAO.listCapitalGainsTaxRates();
	}

	@Override
	@Transactional
	public CapitalGainsTaxRate getCapitalGainsTaxRateById(int capitalGainrateID) {

		return this.capitalGainsTaxRateDAO
				.getCapitalGainsTaxRateById(capitalGainrateID);
	}

	@Override
	@Transactional
	public void removeCapitalGainsTaxRate(int capitalGainrateID) {
		this.capitalGainsTaxRateDAO
				.removeCapitalGainsTaxRate(capitalGainrateID);

	}

}
