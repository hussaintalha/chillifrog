package com.wealthtax.chillifrog.config.assetallocationconfig;

import java.util.List;

import com.wealthtax.chillifrog.config.assetallocationconfig.AssetAllocationConfig;

public interface AssetAllocationConfigService {
	public void addAssetAllocationConfig(AssetAllocationConfig c);
    public void updateAssetAllocationConfig(AssetAllocationConfig c);
    public List<AssetAllocationConfig> listAssetAllocationConfigs();
    public AssetAllocationConfig getAssetAllocationConfigById(int id);
    public void removeAssetAllocationConfig(int id);

}
