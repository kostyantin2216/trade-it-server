package com.charlieaffs.data.tradeit.model;

import java.io.Serializable;

import javax.persistence.Transient;

import com.charlieaffs.data.DataModelObject;

public class ApiKey implements DataModelObject {
	private static final long serialVersionUID = -5422576626990519100L;
	
	private String apiKey;
	private String description;
	private Boolean isActive;

	public ApiKey() { }

	public ApiKey(String apiKey, String description, Boolean isActive) {
		this.apiKey = apiKey;
		this.description = description;
		this.isActive = isActive;
	}

	@Override
	@Transient
	public void setSerializedId(Serializable id) throws ClassCastException {
		this.apiKey = (String) id;
	}
	
	@Override
	@Transient
	public Serializable getSerializedId() {
		return apiKey;
	}

	public String getId() {
		return apiKey;
	}

	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "ApiKey [apiKey=" + apiKey + ", description=" 
				+ description + ", isActive=" + isActive + "]";
	}
	
}
