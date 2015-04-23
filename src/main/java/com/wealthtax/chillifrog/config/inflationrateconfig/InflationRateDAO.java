package com.wealthtax.chillifrog.config.inflationrateconfig;

import java.util.List;

/**
 * 
 * @author subhan
 *
 */

public interface InflationRateDAO {
	public void add(InflationRate inflationRate);

	public void update(InflationRate inflationRate);

	public void delete(int inflationRateID);

	public InflationRate getInflationRateByID(int inflationRateID);

	public List<InflationRate> listInflationRate();

}
