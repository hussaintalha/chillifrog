package com.wealthtax.chillifrog.config.taxformulainforconfig;

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
@Table(name = "occtaxformulaiinfor")
public class TaxFormulaInformation implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "taxFormuldID")
	private int taxFormulId;

	@Column(name = "yearValue")
	private int yearValue;

	@Column(name = "rangeFrom")
	private float rangeFrom;

	@Column(name = "rangeTo")
	private float rangeTo;
	
	@Column(name = "Formula")
	private String Formula;
	
	@Column(name = "countryID")
	private int countryId;

	@Column(name = "createrID")
	private String createrId;

	@Column(name = "createdDate")
	private Date createdDate;

	@Column(name = "updaterID")
	private String updaterID;

	@Column(name = "updatedDate")
	private Date updatedDate;

	public int getTaxFormulId() {
		return taxFormulId;
	}

	public void setTaxFormulId(int taxFormulId) {
		this.taxFormulId = taxFormulId;
	}

	public int getYearValue() {
		return yearValue;
	}

	public void setYearValue(int yearValue) {
		this.yearValue = yearValue;
	}

	public float getRangeFrom() {
		return rangeFrom;
	}

	public void setRangeFrom(float rangeFrom) {
		this.rangeFrom = rangeFrom;
	}

	public float getRangeTo() {
		return rangeTo;
	}

	public void setRangeTo(float rangeTo) {
		this.rangeTo = rangeTo;
	}

	public String getFormula() {
		return Formula;
	}

	public void setFormula(String formula) {
		Formula = formula;
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
		return "TaxFormulaInformation [taxFormulId=" + taxFormulId
				+ ", yearValue=" + yearValue + ", rangeFrom=" + rangeFrom
				+ ", rangeTo=" + rangeTo + ", countryId=" + countryId
				+ ", createrId=" + createrId + ", createdDate=" + createdDate
				+ ", updaterID=" + updaterID + ", updatedDate=" + updatedDate
				+ "]";
	}

}
