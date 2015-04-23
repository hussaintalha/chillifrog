package com.wealthtax.chillifrog.config.spendingratesconfig;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wealthtax.chillifrog.config.incometaxrateconfig.IncomeTaxRate;

@Repository
public class SpendingRatesDAOImpl implements SpendingRatesDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void add(SpendingRates spendingRates) {
		sessionFactory.getCurrentSession().save(spendingRates);

	}

	@Override
	public void update(SpendingRates spendingRates) {
		sessionFactory.getCurrentSession().update(spendingRates);

	}

	@Override
	public void delete(int spendingRateID) {
		sessionFactory.getCurrentSession().delete(getSpendingRatesByID(spendingRateID));

	}

	@Override
	public SpendingRates getSpendingRatesByID(int spendingRateID) {
		return (SpendingRates) sessionFactory.getCurrentSession().get(
				SpendingRates.class, spendingRateID);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SpendingRates> listSpendingRates() {
		return sessionFactory.getCurrentSession()
				.createQuery("from SpendingRates ").list();

	}

}
