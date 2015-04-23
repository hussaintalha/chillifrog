package com.wealthtax.chillifrog.config.dividenttaxratesconfig;

import java.util.List;
public interface DividentTaxRatesDAO {
	public void addDividentTaxRates(DividentTaxRates c);
    public void updateDividentTaxRates(DividentTaxRates c);
    public List<DividentTaxRates> listDividentTaxRates();
    public DividentTaxRates getDividentTaxRatesById(int id);
    public void removeDividentTaxRates(int id);
}
