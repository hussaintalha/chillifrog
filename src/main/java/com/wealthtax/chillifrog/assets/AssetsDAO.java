package com.wealthtax.chillifrog.assets;

import java.util.List;

public interface AssetsDAO {
	public void addAssests(Object p);
    public void updateAssests(Object p);
    public List<Assets> listOfPropertyAssets(int profileId);
    public Object getAssetsById(int id, String assetClass);
    public void removeAssets(Integer id, String assetClass);
    public List<AssetType> listOfAssets();
    public List<Assets> listOfLiquidAssets(int profileId);

}
