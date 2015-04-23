package com.wealthtax.chillifrog.config.taxformulainforconfig;

import java.util.List;

/**
 * 
 * @author subhan
 *
 */

public interface TaxFormulaInformationDAO {
	public void addTaxFormulaInformation(
			TaxFormulaInformation taxFormulaInformation);

	public void updateTaxFormulaInformation(
			TaxFormulaInformation taxFormulaInformation);

	public List<TaxFormulaInformation> listTaxFormulaInformation();

	public TaxFormulaInformation getTaxFormulaInformationById(int taxFormulId);

	public void removeTaxFormulaInformation(int taxFormulId);
}
