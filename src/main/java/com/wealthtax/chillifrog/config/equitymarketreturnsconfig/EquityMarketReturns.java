package com.wealthtax.chillifrog.config.equitymarketreturnsconfig;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "occequitymarketreturns")
public class EquityMarketReturns {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "equityMarketID")
	private int equityMarketID;
	
	@Column(name = "yearValue")
	private int yearValue;
	
	@Column(name = "equityMarketReturnRate")
	private float equityMarketReturnRate;
	
	@Column(name = "createrID")
	private String createrID;
	
	@Column(name = "createdDate")
	private Date createdDate;
	
	@Column(name = "updaterID")
	private String updaterID;
	
	@Column(name = "updatedDate")
	private Date updatedDate;
	
	@Column(name = "countryID")
	private int countryID;

	public int getEquityMarketID() {
		return equityMarketID;
	}

	public void setEquityMarketID(int equityMarketID) {
		this.equityMarketID = equityMarketID;
	}

	public int getYearValue() {
		return yearValue;
	}

	public void setYearValue(int yearValue) {
		this.yearValue = yearValue;
	}

	public float getEquityMarketReturnRate() {
		return equityMarketReturnRate;
	}

	public void setEquityMarketReturnRate(float equityMarketReturnRate) {
		this.equityMarketReturnRate = equityMarketReturnRate;
	}

	public String getCreaterID() {
		return createrID;
	}

	public void setCreaterID(String createrID) {
		this.createrID = createrID;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getUpdaterID() {
		return updaterID;
	}

	public void setUpdaterID(String updaterID) {
		this.updaterID = updaterID;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public int getCountryID() {
		return countryID;
	}

	public void setCountryID(int countryID) {
		this.countryID = countryID;
	}

	@Override
	public String toString() {
		return "EquityMarketReturns [equityMarketID=" + equityMarketID
				+ ", yearValue=" + yearValue + ", equityMarketReturnRate="
				+ equityMarketReturnRate + ", createrID=" + createrID
				+ ", createdDate=" + createdDate + ", updaterID=" + updaterID
				+ ", updatedDate=" + updatedDate + ", countryID=" + countryID
				+ "]";
	}

}
