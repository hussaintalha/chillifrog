package com.wealthtax.chillifrog.config.incometaxrateconfig;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 
 * @author subhan
 *
 */
@Repository
public class IncomeTaxRateDAOImpl implements IncomeTaxRateDAO {
	@Autowired
	private SessionFactory sessionFactory;
	

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void add(IncomeTaxRate incomeTaxRate) {
		sessionFactory.getCurrentSession().save(incomeTaxRate);
	}

	@Override
	public void update(IncomeTaxRate incomeTaxRate) {
		sessionFactory.getCurrentSession().update(incomeTaxRate);

	}

	@Override
	public void delete(int incomeTaxID) {
		sessionFactory.getCurrentSession().delete(
				getIncomeTaxRateByID(incomeTaxID));
	}

	@Override
	public IncomeTaxRate getIncomeTaxRateByID(int incomeTaxID) {

		return (IncomeTaxRate) sessionFactory.getCurrentSession().get(
				IncomeTaxRate.class, incomeTaxID);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<IncomeTaxRate> listIncomeTaxRate() {

		return sessionFactory.getCurrentSession()
				.createQuery("from IncomeTaxRate ").list();

	}

}
