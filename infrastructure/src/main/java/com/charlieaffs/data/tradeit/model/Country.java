package com.charlieaffs.data.tradeit.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Transient;

import com.charlieaffs.data.DataModelObject;

public class Country implements DataModelObject {
	private static final long serialVersionUID = -3344996278597783864L;
	
	private Integer id;
	private String name;
	private String iso2;
	private String iso3;
	private String dialCode;
	private Date updatedAt;
	
	public Country() { }
	
	public Country(String name, String iso2, String iso3, String dialCode, Date updatedAt) {
		this.name = name;
		this.iso2 = iso2;
		this.iso3 = iso3;
		this.dialCode = dialCode;
		this.updatedAt = updatedAt;
	}

	public Country(Integer id, String name, String iso2, String iso3, String dialCode, Date updatedAt) {
		this.id = id;
		this.name = name;
		this.iso2 = iso2;
		this.iso3 = iso3;
		this.dialCode = dialCode;
		this.updatedAt = updatedAt;
	}

	@Override
	@Transient
	public void setSerializedId(Serializable id) throws ClassCastException {
		this.id = (Integer) id;
	}
	
	@Override
	@Transient
	public Serializable getSerializedId() {
		return id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIso2() {
		return iso2;
	}

	public void setIso2(String iso2) {
		this.iso2 = iso2;
	}

	public String getIso3() {
		return iso3;
	}

	public void setIso3(String iso3) {
		this.iso3 = iso3;
	}

	public String getDialCode() {
		return dialCode;
	}

	public void setDialCode(String dialCode) {
		this.dialCode = dialCode;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "Country [id=" + id + ", name=" + name + ", iso2=" + iso2 + ", iso3=" + iso3 + ", dialCode=" + dialCode
				+ ", updatedAt=" + updatedAt + "]";
	}
	
}
