package com.wealthtax.chillifrog.assets;


import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="networthcashother")
public class Networthcashother {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    	
    public String assetName;
    public double assetValue = 0;
    public String assetDescription;
    public String assetRemarks;
	public boolean includeInAssetSwatch;
  	public double valueOfHolding = 0;
    public Timestamp lastUpdated;
    public String editorNotes;
    public Integer assetTypeID;
    public Integer version;
    public double valueofHolidingLocalCurrency=0;
    public double roundedValueofHolding = 0;
    public String currencyFrom;
    public String currencyTo;
    public double currencyRate = 0;
    public String assetClass;
    public Integer profileId;
    public Integer purchaseDay;
    public Integer purchaseMonth;
    public Integer purchaseYear;    
    public double valueofHoldingForeign = 0;
    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Integer getProfileId() {
        return profileId;
    }

    public void setProfileId(Integer profileId) {
        this.profileId = profileId;
    }

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public double getAssetValue() {
        return assetValue;
    }

    public void setAssetValue(double assetValue) {
        this.assetValue = assetValue;
    }

    public String getAssetDescription() {
        return assetDescription;
    }

    public void setAssetDescription(String assetDescription) {
        this.assetDescription = assetDescription;
    }

    public String getAssetRemarks() {
        return assetRemarks;
    }

    public void setAssetRemarks(String assetRemarks) {
        this.assetRemarks = assetRemarks;
    }

    public boolean isIncludeInAssetSwatch() {
        return includeInAssetSwatch;
    }

    public void setIncludeInAssetSwatch(boolean includeInAssetSwatch) {
        this.includeInAssetSwatch = includeInAssetSwatch;
    }

    public double getValueOfHolding() {
        return valueOfHolding;
    }

    public void setValueOfHolding(double valueOfHolding) {
        this.valueOfHolding = valueOfHolding;
    }

    public String getEditorNotes() {
        return editorNotes;
    }

    public void setEditorNotes(String editorNotes) {
        this.editorNotes = editorNotes;
    }

    public Integer getAssetTypeID() {
        return assetTypeID;
    }

    public void setAssetTypeID(Integer assetTypeID) {
        this.assetTypeID = assetTypeID;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public double getValueofHolidingLocalCurrency() {
        return valueofHolidingLocalCurrency;
    }

    public void setValueofHolidingLocalCurrency(double valueofHolidingLocalCurrency) {
        this.valueofHolidingLocalCurrency = valueofHolidingLocalCurrency;
    }

    public double getRoundedValueofHolding() {
        return roundedValueofHolding;
    }

    public void setRoundedValueofHolding(double roundedValueofHolding) {
        this.roundedValueofHolding = roundedValueofHolding;
    }

    public Timestamp getLastUpdated() {
  		return lastUpdated;
  	}

  	public void setLastUpdated(Timestamp lastUpdated) {
  		this.lastUpdated = lastUpdated;
  	}


    public String getCurrencyFrom() {
        return currencyFrom;
    }

    public void setCurrencyFrom(String currencyFrom) {
        this.currencyFrom = currencyFrom;
    }

    public String getCurrencyTo() {
        return currencyTo;
    }

    public void setCurrencyTo(String currencyTo) {
        this.currencyTo = currencyTo;
    }

    public double getCurrencyRate() {
        return currencyRate;
    }

    public void setCurrencyRate(double currencyRate) {
        this.currencyRate = currencyRate;
    }

    public String getAssetClass() {
        return assetClass;
    }

    public void setAssetClass(String assetClass) {
        this.assetClass = assetClass;
    }


	public Integer getPurchaseDay() {
		return purchaseDay;
	}

	public void setPurchaseDay(Integer purchaseDay) {
		this.purchaseDay = purchaseDay;
	}

	public Integer getPurchaseMonth() {
		return purchaseMonth;
	}

	public void setPurchaseMonth(Integer purchaseMonth) {
		this.purchaseMonth = purchaseMonth;
	}

	public Integer getPurchaseYear() {
		return purchaseYear;
	}

	public void setPurchaseYear(Integer purchaseYear) {
		this.purchaseYear = purchaseYear;
	}

	public double getValueofHoldingForeign() {
		return valueofHoldingForeign;
	}

	public void setValueofHoldingForeign(double valueofHoldingForeign) {
		this.valueofHoldingForeign = valueofHoldingForeign;
	}
    
}
