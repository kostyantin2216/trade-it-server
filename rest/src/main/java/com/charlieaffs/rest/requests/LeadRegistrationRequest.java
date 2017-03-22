package com.charlieaffs.rest.requests;

import com.charlieaffs.data.tradeit.model.User;

public class LeadRegistrationRequest implements RestRequest {

	private User user;
	private String comment;
	private String campaign;
	private Boolean registerWithBrokers;
	
	public LeadRegistrationRequest() { }

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getCampaign() {
		return campaign;
	}

	public void setCampaign(String campaign) {
		this.campaign = campaign;
	}

	public Boolean getRegisterWithBrokers() {
		return registerWithBrokers;
	}

	public void setRegisterWithBrokers(Boolean registerWithBrokers) {
		this.registerWithBrokers = registerWithBrokers;
	}

	@Override
	public String toString() {
		return "LeadRegistrationRequest [user=" + user + ", comment=" + comment + ", campaign=" + campaign
				+ ", registerWithBrokers=" + registerWithBrokers + "]";
	}
	
}
