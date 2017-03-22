package com.charlieaffs.rest.requests;

import com.charlieaffs.data.tradeit.model.User;

public class LeadBrokerRegistrationRequest implements RestRequest {
	
	private User user;
	private Integer[] companyIds;
	
	public LeadBrokerRegistrationRequest() { }
	
	public LeadBrokerRegistrationRequest(Integer[] companyIds, User user) {
		this.companyIds = companyIds;
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer[] getCompanyIds() {
		return companyIds;
	}

	public void setCompanyIds(Integer[] companyIds) {
		this.companyIds = companyIds;
	}

}
