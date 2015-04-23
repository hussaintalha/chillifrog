package com.wealthtax.chillifrog.config.defaultyearconfig;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class DefaultYearServiceImpl implements DefaultYearService {
	@Autowired
	private DefaultYearDAO defaultYearDAO ;
	

	public void setDefaultYearDAO(DefaultYearDAO defaultYearDAO) {
		this.defaultYearDAO = defaultYearDAO;
	}

	@Override
	@Transactional
	public void add(DefaultYear defaultYear) {
		defaultYearDAO.add(defaultYear);
	}

	@Override
	@Transactional
	public void update(DefaultYear defaultYear) {
		defaultYearDAO.update(defaultYear);
	}

	@Override
	@Transactional
	public void delete(int defaultYearID) {
		defaultYearDAO.delete(defaultYearID);
	}

	@Override
	@Transactional
	public DefaultYear getDefaultYearByID(int defaultYearID) {
		return  this. defaultYearDAO.getDefaultYearByID(defaultYearID);
	}

	@Override
	@Transactional
	public List<DefaultYear> listDefaultYears() {
		return this.defaultYearDAO.listDefaultYears();
	}

}
