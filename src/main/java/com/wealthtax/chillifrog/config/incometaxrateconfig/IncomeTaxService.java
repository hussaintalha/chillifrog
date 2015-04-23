package com.wealthtax.chillifrog.config.incometaxrateconfig;

import java.util.List;

/**
 * 
 * @author subhan
 *
 */

public interface IncomeTaxService {
	public void add(IncomeTaxRate incomeTaxRate);

	public void update(IncomeTaxRate incomeTaxRate);

	public void delete(int incomeTaxID);

	public IncomeTaxRate getIncomeTaxRateByID(int incomeTaxID);

	public List<IncomeTaxRate> listIncomeTaxRate();

}
