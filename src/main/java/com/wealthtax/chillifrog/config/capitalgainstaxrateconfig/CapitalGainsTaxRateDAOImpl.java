package com.wealthtax.chillifrog.config.capitalgainstaxrateconfig;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
@Repository
public class CapitalGainsTaxRateDAOImpl implements CapitalGainsTaxRateDAO {
	private static final Logger logger = LoggerFactory
			.getLogger(CapitalGainsTaxRateDAOImpl.class);
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void add(CapitalGainsTaxRate capitalGainsTaxRate) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(capitalGainsTaxRate);
		logger.info("CapitalGainsTaxRate saved successfully, CapitalGainsTaxRate Details="
				+ capitalGainsTaxRate);

	}

	@Override
	public void update(CapitalGainsTaxRate capitalGainsTaxRate) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(capitalGainsTaxRate);
		logger.info("CapitalGainsTaxRate updated successfully, Update Details="
				+ capitalGainsTaxRate);

	}

	@Override
	public List<CapitalGainsTaxRate> listCapitalGainsTaxRates() {

		Session session = this.sessionFactory.getCurrentSession();
		List<CapitalGainsTaxRate> capitalGainsTaxRateList = session
				.createQuery("from CapitalGainsTaxRate").list();
		for (CapitalGainsTaxRate capitalGainsTaxRate : capitalGainsTaxRateList) {
			logger.info("CapitalGainsTaxRate List::" + capitalGainsTaxRate);
		}
		return capitalGainsTaxRateList;

	}

	@Override
	public CapitalGainsTaxRate getCapitalGainsTaxRateById(int capitalGainrateID) {
		Session session = this.sessionFactory.getCurrentSession();
		CapitalGainsTaxRate capitalGainsTaxRate = (CapitalGainsTaxRate) session
				.load(CapitalGainsTaxRate.class, new Integer(capitalGainrateID));
		logger.info("CapitalGainsTaxRate loaded successfully, CapitalGainsTaxRate details="
				+ capitalGainsTaxRate);
		return capitalGainsTaxRate;

	}

	@Override
	public void removeCapitalGainsTaxRate(int capitalGainrateID) {
		Session session = this.sessionFactory.getCurrentSession();
		CapitalGainsTaxRate capitalGainsTaxRate = (CapitalGainsTaxRate) session
				.load(CapitalGainsTaxRate.class, new Integer(capitalGainrateID));
		if (null != capitalGainsTaxRate) {
			session.delete(capitalGainsTaxRate);
		}
		logger.info("CapitalGainsTaxRate deleted successfully, country details="
				+ capitalGainsTaxRate);

	}

}
