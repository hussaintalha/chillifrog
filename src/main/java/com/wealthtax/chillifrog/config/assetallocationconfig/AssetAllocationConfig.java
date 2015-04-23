package com.wealthtax.chillifrog.config.assetallocationconfig;

import java.io.Serializable;
import java.util.Date;
/**
 * 
 * @author Subhan
 * 
 */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author subhan
 *
 */
@Entity
@Table(name = "occassetallocationconfig")
public class AssetAllocationConfig implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8895775481237728358L;
	@Id
	@Column(name = "assetConfigID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int assetConfigID;
	@Column(name = "percentageInStock")
	private int percentageInStock;
	@Column(name = "percentageInCash")
	private int percentageInCash;
	@Column(name = "countryId")
	private int countryId;
	@Column(name = "createrId")
	private String createrId;
	@Column(name = "createdDate")
	private Date createdDate;
	@Column(name = "updaterId")
	private String updaterId;
	@Column(name = "updatedDate")
	private Date updatedDate;

	public int getAssetConfigID() {
		return assetConfigID;
	}

	public void setAssetConfigID(int assetConfigID) {
		this.assetConfigID = assetConfigID;
	}

	public int getPercentageInStock() {
		return percentageInStock;
	}

	public void setPercentageInStock(int percentageInSock) {
		this.percentageInStock = percentageInSock;
	}

	public int getPercentageInCash() {
		return percentageInCash;
	}

	public void setPercentageInCash(int percentageInCash) {
		this.percentageInCash = percentageInCash;
	}

	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public String getCreaterId() {
		return createrId;
	}

	public void setCreaterId(String createrId) {
		this.createrId = createrId;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getUpdaterId() {
		return updaterId;
	}

	public void setUpdaterId(String updaterId) {
		this.updaterId = updaterId;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Override
	public String toString() {
		return "AssetConfigId=" + assetConfigID + ", percentageInStock="
				+ percentageInStock + ",percentageInCash=" + percentageInCash
				+ ",countryId=" + countryId + "+createrId" + createrId
				+ "createdDate" + createdDate + "updaterId=" + updaterId
				+ "updatedDate=" + updatedDate;
	}

}
