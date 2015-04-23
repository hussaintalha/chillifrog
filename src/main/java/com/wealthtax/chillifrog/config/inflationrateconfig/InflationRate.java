package com.wealthtax.chillifrog.config.inflationrateconfig;

import java.io.Serializable;
import java.util.Date;

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
@Table(name = "occinflationrate")
public class InflationRate implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "inflationRateID")
	private Integer inflationRateID;
	
	@Column(name = "yearValue")
	private int yearValue;
	
	@Column(name = "inflationRate")
	private float inflationRate;
	
	@Column(name = "countryID")
	private int countryID;
	
	@Column(name = "createrID")
	private String createrID;
	
	@Column(name = "createdDate")
	private Date createdDate;
	
	@Column(name = "updaterID")
	private String updaterID;
	
	public Integer getInflationRateID() {
		return inflationRateID;
	}

	public void setInflationRateID(Integer inflationRateID) {
		this.inflationRateID = inflationRateID;
	}

	@Column(name = "updatedDate")
	private Date updatedDate;
	
	

	public int getYearValue() {
		return yearValue;
	}

	public void setYearValue(int yearValue) {
		this.yearValue = yearValue;
	}

	

	public float getInflationRate() {
		return inflationRate;
	}

	public void setInflationRate(float inflationRate) {
		this.inflationRate = inflationRate;
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
		return "InflationRate [inflationRateID=" + inflationRateID
				+ ", yearValue=" + yearValue + ", inflationRate="
				+ inflationRate + ", countryID=" + countryID + ", createrID="
				+ createrID + ", createdDate=" + createdDate + ", updaterID="
				+ updaterID + ", updatedDate=" + updatedDate + "]";
	}

}
