package com.wealthtax.chillifrog.util;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UtilDAOImpl implements UtilDAO {

	private static final Logger logger = LoggerFactory.getLogger(UtilDAOImpl.class);
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	@Transactional
	public List<Currency> listOfCurrency() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		List<Currency> currencyList = session.createQuery(
				"select cn from Currency cn group by cn.iso_currency").list();
		return currencyList;
	}

	@Override
	@Transactional
	public Currency getFxRate(String currency) {
		// TODO Auto-generated method stub
		Query query = this.sessionFactory.getCurrentSession()
				.createQuery("select cn from Currency cn WHERE cn.iso_currency = :currency GROUP BY cn.iso_currency ORDER BY cn.date DESC")
				.setString("currency", currency);
		query.setMaxResults(1);
		Currency result =(Currency) query.uniqueResult();
		
		return result;
	}

	
	
}
