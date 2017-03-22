package com.charlieaffs.ifs.external.registrars;

import com.charlieaffs.data.external.Lead;
import com.charlieaffs.data.external.LeadRegistrationDetails;

public interface Registrar<T extends Lead> {
	LeadRegistrationDetails registerLead(T lead);
}
