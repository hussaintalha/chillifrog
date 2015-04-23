package com.wealthtax.chillifrog.config.taxformulainforconfig;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wealthtax.chillifrog.utils.CollectionUtil;

public class TaxFormulaInformationDAOImpl implements TaxFormulaInformationDAO {
	private static final Logger logger = LoggerFactory
			.getLogger(TaxFormulaInformationDAOImpl.class);
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addTaxFormulaInformation(
			TaxFormulaInformation taxFormulaInformation) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(taxFormulaInformation);
		logger.info("TaxFormulaInformation saved successfully,TaxFormulaInformation Details="
				+ taxFormulaInformation);

	}

	@Override
	public void updateTaxFormulaInformation(
			TaxFormulaInformation taxFormulaInformation) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(taxFormulaInformation);
		logger.info("TaxFormulaInformation updated successfully,TaxFormulaInformation Details="
				+ taxFormulaInformation);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TaxFormulaInformation> listTaxFormulaInformation() {
		Session session = this.sessionFactory.getCurrentSession();
		List<TaxFormulaInformation> taxFormulaInformationList = session
				.createQuery("from TaxFormulaInformation").list();
		if(CollectionUtil.isNotEmpty(taxFormulaInformationList)){
			for (TaxFormulaInformation taxFormulaInformation : taxFormulaInformationList) {
				logger.info("TaxFormulaInformation List::" + taxFormulaInformation);
			}
		}
		return taxFormulaInformationList;

	}

	@Override
	public TaxFormulaInformation getTaxFormulaInformationById(int taxFormulId) {
		Session session = this.sessionFactory.getCurrentSession();
		TaxFormulaInformation taxFormulaInformation = (TaxFormulaInformation) session
				.load(TaxFormulaInformation.class, new Integer(taxFormulId));
		logger.info("TaxFormulaInformation loaded succetssfully, TaxFormulaInformation details="
				+ taxFormulaInformation);
		return taxFormulaInformation;

	}

	@Override
	public void removeTaxFormulaInformation(int taxFormulId) {
		Session session = this.sessionFactory.getCurrentSession();
		TaxFormulaInformation taxFormulaInformation = (TaxFormulaInformation) session
				.load(TaxFormulaInformation.class, new Integer(taxFormulId));
		if (null != taxFormulaInformation) {
			session.delete(taxFormulaInformation);
		}
		logger.info("TaxFormulaInformation deleted successfully, taxFormulaInformation details="
				+ taxFormulaInformation);

	}

}
