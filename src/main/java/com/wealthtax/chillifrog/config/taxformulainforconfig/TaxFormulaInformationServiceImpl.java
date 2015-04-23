package com.wealthtax.chillifrog.config.taxformulainforconfig;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class TaxFormulaInformationServiceImpl implements
		TaxFormulaInformationService {
	@Autowired
	private TaxFormulaInformationDAO taxFormulaInformationDAO;

	public void setTaxFormulaInformationDAO(
			TaxFormulaInformationDAO taxFormulaInformationDAO) {
		this.taxFormulaInformationDAO = taxFormulaInformationDAO;
	}

	@Override
	@Transactional
	public void addTaxFormulaInformation(
			TaxFormulaInformation taxFormulaInformation) {
		taxFormulaInformationDAO
				.addTaxFormulaInformation(taxFormulaInformation);

	}

	@Override
	@Transactional
	public void updateTaxFormulaInformation(
			TaxFormulaInformation taxFormulaInformation) {
		taxFormulaInformationDAO
				.updateTaxFormulaInformation(taxFormulaInformation);

	}

	@Override
	@Transactional
	public List<TaxFormulaInformation> listTaxFormulaInformation() {
		return this.taxFormulaInformationDAO.listTaxFormulaInformation();

	}

	@Override
	@Transactional
	public TaxFormulaInformation getTaxFormulaInformationById(int taxFormulId) {
		return this.taxFormulaInformationDAO
				.getTaxFormulaInformationById(taxFormulId);
	}

	@Override
	@Transactional
	public void removeTaxFormulaInformation(int taxFormulId) {
		taxFormulaInformationDAO.removeTaxFormulaInformation(taxFormulId);

	}

}
