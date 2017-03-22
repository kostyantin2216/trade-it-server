package com.charlieaffs.ifs.external.handlers;

import com.charlieaffs.data.tradeit.model.BrokerRegistration;
import com.charlieaffs.data.tradeit.model.User;

public interface BrokerLeadHandler extends LeadHandler {
	BrokerRegistration registerLead(User user, String ip);
}
