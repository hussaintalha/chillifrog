package com.wealthtax.chillifrog.cashflow;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;


@Repository
public class CashFlowDaoImpl implements CashFlowDao {

	private static final Logger logger = LoggerFactory
			.getLogger(CashFlowDaoImpl.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public void addCashFlow(CashFlow p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("CashFlow saved successfully, CashFlow Details=" + p);

	}

	@Override
	public void updateCashFlow(CashFlow p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("Cashflow updated successfully, CashFlow Details=" + p);
	}

	@Override
	public List<CashFlow> listCashFlow() {
		 Session session = this.sessionFactory.getCurrentSession();
	        List<CashFlow> cashFlowList = session.createQuery("from CashFlow").list();
	        for(CashFlow p : cashFlowList){
	            logger.info("Cashflow List::"+p);
	        }
	        return cashFlowList;
	}

	@Override
	public CashFlow getCashFlowById(int id) {
        Session session = this.sessionFactory.getCurrentSession();     
        CashFlow p = (CashFlow) session.load(CashFlow.class, new Integer(id));
        logger.info("Cashflow loaded successfully, CashFlow details="+p);
        return p;		
	}

	@Override
	public void removeCashFlow(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        CashFlow p = (CashFlow) session.load(CashFlow.class, new Integer(id));
        if(null != p){
            session.delete(p);
        }
        logger.info("Cashflow deleted successfully, CashFlow details="+p);
	}

    @Override
    public List<CashFlowType> getCashFlowType() {   
     Session session = sessionFactory.getCurrentSession();
       List<CashFlowType> cashFlowTypeList = session.createQuery("from CashFlowType").list();
	        for(CashFlowType cft : cashFlowTypeList){
	            logger.info("CashFlowType List::" + cft);
	        }
	        return cashFlowTypeList;
     
    }

}
