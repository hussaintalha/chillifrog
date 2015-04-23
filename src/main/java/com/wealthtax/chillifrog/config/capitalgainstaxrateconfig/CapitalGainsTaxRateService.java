package com.wealthtax.chillifrog.config.capitalgainstaxrateconfig;

import java.util.List;

public interface CapitalGainsTaxRateService {
	public void add(CapitalGainsTaxRate capitalGainsTaxRate);

	public void update(CapitalGainsTaxRate capitalGainsTaxRate);

	public List<CapitalGainsTaxRate> listCapitalGainsTaxRates();

	public CapitalGainsTaxRate getCapitalGainsTaxRateById(int capitalGainrateID);

	public void removeCapitalGainsTaxRate(int capitalGainrateID);
}
