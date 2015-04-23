package com.wealthtax.chillifrog.config.defaultyearconfig;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.wealthtax.chillifrog.config.inflationrateconfig.InflationRate;

@Repository
public class DefaultYearDAOImpl implements DefaultYearDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void add(DefaultYear defaultYear) {
		sessionFactory.getCurrentSession().save(defaultYear);

	}

	@Override
	public void update(DefaultYear defaultYear) {
		sessionFactory.getCurrentSession().update(defaultYear);

	}

	@Override
	public void delete(int defaultYearID) {
		sessionFactory.getCurrentSession().delete(
				getDefaultYearByID(defaultYearID));

	}

	@Override
	public DefaultYear getDefaultYearByID(int defaultYearID) {

		return (DefaultYear) sessionFactory.getCurrentSession().get(
				DefaultYear.class, defaultYearID);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DefaultYear> listDefaultYears() {
		return sessionFactory.getCurrentSession()
				.createQuery("from DefaultYear").list();

	}

}
