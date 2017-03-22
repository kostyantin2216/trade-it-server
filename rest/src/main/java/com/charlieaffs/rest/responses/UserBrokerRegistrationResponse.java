package com.charlieaffs.rest.responses;

import java.util.Arrays;

import com.charlieaffs.data.tradeit.model.BrokerRegistration;
import com.charlieaffs.data.tradeit.model.User;

public class UserBrokerRegistrationResponse implements RestResponse {

	private User user;
	private String ip;
	private BrokerRegistration[] brokerRegistrationDetails;
	
	public UserBrokerRegistrationResponse() { }
	
	public UserBrokerRegistrationResponse(User user, String ip, BrokerRegistration[] brokerRegistrationDetails) {
		this.user = user;
		this.ip = ip;
		this.brokerRegistrationDetails = brokerRegistrationDetails;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
	
	public BrokerRegistration[] getBrokerRegistrationDetails() {
		return brokerRegistrationDetails;
	}

	public void setBrokerRegistrationDetails(BrokerRegistration[] brokerRegistrationDetails) {
		this.brokerRegistrationDetails = brokerRegistrationDetails;
	}

	@Override
	public String toString() {
		return "UserRegistrationResponse [user=" + user + ", ip=" + ip + ", brokerRegistrationDetails="
				+ Arrays.toString(brokerRegistrationDetails) + "]";
	}
	
}
