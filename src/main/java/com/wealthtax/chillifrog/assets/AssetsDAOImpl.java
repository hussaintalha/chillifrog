package com.wealthtax.chillifrog.assets;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.wealthtax.chillifrog.Person;
import com.wealthtax.chillifrog.util.Constant;
import com.wealthtax.chillifrog.util.Currency;

@Repository
public class AssetsDAOImpl implements AssetsDAO {

	private static final Logger logger = LoggerFactory
			.getLogger(AssetsDAOImpl.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public void addAssests(Object p) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
		logger.info("Assets saved successfully, Assets Details=" + p);

	}

	@Override
	public void updateAssests(Object p) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
		logger.info("Assets updated successfully, Assets Details=" + p);
	}

	@Override
	public List<Assets> listOfPropertyAssets(int profileId) {
		// TODO Auto-generated method stub
		Query query = this.sessionFactory
				.getCurrentSession()
				.createQuery(
						"select ast from Assets ast WHERE ast.profileId=:profileId")
				.setInteger("profileId", profileId);
		List<Assets> result = (List<Assets>) query.list();
		return result;
	}

	@Override
	public List<Assets> listOfLiquidAssets(int profileId) {
		// TODO Auto-generated method stub
		Query query = this.sessionFactory
				.getCurrentSession()
				.createQuery(
						"select net from Networthcashother net WHERE net.profileId=:profileId")
				.setInteger("profileId", profileId);
		List<Assets> result = (List<Assets>) query.list();
		return result;
	}

	@Override
	public Object getAssetsById(int id, String assetClass) {
		// TODO Auto-generated method stub
		Object p = null;
		Session session = this.sessionFactory.getCurrentSession();
		if (assetClass.equals(Constant.LIQUID_ASSET)) {
			p = (Networthcashother) session.load(Networthcashother.class, new Integer(id));
		} else {
			p = (Assets) session.load(Assets.class, new Integer(id));
		}
		logger.info("Assets loaded successfully, Assets details=" + p);
		return p;
	}

	@Override
	public void removeAssets(Integer id, String assetClass) {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		Object p = null;
		if (id !=null) {
			if (assetClass.equals(Constant.LIQUID_ASSET)) {
				p = (Networthcashother) session.load(Networthcashother.class, new Integer(id));
				session.delete(p);
			} else {
				p = (Assets) session.load(Assets.class, new Integer(id));
				session.delete(p);
			}
		}
		logger.info("Assets deleted successfully, Assets details=" + p);
	}

	@Override
	public List<AssetType> listOfAssets() {
		// TODO Auto-generated method stub
		Session session = this.sessionFactory.getCurrentSession();
		List<AssetType> assetsList = session.createQuery("from AssetType")
				.list();
		return assetsList;
	}

}
