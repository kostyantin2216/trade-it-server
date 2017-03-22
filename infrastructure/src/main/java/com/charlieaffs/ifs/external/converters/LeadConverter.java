package com.charlieaffs.ifs.external.converters;

import com.charlieaffs.data.external.Lead;
import com.charlieaffs.data.tradeit.model.User;

public interface LeadConverter<E extends Lead> {
	E convert(User user, String ip);
}
