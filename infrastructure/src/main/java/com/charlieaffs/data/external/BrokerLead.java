package com.charlieaffs.data.external;

import java.util.Map;

public interface BrokerLead extends Lead {
	Integer getId();
	Map<?, ?> getParamsMap();
}
