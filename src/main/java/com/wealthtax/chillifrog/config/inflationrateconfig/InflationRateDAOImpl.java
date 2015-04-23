package com.wealthtax.chillifrog.config.inflationrateconfig;

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
public class InflationRateDAOImpl implements InflationRateDAO {
	
	private SessionFactory sessionFactory;
    
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
	
	
    

	@Override
	public void add(InflationRate inflationRate) {
		sessionFactory.getCurrentSession().save(inflationRate);
	}
	
	
	@Override
	public void update(InflationRate inflationRate) {
		sessionFactory.getCurrentSession().update(inflationRate);

	}

	@Override
	public void delete(int inflationRateID) {
		sessionFactory.getCurrentSession().delete(getInflationRateByID(inflationRateID));

	}

	@Override
	public InflationRate getInflationRateByID(int inflationRateID) {
		
		return (InflationRate) sessionFactory.getCurrentSession().get(
				InflationRate.class, inflationRateID);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<InflationRate> listInflationRate() {

		return sessionFactory.getCurrentSession()
				.createQuery("from InflationRate").list();
	}

}
