package com.wealthtax.chillifrog.assets;

import java.util.List;

public interface AssetsService {
	
    public void addAssets(Object p);
    public void updateAssets(Object p);
    public List<Assets> listOfPropertyAssets(int profileId);
    public Object getAssetsById(int id, String assetClass);
    public void removeAssets(int id, String assetClass);
    public List<AssetType> listOfAssetTypes();
    public List<Assets> listOfLiquidAssets(int profileId);
    public int roundActualAmount (Double actualAmount);
}
