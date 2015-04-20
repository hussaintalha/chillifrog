package com.wealthtax.chillifrog.util;

import java.util.List;

public interface UtilDAO {

	public List<Currency> listOfCurrency();
	public Currency getFxRate(String currency);
	
}
