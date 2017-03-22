package com.charlieaffs.data.tradeit.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Transient;

import com.charlieaffs.data.DataModelObject;

public class Signal implements DataModelObject {
	private static final long serialVersionUID = -772843684954747035L;
	
	private Integer id;
	private Date createdAt;
	private Date expiryTime;
	private String asset;
	private Double entryRate;
	private Double expiryRate;
	private Boolean isCall;
	private Integer status;

	public Signal() { }

	public Signal(Integer id, Date createdAt, Date expiryTime, String asset, Double entryRate, Double expiryRate,
			Boolean isCall, Integer status) {
		super();
		this.id = id;
		this.createdAt = createdAt;
		this.expiryTime = expiryTime;
		this.asset = asset;
		this.entryRate = entryRate;
		this.expiryRate = expiryRate;
		this.isCall = isCall;
		this.status = status;
	}

	public Signal(Date createdAt, Date expiryTime, String asset, Double entryRate, Double expiryRate, Boolean isCall,
			Integer status) {
		super();
		this.createdAt = createdAt;
		this.expiryTime = expiryTime;
		this.asset = asset;
		this.entryRate = entryRate;
		this.expiryRate = expiryRate;
		this.isCall = isCall;
		this.status = status;
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

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getExpiryTime() {
		return expiryTime;
	}

	public void setExpiryTime(Date expiryTime) {
		this.expiryTime = expiryTime;
	}

	public String getAsset() {
		return asset;
	}

	public void setAsset(String asset) {
		this.asset = asset;
	}

	public Double getEntryRate() {
		return entryRate;
	}

	public void setEntryRate(Double entryRate) {
		this.entryRate = entryRate;
	}

	public Double getExpiryRate() {
		return expiryRate;
	}

	public void setExpiryRate(Double expiryRate) {
		this.expiryRate = expiryRate;
	}

	public Boolean getIsCall() {
		return isCall;
	}

	public void setIsCall(Boolean isCall) {
		this.isCall = isCall;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Signal [id=" + id + ", createdAt=" + createdAt + ", expiryTime=" + expiryTime + ", asset=" + asset
				+ ", entryRate=" + entryRate + ", expiryRate=" + expiryRate + ", isCall=" + isCall + ", status="
				+ status + "]";
	}
	
}
