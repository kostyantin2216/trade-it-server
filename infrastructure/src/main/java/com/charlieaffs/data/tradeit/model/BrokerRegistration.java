package com.charlieaffs.data.tradeit.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Transient;

import com.charlieaffs.data.DataModelObject;
import com.charlieaffs.data.external.LeadRegistrationDetails;

public class BrokerRegistration implements DataModelObject, LeadRegistrationDetails {
	private static final long serialVersionUID = 2970274413828043887L;
	
	private Integer id;
	private Integer brokerId;
	private Integer userId;
	private String userBrokerId;
	private String message;
	private Boolean isSuccess;
	private String trackingId;
	private String ipAddress;
	private Date createdAt;

	public BrokerRegistration() { }
	
	public BrokerRegistration(String message) {
		this.message = message;
	}
	
	public BrokerRegistration(Integer id, Integer brokerId, Integer userId, String userBrokerId, String message,
			Boolean isSuccess, String trackingId, String ipAddress, Date createdAt) {
		this.id = id;
		this.brokerId = brokerId;
		this.userId = userId;
		this.userBrokerId = userBrokerId;
		this.message = message;
		this.isSuccess = isSuccess;
		this.trackingId = trackingId;
		this.ipAddress = ipAddress;
		this.createdAt = createdAt;
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

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserBrokerId() {
		return userBrokerId;
	}

	public void setUserBrokerId(String userBrokerId) {
		this.userBrokerId = userBrokerId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Boolean getIsSuccess() {
		return isSuccess;
	}

	public void setIsSuccess(Boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public String getTrackingId() {
		return trackingId;
	}

	public void setTrackingId(String trackingId) {
		this.trackingId = trackingId;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "BrokerRegistration [id=" + id + ", brokerId=" + brokerId + ", userId=" + userId + ", userBrokerId="
				+ userBrokerId + ", message=" + message + ", isSuccess=" + isSuccess + ", trackingId=" + trackingId
				+ ", ipAddress=" + ipAddress + ", createdAt=" + createdAt + "]";
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
