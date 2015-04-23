package com.wealthtax.chillifrog.config.equitymarketreturnsconfig;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class EquityMarketReturnsDAOImpl implements EquityMarketReturnsDAO {
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void add(EquityMarketReturns equityMarketReturns) {
		sessionFactory.getCurrentSession().save(equityMarketReturns);

	}

	@Override
	public void update(EquityMarketReturns equityMarketReturns) {
		sessionFactory.getCurrentSession().update(equityMarketReturns);

	}

	@Override
	public void delete(int equityMarketID) {

		sessionFactory.getCurrentSession().delete(
				getEquityMarketByID(equityMarketID));
	}

	@Override
	public EquityMarketReturns getEquityMarketByID(int equityMarketID) {
		return (EquityMarketReturns) sessionFactory.getCurrentSession().get(
				EquityMarketReturns.class, equityMarketID);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EquityMarketReturns> listEquityMarketReturns() {

		return sessionFactory.getCurrentSession()
				.createQuery("from EquityMarketReturns").list();

	}

}
