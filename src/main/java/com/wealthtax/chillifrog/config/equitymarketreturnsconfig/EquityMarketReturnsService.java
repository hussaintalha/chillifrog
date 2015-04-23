package com.wealthtax.chillifrog.config.equitymarketreturnsconfig;

import java.util.List;

public interface EquityMarketReturnsService {
	public void add(EquityMarketReturns equityMarketReturns);

	public void update(EquityMarketReturns equityMarketReturns);

	public void delete(int equityMarketID);

	public EquityMarketReturns getEquityMarketByID(int equityMarketID);

	public List<EquityMarketReturns> listEquityMarketReturns();

}
