package com.charlieaffs.rest.client;

import java.util.Map;

import com.charlieaffs.data.external.BrokerLead;

public interface BrokerLeadRestClient<E extends BrokerLead> extends RestClient {
	Map<String, Object> registerLead(E lead);
}
