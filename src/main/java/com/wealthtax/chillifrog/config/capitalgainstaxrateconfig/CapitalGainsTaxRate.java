package com.wealthtax.chillifrog.config.capitalgainstaxrateconfig;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "occcapitalgainstaxrate")
public class CapitalGainsTaxRate {
	@Id
	@Column(name = "capitalGainrateID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int capitalGainrateID;
	@Column(name = "yearValue")
	private int yearValue;
	@Column(name = "capitalgainstaxRate")
	private float capitalgainstaxRate;
	@Column(name = "countryID")
	private int countryID;
	@Column(name = "createrID")
	private String createrID;
	@Column(name = "createdDate")
	private Date createdDate;
	@Column(name = "updaterID")
	private String updaterID;
	@Column(name = "updatedDate")
	private Date updatedDate;
	public int getCapitalGainrateID() {
		return capitalGainrateID;
	}
	public void setCapitalGainrateID(int capitalGainrateID) {
		this.capitalGainrateID = capitalGainrateID;
	}
	public int getYearValue() {
		return yearValue;
	}
	public void setYearValue(int yearValue) {
		this.yearValue = yearValue;
	}
	public float getCapitalgainstaxRate() {
		return capitalgainstaxRate;
	}
	public void setCapitalgainstaxRate(float capitalgainstaxRate) {
		this.capitalgainstaxRate = capitalgainstaxRate;
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
		return "CapitalGainsTaxRate [capitalGainrateID=" + capitalGainrateID
				+ ", yearValue=" + yearValue + ", capitalgainstaxRate="
				+ capitalgainstaxRate + ", countryID=" + countryID
				+ ", createrID=" + createrID + ", createdDate=" + createdDate
				+ ", updaterID=" + updaterID + ", updatedDate=" + updatedDate
				+ "]";
	}
	

	}
