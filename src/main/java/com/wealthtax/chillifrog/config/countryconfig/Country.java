package com.wealthtax.chillifrog.config.countryconfig;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "country")
public class Country {
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String countryName;
	private String version;
	private String includeInEthnicityAnnotation;
	private String capital;
	private String currency;
	private String iso;
	private String primaryLanguage;
	private Double latitude;
	private Double longitude;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getIncludeInEthnicityAnnotation() {
		return includeInEthnicityAnnotation;
	}

	public void setIncludeInEthnicityAnnotation(
			String includeInEthnicityAnnotation) {
		this.includeInEthnicityAnnotation = includeInEthnicityAnnotation;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getIso() {
		return iso;
	}

	public void setIso(String iso) {
		this.iso = iso;
	}

	public String getPrimaryLanguage() {
		return primaryLanguage;
	}

	public void setPrimaryLanguage(String primaryLanguage) {
		this.primaryLanguage = primaryLanguage;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	@Override
	public String toString() {
		return "id=" + id + ", countryName=" + countryName + ",version="
				+ version + ",includeInEthnicityAnnotation="
				+ includeInEthnicityAnnotation + "+capital" + capital
				+ "currency" + currency + "Iso=" + iso + "primaryLanguage="
				+ primaryLanguage + "latitude=" + latitude + "longitude="
				+ latitude;
	}

}
