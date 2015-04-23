package com.wealthtax.chillifrog.config.countryconfig;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CountryDAOImpl implements CountryDAO{
	private static final Logger logger = LoggerFactory.getLogger(CountryDAOImpl.class);

	private SessionFactory sessionFactory;
    
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

	@Override
	public void addCountry(Country c) {
		 Session session = this.sessionFactory.getCurrentSession();
	        session.persist(c);
	        logger.info("Country saved successfully, Country Details="+c);
	}

	@Override
	public void updateCountry(Country c) {
		 Session session = this.sessionFactory.getCurrentSession();
	        session.update(c);
	        logger.info("Country updated successfully, Update Details="+c);
	}

	@Override
	public List<Country> listCountrys() {
		 Session session = this.sessionFactory.getCurrentSession();
	        List<Country> countryList = session.createQuery("from Country").list();
	        for(Country c : countryList){
	            logger.info("Country List::"+c);
	        }
	        return countryList;
	}

	@Override
	public Country getCountryById(int id) {
		 Session session = this.sessionFactory.getCurrentSession();     
	        Country c = (Country) session.load(Country.class, new Integer(id));
	        logger.info("Country loaded successfully, Country details="+c);
	        return c;
	}

	@Override
	public void removeCountry(int id) {
		Session session = this.sessionFactory.getCurrentSession();
        Country c = (Country) session.load(Country.class, new Integer(id));
        if(null != c){
            session.delete(c);
        }
        logger.info("Country deleted successfully, country details="+c);
   
	}
	
}
