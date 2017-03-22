package com.charlieaffs.ifs.external.registrars;

import com.charlieaffs.data.external.BrokerLead;
import com.charlieaffs.data.tradeit.model.BrokerRegistration;

public interface BrokerRegistrar<E extends BrokerLead> extends Registrar<E> {
	
	int getBrokerId();
	String getBrokerName();
	
	boolean acceptsLead(E lead);
	BrokerRegistration registerLead(E lead);

}
