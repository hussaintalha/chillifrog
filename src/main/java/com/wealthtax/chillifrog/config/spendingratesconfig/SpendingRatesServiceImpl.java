package com.wealthtax.chillifrog.config.spendingratesconfig;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class SpendingRatesServiceImpl implements SpendingRatesService {
	@Autowired
	private SpendingRatesDAO spendingRatesDAO;

	public void setSpendingRatesDAO(SpendingRatesDAO spendingRatesDAO) {
		this.spendingRatesDAO = spendingRatesDAO;
	}

	@Override
	@Transactional
	public void add(SpendingRates spendingRates) {
		spendingRatesDAO.add(spendingRates);

	}

	@Override
	@Transactional
	public void update(SpendingRates spendingRates) {
		spendingRatesDAO.update(spendingRates);

	}

	@Override
	@Transactional
	public void delete(int spendingRateID) {
		spendingRatesDAO.delete(spendingRateID);

	}

	@Override
	@Transactional
	public SpendingRates getSpendingRatesByID(int spendingRateID) {

		return spendingRatesDAO.getSpendingRatesByID(spendingRateID);
	}

	@Override
	@Transactional
	public List<SpendingRates> listSpendingRates() {

		return spendingRatesDAO.listSpendingRates();
	}

}
