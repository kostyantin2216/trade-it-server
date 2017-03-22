package com.charlieaffs.ifs.external.converters;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.charlieaffs.data.external.UBinaryLead;
import com.charlieaffs.data.tradeit.model.User;
import com.charlieaffs.ifs.utils.Formatter;

@Component("uBinaryLeadConverter")
public class UBinaryLeadConverter implements LeadConverter<UBinaryLead> {

	@Override
	public UBinaryLead convert(User user, String ip) {
		Map<String, String> params = new HashMap<>();
		params.put(UBinaryLead.FIRST_NAME, user.getFirstName());
		params.put(UBinaryLead.LAST_NAME, user.getLastName());
		params.put(UBinaryLead.PHONE_NUMBER, user.getTelephone());
		params.put(UBinaryLead.EMAIL, user.getEmail());
		params.put(UBinaryLead.PASSWORD, user.getPassword());
		params.put(UBinaryLead.FROM_IP, ip);
		// TODO: get comment from db and locale from somewhere.
		params.put(UBinaryLead.COMMENT, "Trade It Signals Android Application: this trader is looking for the right place to trade on signals.");
		params.put(UBinaryLead.LANGUAGE_CODE, "en");
		
		
		String countryCode = Formatter.getIso2(user);
		if(countryCode != null) {
			params.put(UBinaryLead.COUNTRY_CODE, countryCode);
		}
		return new UBinaryLead(params, user.getId());
	}
	
}
