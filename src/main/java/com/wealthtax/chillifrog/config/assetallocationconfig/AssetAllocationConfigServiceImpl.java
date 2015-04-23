package com.wealthtax.chillifrog.config.assetallocationconfig;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wealthtax.chillifrog.config.assetallocationconfig.AssetAllocationConfig;
import com.wealthtax.chillifrog.config.assetallocationconfig.AssetAllocationConfigDAO;

@Service
public class AssetAllocationConfigServiceImpl implements
		AssetAllocationConfigService {

	@Autowired
	public AssetAllocationConfigDAO assetAllocationConfigDAO;

	public void setAssetAllocationConfigDAO(
			AssetAllocationConfigDAO assetAllocationConfigDAO) {
		this.assetAllocationConfigDAO = assetAllocationConfigDAO;
	}

	@Transactional
	public void addAssetAllocationConfig(AssetAllocationConfig c) {
		this.assetAllocationConfigDAO.addAssetAllocationConfig(c);

	}

	@Transactional
	public void updateAssetAllocationConfig(AssetAllocationConfig c) {
		this.assetAllocationConfigDAO.updateAssetAllocationConfig(c);
	}

	@Transactional
	public List<AssetAllocationConfig> listAssetAllocationConfigs() {
		return this.assetAllocationConfigDAO.listAssetAllocationConfigs();
	}

	@Transactional
	public AssetAllocationConfig getAssetAllocationConfigById(int id) {
		return this.assetAllocationConfigDAO.getAssetAllocationConfigById(id);
	}

	@Transactional
	public void removeAssetAllocationConfig(int id) {
		this.assetAllocationConfigDAO.removeAssetAllocationConfig(id);
		;

	}

}
