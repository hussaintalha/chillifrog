package com.wealthtax.chillifrog.cashflow;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "occOtherCashFlow")
public class CashFlow {

    @Id
    @Column(name = "othercashflowID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer othercashflowID;
    private Integer profileId;
    private Integer cashFlowType;
    private String description;
    private String baseCurrency;
    private String foreignCurrency;
    private String actualAmountBase;
    private Double fxAmountforeign = 0.0;
    private String actualAmountforeign;
    private Integer transactionDay;
    private Integer transactionMonth;
    private Integer transactionYear;
    private Integer createdBy;
    private Timestamp createdDate;
    private Timestamp updatedDate;

    public Integer getOthercashflowID() {
        return othercashflowID;
    }

    public void setOthercashflowID(Integer othercashflowID) {
        this.othercashflowID = othercashflowID;
    }

    public Integer getProfileId() {
        return profileId;
    }

    public void setProfileId(Integer profileId) {
        this.profileId = profileId;
    }

    public Integer getCashFlowType() {
        return cashFlowType;
    }

    public void setCashFlowType(Integer cashFlowType) {
        this.cashFlowType = cashFlowType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBaseCurrency() {
        return baseCurrency;
    }

    public void setBaseCurrency(String baseCurrency) {
        this.baseCurrency = baseCurrency;
    }

    public String getForeignCurrency() {
        return foreignCurrency;
    }

    public void setForeignCurrency(String foreignCurrency) {
        this.foreignCurrency = foreignCurrency;
    }

    public String getActualAmountBase() {
        return actualAmountBase;
    }

    public void setActualAmountBase(String actualAmountBase) {
        this.actualAmountBase = actualAmountBase;
    }

    public String getActualAmountforeign() {
        return actualAmountforeign;
    }

    public void setActualAmountforeign(String actualAmountforeign) {
        this.actualAmountforeign = actualAmountforeign;
    }

    public Integer getTransactionDay() {
        return transactionDay;
    }

    public void setTransactionDay(Integer transactionDay) {
        this.transactionDay = transactionDay;
    }

    public Integer getTransactionMonth() {
        return transactionMonth;
    }

    public void setTransactionMonth(Integer transactionMonth) {
        this.transactionMonth = transactionMonth;
    }

    public Integer getTransactionYear() {
        return transactionYear;
    }

    public void setTransactionYear(Integer transactionYear) {
        this.transactionYear = transactionYear;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public Timestamp getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Timestamp updatedDate) {
        this.updatedDate = updatedDate;
    }

    public double getFxAmountforeign() {
		return fxAmountforeign;
	}

	public void setFxAmountforeign(double fxAmountforeign) {
		this.fxAmountforeign = fxAmountforeign;
	}

	@Override
    public String toString() {
        return "CashFlow{" + "othercashflowID=" + othercashflowID + ", profileId=" + profileId + ", cashFlowType=" + cashFlowType + ", description=" + description + ", baseCurrency=" + baseCurrency + ", foreignCurrency=" + foreignCurrency + ", actualAmountBase=" + actualAmountBase + ", actualAmountforeign=" + actualAmountforeign + ", transactionDay=" + transactionDay + ", transactionMonth=" + transactionMonth + ", transactionYear=" + transactionYear + ", createdBy=" + createdBy + ", createdDate=" + createdDate + ", updatedDate=" + updatedDate + '}';
    }
}
