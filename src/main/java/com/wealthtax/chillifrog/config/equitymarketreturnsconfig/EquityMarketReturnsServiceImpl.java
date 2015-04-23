package com.wealthtax.chillifrog.config.equitymarketreturnsconfig;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class EquityMarketReturnsServiceImpl implements
		EquityMarketReturnsService {
	@Autowired
	private EquityMarketReturnsDAO equityMarketReturnsDAO;

	public void setEquityMarketReturnsDAO(
			EquityMarketReturnsDAO equityMarketReturnsDAO) {
		this.equityMarketReturnsDAO = equityMarketReturnsDAO;
	}

	@Override
	@Transactional
	public void add(EquityMarketReturns equityMarketReturns) {
		equityMarketReturnsDAO.add(equityMarketReturns);


	}

	@Override
	@Transactional
	public void update(EquityMarketReturns equityMarketReturns) {
		
		equityMarketReturnsDAO.update(equityMarketReturns);
	}

	@Override
	@Transactional
	public void delete(int equityMarketID) {
		equityMarketReturnsDAO.delete(equityMarketID);
	}

	@Override
	@Transactional
	public EquityMarketReturns getEquityMarketByID(int equityMarketID) {
		return this.equityMarketReturnsDAO.getEquityMarketByID(equityMarketID);
	}

	@Override
	@Transactional
	public List<EquityMarketReturns> listEquityMarketReturns() {
		return this.equityMarketReturnsDAO.listEquityMarketReturns();		
	}

}
