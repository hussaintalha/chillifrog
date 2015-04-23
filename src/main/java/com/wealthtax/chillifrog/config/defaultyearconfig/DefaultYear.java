package com.wealthtax.chillifrog.config.defaultyearconfig;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="occDefaultYear")
public class DefaultYear {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private int defaultYearID;
	@Column
	private String typeID;
	@Column
	private int defaultValue;
	@Column	
	private int preStartingYear;
	@Column
	private int preYearValue;
	@Column
	private int countryID;
	@Column
	private int createrID;
	@Column
	private Date createdDate;
	@Column
	private int updaterID;
	@Column
	private Date updatedDate;
	
	public int getDefaultYearID() {
		return defaultYearID;
	}
	public void setDefaultYearID(int defaultYearID) {
		this.defaultYearID = defaultYearID;
	}
	public String getTypeID() {
		return typeID;
	}
	public void setTypeID(String typeID) {
		this.typeID = typeID;
	}
	public int getDefaultValue() {
		return defaultValue;
	}
	public void setDefaultValue(int defaultValue) {
		this.defaultValue = defaultValue;
	}
	public int getPreStartingYear() {
		return preStartingYear;
	}
	public void setPreStartingYear(int preStartingYear) {
		this.preStartingYear = preStartingYear;
	}
	public int getPreYearValue() {
		return preYearValue;
	}
	public void setPreYearValue(int preYearValue) {
		this.preYearValue = preYearValue;
	}
	public int getCountryID() {
		return countryID;
	}
	public void setCountryID(int countryID) {
		this.countryID = countryID;
	}
	public int getCreaterID() {
		return createrID;
	}
	public void setCreaterID(int createrID) {
		this.createrID = createrID;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public int getUpdaterID() {
		return updaterID;
	}
	public void setUpdaterID(int updaterID) {
		this.updaterID = updaterID;
	}
	@Override
	public String toString() {
		return "DefaultYear [defaultYearID=" + defaultYearID + ", typeID="
				+ typeID + ", defaultValue=" + defaultValue
				+ ", preStartingYear=" + preStartingYear + ", preYearValue="
				+ preYearValue + ", countryID=" + countryID + ", createrID="
				+ createrID + ", createdDate=" + createdDate + ", updaterID="
				+ updaterID + ", updatedDate=" + updatedDate + "]";
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	
} 
