package com.wealthtax.chillifrog.config.spendingratesconfig;

import java.util.List;

public interface SpendingRatesService {
	public void add(SpendingRates spendingRates);

	public void update(SpendingRates spendingRates);

	public void delete(int spendingRateID);

	public SpendingRates getSpendingRatesByID(int spendingRateID);

	public List<SpendingRates> listSpendingRates();

}
