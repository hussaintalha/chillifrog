package com.wealthtax.chillifrog.util;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="fx_rates_usd")
public class Currency {
	
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
	public String iso_currency;  
    public Date date;
	public Double exch_rate_usd;
	public Double exch_rate_per_usd;
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	public String getIso_currency() {
		return iso_currency;
	}
	public void setIso_currency(String iso_currency) {
		this.iso_currency = iso_currency;
	}

	public Double getExch_rate_usd() {
		return exch_rate_usd;
	}

	public void setExch_rate_usd(Double exch_rate_usd) {
		this.exch_rate_usd = exch_rate_usd;
	}

	public Double getExch_rate_per_usd() {
		return exch_rate_per_usd;
	}

	public void setExch_rate_per_usd(Double exch_rate_per_usd) {
		this.exch_rate_per_usd = exch_rate_per_usd;
	}

	
}
