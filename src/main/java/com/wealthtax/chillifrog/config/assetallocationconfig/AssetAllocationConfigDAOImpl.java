package com.wealthtax.chillifrog.config.assetallocationconfig;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AssetAllocationConfigDAOImpl implements AssetAllocationConfigDAO {

	private static final Logger logger = LoggerFactory
			.getLogger(AssetAllocationConfigDAOImpl.class);
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public void addAssetAllocationConfig(AssetAllocationConfig ac) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(ac);
		logger.info("AssetAllocationConfig saved successfully, AssetAllocationConfig Details="
				+ ac);
	}

	@Override
	public void updateAssetAllocationConfig(AssetAllocationConfig ac) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(ac);
		logger.info("AssetAllocationConfig updated successfully, Update Details="
				+ ac);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AssetAllocationConfig> listAssetAllocationConfigs() {
		Session session = this.sessionFactory.getCurrentSession();
		List<AssetAllocationConfig> assetAllocationConfigList = session
				.createQuery("from AssetAllocationConfig").list();
		for (AssetAllocationConfig ac : assetAllocationConfigList) {
			logger.info("AssetAllocationConfigList List::" + ac);
		}
		return assetAllocationConfigList;
	}

	@Override
	public AssetAllocationConfig getAssetAllocationConfigById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		AssetAllocationConfig ac = (AssetAllocationConfig) session.load(
				AssetAllocationConfig.class, new Integer(id));
		logger.info("AssetAllocationConfig loaded successfully, Country details="
				+ ac);
		return ac;
	}

	@Override
	public void removeAssetAllocationConfig(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		AssetAllocationConfig ac = (AssetAllocationConfig) session.load(
				AssetAllocationConfig.class, new Integer(id));
		if (null != ac) {
			session.delete(ac);
		}
		logger.info("AssetAllocationConfig deleted successfully, AssetAllocationConfig details="
				+ ac);
	}
}
