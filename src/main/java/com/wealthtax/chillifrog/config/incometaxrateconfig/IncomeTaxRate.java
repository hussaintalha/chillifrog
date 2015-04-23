package com.wealthtax.chillifrog.config.incometaxrateconfig;

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
 * 
 * @author subhan
 *
 */

@Entity
@Table(name = "occincometaxrate")
public class IncomeTaxRate  implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5061892358204362726L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "incomeTaxID")
	private int incomeTaxID;
	
	@Column
	private int yearValue;
	@Column
	private double incometaxRate;
	@Column
	private String createrID;
	@Column
	private Date createdDate;
	@Column
	private String updaterID;
	@Column
	private Date updatedDate;
	@Column
	private int countryID;

	public int getIncomeTaxID() {
		return incomeTaxID;
	}

	public void setIncomeTaxID(int incomeTaxID) {
		this.incomeTaxID = incomeTaxID;
	}

	public int getYearValue() {
		return yearValue;
	}

	public void setYearValue(int yearValue) {
		this.yearValue = yearValue;
	}

	public double getIncometaxRate() {
		return incometaxRate;
	}

	public void setIncometaxRate(double incometaxRate) {
		this.incometaxRate = incometaxRate;
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

	public String getupdaterID() {
		return updaterID;
	}

	public void setupdaterID(String updaterID) {
		updaterID = updaterID;
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
		return "IncomeTaxRate [incomeTaxID=" + incomeTaxID + ", yearValue="
				+ yearValue + ", incometaxRate=" + incometaxRate
				+ ", createrID=" + createrID + ", createdDate=" + createdDate
				+ ", updaterID=" + updaterID + ", updatedDate="
				+ updatedDate + ", countryID=" + countryID + "]";
	}

}
