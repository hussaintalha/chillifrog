package com.wealthtax.chillifrog.config.dividenttaxratesconfig;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DividentTaxRatesDAOImpl implements DividentTaxRatesDAO{

	private static final Logger logger = LoggerFactory.getLogger(DividentTaxRatesDAOImpl.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	@Override
	public void addDividentTaxRates(DividentTaxRates d) {
		 Session session = this.sessionFactory.getCurrentSession();
	        session.persist(d);
	        logger.info("DividentTaxRates saved successfully, DividentTaxRates Details="+d);
	}

	@Override
	public void updateDividentTaxRates(DividentTaxRates d) {
		Session session = this.sessionFactory.getCurrentSession();
        session.update(d);
        logger.info("Country updated successfully, Update Details="+d);
}
		
	

	@Override
	public List<DividentTaxRates> listDividentTaxRates() {
		Session session = this.sessionFactory.getCurrentSession();
        List<DividentTaxRates> dividentTaxRatesList = session.createQuery("from DividentTaxRates").list(); 
        for(DividentTaxRates d:dividentTaxRatesList){
        	logger.info("DividentTaxRates List::"+d);
        }
        return dividentTaxRatesList;
	}

	@Override
	public DividentTaxRates getDividentTaxRatesById(int id) {
		 Session session = this.sessionFactory.getCurrentSession();     
		 DividentTaxRates d = (DividentTaxRates) session.load(DividentTaxRates.class, new Integer(id));
	        logger.info("DividentTaxRates loaded successfully, DividentTaxRates details="+d);
	        return d;

		}

	@Override
	public void removeDividentTaxRates(int id) {
		 Session session = this.sessionFactory.getCurrentSession();
		 DividentTaxRates d = (DividentTaxRates) session.load(DividentTaxRates.class, new Integer(id));
	        if(null != d){
	            session.delete(d);
	        }
	        logger.info("DividentTaxRates deleted successfully, DividentTaxRates details="+d); 
		
	}

}
