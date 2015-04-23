package com.wealthtax.chillifrog.config.dividenttaxratesconfig;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="occdividenttaxrates")
public class DividentTaxRates {
	@Id
	@Column(name="dividentTaxID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int dividentTaxID ;
	private int yearValue;
	private int dividenttaxRate;
	private int countryID;
	private String createrID;
	private Date createdDate;
	private String updaterID;
	private Date updatedDate;
	
	public int getDividentTaxID() {
		return dividentTaxID;
	}
	public void setDividentTaxID(int dividentTaxID) {
		this.dividentTaxID = dividentTaxID;
	}
	public int getYearValue() {
		return yearValue;
	}
	public void setYearValue(int yearValue) {
		this.yearValue = yearValue;
	}
	public int getDividenttaxRate() {
		return dividenttaxRate;
	}
	public void setDividenttaxRate(int dividenttaxRate) {
		this.dividenttaxRate = dividenttaxRate;
	}
	public int getCountryID() {
		return countryID;
	}
	public void setCountryID(int countryID) {
		this.countryID = countryID;
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
	
	
	@Override
	public String toString() {
	
		return "dividentTaxID"+dividentTaxID+"YearValue"+yearValue+ "DividenttaxRate"+dividenttaxRate+ "CountryID"+countryID+
				"CreaterID"+createrID+ "CreatedDate"+createdDate+"UpdaterID"+updaterID+"UpdatedDate"+updatedDate;
	
	}
}
