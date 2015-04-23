package com.wealthtax.chillifrog.config.assetallocationconfig;

import java.util.List;

public interface AssetAllocationConfigDAO {
	public void addAssetAllocationConfig(AssetAllocationConfig ac);
    public void updateAssetAllocationConfig(AssetAllocationConfig ac);
    public List<AssetAllocationConfig> listAssetAllocationConfigs();
    public AssetAllocationConfig getAssetAllocationConfigById(int id);
    public void removeAssetAllocationConfig(int id);

}
