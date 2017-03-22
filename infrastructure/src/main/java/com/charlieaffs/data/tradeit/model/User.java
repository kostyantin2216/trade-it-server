package com.charlieaffs.data.tradeit.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Transient;

import com.charlieaffs.data.DataModelObject;

public class User implements DataModelObject {
	private static final long serialVersionUID = -8099485472631483449L;
	
	private Integer id;
	private String firstName;
	private String lastName;
	private String password;
	private String tempPassword;
	private String email;
	private String telephone;
	private Integer countryId;
	private String country;
	private String channels;
	private Boolean isRegistered;
	private Boolean isAdmin;
	private Boolean isOnTrial;
	private Date tempPasswordRequestTime;
	private Date lastPayment;
	private Date createdAt;
	private Date updatedAt;
	
	public User() { }
	
	public User(Integer id, String firstName, String lastName, String password, String tempPassword, String email,
			String telephone, Integer countryId, String country, String channels, Boolean isRegistered, Boolean isAdmin,
			Boolean isOnTrial, Date tempPasswordRequestTime, Date lastPayment, Date createdAt, Date updatedAt) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.tempPassword = tempPassword;
		this.email = email;
		this.telephone = telephone;
		this.countryId = countryId;
		this.country = country;
		this.channels = channels;
		this.isRegistered = isRegistered;
		this.isAdmin = isAdmin;
		this.isOnTrial = isOnTrial;
		this.tempPasswordRequestTime = tempPasswordRequestTime;
		this.lastPayment = lastPayment;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public User(String firstName, String lastName, String password, String tempPassword, String email, String telephone,
			Integer countryId, String country, String channels, Boolean isRegistered, Boolean isAdmin, Boolean isOnTrial,
			Date tempPasswordRequestTime, Date lastPayment, Date createdAt, Date updatedAt) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.tempPassword = tempPassword;
		this.email = email;
		this.telephone = telephone;
		this.countryId = countryId;
		this.country = country;
		this.channels = channels;
		this.isRegistered = isRegistered;
		this.isAdmin = isAdmin;
		this.isOnTrial = isOnTrial;
		this.tempPasswordRequestTime = tempPasswordRequestTime;
		this.lastPayment = lastPayment;
		this.createdAt = createdAt;
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
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	public Integer getCountryId() {
		return countryId;
	}
	
	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}
	
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getChannels() {
		return channels;
	}
	
	public void setChannels(String channels){
		this.channels = channels;
	}

	public Boolean getIsRegistered() {
		return isRegistered;
	}

	public void setIsRegistered(Boolean isRegistered) {
		this.isRegistered = isRegistered;
	}

	public Boolean getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	
	public Boolean getIsOnTrial() {
		return isOnTrial;
	}

	public void setIsOnTrial(Boolean isOnTrial) {
		this.isOnTrial = isOnTrial;
	}

	public Date getLastPayment() {
		return lastPayment;
	}

	public void setLastPayment(Date lastPayment) {
		this.lastPayment = lastPayment;
	}

	public Date getCreatedAt() {
		return createdAt;
	}
	
	public void setCreatedAt(Date createdAt){
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}
	
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getTempPassword() {
		return tempPassword;
	}

	public void setTempPassword(String tempPassword) {
		this.tempPassword = tempPassword;
	}

	public Date getTempPasswordRequestTime() {
		return tempPasswordRequestTime;
	}

	public void setTempPasswordRequestTime(Date tempPasswordRequestTime) {
		this.tempPasswordRequestTime = tempPasswordRequestTime;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", password=" + password
				+ ", tempPassword=" + tempPassword + ", email=" + email + ", telephone=" + telephone + ", countryId="
				+ countryId + ", channels=" + channels + ", isRegistered=" + isRegistered + ", isAdmin=" + isAdmin
				+ ", isOnTrial=" + isOnTrial + ", tempPasswordRequestTime=" + tempPasswordRequestTime + ", lastPayment="
				+ lastPayment + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}
	
}
