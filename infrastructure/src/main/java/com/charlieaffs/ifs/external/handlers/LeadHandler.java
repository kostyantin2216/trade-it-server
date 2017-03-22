package com.charlieaffs.ifs.external.handlers;

import com.charlieaffs.data.external.LeadRegistrationDetails;
import com.charlieaffs.data.tradeit.model.User;

public interface LeadHandler {
	LeadRegistrationDetails registerLead(User user, String ip);
}
