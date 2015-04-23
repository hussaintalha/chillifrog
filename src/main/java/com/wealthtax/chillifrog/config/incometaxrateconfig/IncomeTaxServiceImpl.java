package com.wealthtax.chillifrog.config.incometaxrateconfig;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class IncomeTaxServiceImpl implements IncomeTaxService {
	@Autowired
	private IncomeTaxRateDAO incomeTaxRateDAO;
	

	public void setIncomeTaxRateDAO(IncomeTaxRateDAO incomeTaxRateDAO) {
		this.incomeTaxRateDAO = incomeTaxRateDAO;
	}

	@Transactional
	public void add(IncomeTaxRate incomeTaxRate) {
		incomeTaxRateDAO.add(incomeTaxRate);

	}

	@Transactional
	public void update(IncomeTaxRate incomeTaxRate) {
		incomeTaxRateDAO.update(incomeTaxRate);

	}

	@Transactional
	public void delete(int incomeTaxID) {
		incomeTaxRateDAO.delete(incomeTaxID);

	}

	@Transactional
	public IncomeTaxRate getIncomeTaxRateByID(int incomeTaxID) {
		return incomeTaxRateDAO.getIncomeTaxRateByID(incomeTaxID);
	}

	@Transactional
	public List<IncomeTaxRate> listIncomeTaxRate() {
		return incomeTaxRateDAO.listIncomeTaxRate();
	}

}
