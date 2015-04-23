package com.wealthtax.chillifrog.config.inflationrateconfig;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wealthtax.chillifrog.config.countryconfig.CountryDAO;


public class InflationRateServiceImpl implements InflationRateService {
	
	@Autowired
	private InflationRateDAO inflationRateDAO;
	
	public void setInflationRateDAO(InflationRateDAO inflationRateDAO) {
		this.inflationRateDAO = inflationRateDAO;
	}

	@Transactional
	public void add(InflationRate inflationRate) {
		this.inflationRateDAO.add(inflationRate);

	}

	@Transactional
	public void update(InflationRate inflationRate) {
		inflationRateDAO.update(inflationRate);

	}

	@Transactional
	public void delete(int inflationRateID) {
		inflationRateDAO.delete(inflationRateID);

	}

	@Transactional
	public InflationRate getInflationRateByID(int inflationRateID) {

		return this.inflationRateDAO.getInflationRateByID(inflationRateID);

	}

	@Transactional
	public List<InflationRate> listInflationRate() {

		return this.inflationRateDAO.listInflationRate();
	}

}
