package com.wealthtax.chillifrog.config.spendingratesconfig;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "occspedingrateconfig")
public class SpendingRates {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int spendingRateID;
	@Column
	private String countryID;
	@Column
	private float spendingRate0to75;
	@Column
	private float spendingRate75001to120000;
	@Column
	private float spendingRate120001to300000;
	@Column
	private float spendingRate300001to1M;
	@Column
	private float spendingRate1M1to5M;
	@Column
	private float spendingRate5M1to15M;
	@Column
	private float spendingRate15M1to50M;
	@Column
	private float spendingRate50M1to500M;
	@Column
	private float unexercisableDiscount;
	@Column
	private float stateIncometaxAddition;
	@Column
	private float stateIncometaxMarkUp;
	@Column
	private float localandStateTax;
	@Column
	private float maximumSpendingAmount;
	@Column
	private float minimumSpendingAmount;
	@Column
	private float pre1985IncomeDiscountFactor;
	@Column
	private String createrID;
	@Column
	private Date createdDate;
	@Column
	private String updaterID;
	@Column
	private Date updatedDate;

	public int getSpendingRateID() {
		return spendingRateID;
	}

	public void setSpendingRateID(int spendingRateID) {
		this.spendingRateID = spendingRateID;
	}

	public String getCountryID() {
		return countryID;
	}

	public void setCountryID(String countryID) {
		this.countryID = countryID;
	}

	public float getSpendingRate0to75() {
		return spendingRate0to75;
	}

	public void setSpendingRate0to75(float spendingRate0to75) {
		this.spendingRate0to75 = spendingRate0to75;
	}

	public float getSpendingRate75001to120000() {
		return spendingRate75001to120000;
	}

	public void setSpendingRate75001to120000(float spendingRate75001to120000) {
		this.spendingRate75001to120000 = spendingRate75001to120000;
	}

	public float getSpendingRate120001to300000() {
		return spendingRate120001to300000;
	}

	public void setSpendingRate120001to300000(float spendingRate120001to300000) {
		this.spendingRate120001to300000 = spendingRate120001to300000;
	}

	public float getSpendingRate300001to1M() {
		return spendingRate300001to1M;
	}

	public void setSpendingRate300001to1M(float spendingRate300001to1M) {
		this.spendingRate300001to1M = spendingRate300001to1M;
	}

	public float getSpendingRate1M1to5M() {
		return spendingRate1M1to5M;
	}

	public void setSpendingRate1M1to5M(float spendingRate1M1to5M) {
		this.spendingRate1M1to5M = spendingRate1M1to5M;
	}

	public float getSpendingRate5M1to15M() {
		return spendingRate5M1to15M;
	}

	public void setSpendingRate5M1to15M(float spendingRate5M1to15M) {
		this.spendingRate5M1to15M = spendingRate5M1to15M;
	}

	public float getSpendingRate15M1to50M() {
		return spendingRate15M1to50M;
	}

	public void setSpendingRate15M1to50M(float spendingRate15M1to50M) {
		this.spendingRate15M1to50M = spendingRate15M1to50M;
	}

	public float getSpendingRate50M1to500M() {
		return spendingRate50M1to500M;
	}

	public void setSpendingRate50M1to500M(float spendingRate50M1to500M) {
		this.spendingRate50M1to500M = spendingRate50M1to500M;
	}

	public float getUnexercisableDiscount() {
		return unexercisableDiscount;
	}

	public void setUnexercisableDiscount(float unexercisableDiscount) {
		this.unexercisableDiscount = unexercisableDiscount;
	}

	public float getStateIncometaxAddition() {
		return stateIncometaxAddition;
	}

	public void setStateIncometaxAddition(float stateIncometaxAddition) {
		this.stateIncometaxAddition = stateIncometaxAddition;
	}

	public float getStateIncometaxMarkUp() {
		return stateIncometaxMarkUp;
	}

	public void setStateIncometaxMarkUp(float stateIncometaxMarkUp) {
		this.stateIncometaxMarkUp = stateIncometaxMarkUp;
	}

	public float getLocalandStateTax() {
		return localandStateTax;
	}

	public void setLocalandStateTax(float localandStateTax) {
		this.localandStateTax = localandStateTax;
	}

	public float getMaximumSpendingAmount() {
		return maximumSpendingAmount;
	}

	public void setMaximumSpendingAmount(float maximumSpendingAmount) {
		this.maximumSpendingAmount = maximumSpendingAmount;
	}

	public float getMinimumSpendingAmount() {
		return minimumSpendingAmount;
	}

	public void setMinimumSpendingAmount(float minimumSpendingAmount) {
		this.minimumSpendingAmount = minimumSpendingAmount;
	}

	public float getPre1985IncomeDiscountFactor() {
		return pre1985IncomeDiscountFactor;
	}

	public void setPre1985IncomeDiscountFactor(float pre1985IncomeDiscountFactor) {
		this.pre1985IncomeDiscountFactor = pre1985IncomeDiscountFactor;
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
		return "SpendingRates [spendingRateID=" + spendingRateID
				+ ", countryID=" + countryID + ", spendingRate0to75="
				+ spendingRate0to75 + ", spendingRate75001to120000="
				+ spendingRate75001to120000 + ", spendingRate120001to300000="
				+ spendingRate120001to300000 + ", spendingRate300001to1M="
				+ spendingRate300001to1M + ", spendingRate1M1to5M="
				+ spendingRate1M1to5M + ", spendingRate5M1to15M="
				+ spendingRate5M1to15M + ", spendingRate15M1to50M="
				+ spendingRate15M1to50M + ", spendingRate50M1to500M="
				+ spendingRate50M1to500M + ", unexercisableDiscount="
				+ unexercisableDiscount + ", stateIncometaxAddition="
				+ stateIncometaxAddition + ", stateIncometaxMarkUp="
				+ stateIncometaxMarkUp + ", localandStateTax="
				+ localandStateTax + ", maximumSpendingAmount="
				+ maximumSpendingAmount + ", minimumSpendingAmount="
				+ minimumSpendingAmount + ", pre1985IncomeDiscountFactor="
				+ pre1985IncomeDiscountFactor + ", createrID=" + createrID
				+ ", createdDate=" + createdDate + ", updaterID=" + updaterID
				+ ", updatedDate=" + updatedDate + "]";
	}

	}
