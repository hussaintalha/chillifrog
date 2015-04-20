package com.wealthtax.chillifrog.assets;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.wealthtax.chillifrog.util.RoundingOff;


public class AssetsServiceImpl implements AssetsService{

    private AssetsDAO assetsDAO;
    
    public void setAssetsDAO(AssetsDAO assetsDAO) {
        this.assetsDAO = assetsDAO;
    }

	@Override
	@Transactional
	public void addAssets(Object p) {
		// TODO Auto-generated method stub
		   this.assetsDAO.addAssests(p);		
	}

	@Override
	@Transactional
	public void updateAssets(Object p) {
		// TODO Auto-generated method stub
		   this.assetsDAO.updateAssests(p);
	}

	@Override
	@Transactional
	public List<Assets> listOfPropertyAssets(int profileId) {
		// TODO Auto-generated method stub
        return this.assetsDAO.listOfPropertyAssets(profileId);
	}

	@Override
	@Transactional
	public List<Assets> listOfLiquidAssets(int profileId) {
		// TODO Auto-generated method stub
        return this.assetsDAO.listOfLiquidAssets(profileId);
	}
	
	@Override
	@Transactional
	public Object getAssetsById(int id, String assetClass) {
		// TODO Auto-generated method stub
        return this.assetsDAO.getAssetsById(id, assetClass);
	}

	@Override
	@Transactional
	public void removeAssets(int id, String assetClass) {
		// TODO Auto-generated method stub
        this.assetsDAO.removeAssets(id,assetClass);
		
	}

	@Override
	@Transactional
	public List<AssetType> listOfAssetTypes() {
		// TODO Auto-generated method stub
		return this.assetsDAO.listOfAssets();
	}

	@Override
	public int roundActualAmount(Double actualAmount) {
		// TODO Auto-generated method stub
		return new RoundingOff().roundValue(actualAmount);
	}
}
