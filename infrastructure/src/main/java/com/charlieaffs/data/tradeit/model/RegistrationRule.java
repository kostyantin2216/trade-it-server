package com.charlieaffs.data.tradeit.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Transient;

import com.charlieaffs.data.DataModelObject;

public class RegistrationRule implements DataModelObject {
	private static final long serialVersionUID = 218203602061218124L;
	
	private Integer id;
	private Integer brokerId;
	private Integer countryId;
	private Boolean isActive;
	private Date updatedAt;
	
	public RegistrationRule() { }

	public RegistrationRule(Integer id, Integer brokerId, Integer countryId, Boolean isActive, Date updatedAt) {
		this.id = id;
		this.brokerId = brokerId;
		this.countryId = countryId;
		this.isActive = isActive;
		this.updatedAt = updatedAt;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getBrokerId() {
		return brokerId;
	}

	public void setBrokerId(Integer brokerId) {
		this.brokerId = brokerId;
	}

	public Integer getCountryId() {
		return countryId;
	}

	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "RegistrationRule [id=" + id + ", brokerId=" + brokerId + ", countryId=" + countryId + ", isActive="
				+ isActive + ", updatedAt=" + updatedAt + "]";
	}

	@Override
	@Transient
	public Integer getSerializedId() {
		return id;
	}

	@Override
	@Transient
	public void setSerializedId(Serializable id) throws ClassCastException {
		this.id = (Integer) id;
	}	

}
