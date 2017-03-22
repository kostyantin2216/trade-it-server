package com.charlieaffs.rest.resources;

import javax.ws.rs.core.Response;

import com.charlieaffs.rest.requests.LeadBrokerRegistrationRequest;
import com.charlieaffs.rest.requests.LeadRegistrationRequest;
import com.charlieaffs.rest.requests.RecycleLeadsRequest;

public interface LeadResource extends RestResource {
	String END_POINT = "Leads";
	
	Response registerUser(LeadRegistrationRequest req);
	Response registerNewUserWithBrokers(LeadBrokerRegistrationRequest req);
	Response registerOldUsersWithBroker(RecycleLeadsRequest req);
	
}
