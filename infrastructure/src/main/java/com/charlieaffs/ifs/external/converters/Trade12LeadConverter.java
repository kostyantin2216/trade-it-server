package com.charlieaffs.ifs.external.converters;

import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.charlieaffs.data.external.Trade12Lead;
import com.charlieaffs.data.tradeit.model.User;
import com.charlieaffs.ifs.logging.TILogger;
import com.charlieaffs.ifs.utils.Formatter;
import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.Phonenumber.PhoneNumber;

@Component("trade12LeadConverter")
public class Trade12LeadConverter implements LeadConverter<Trade12Lead> {
	
	private final static String REFFERAL_ID = "15253";
	private final static String CAMPAIGN_ID = "212";
	
	@Override
	public Trade12Lead convert(User user, String ip) {
		PhoneNumber phoneNumber = null;
		
		try {
			phoneNumber = Formatter.getPhoneNumber(user);
		} catch (NumberParseException ex) {
			TILogger.getLog().error(
					"Trade12Converter could not format country for user: \n" + user.toString() + "\n",
					ex, true);
		}
		
		if(phoneNumber != null) {
			MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
			params.add(Trade12Lead.EMAIL, user.getEmail());
			params.add(Trade12Lead.FIRST_NAME, user.getFirstName());
			params.add(Trade12Lead.LAST_NAME, user.getLastName());
			params.add(Trade12Lead.PREFIX, "+" + phoneNumber.getCountryCode());
			params.add(Trade12Lead.PHONE, String.valueOf(phoneNumber.getNationalNumber()));
			params.add(Trade12Lead.COUNTRY_CODE, Formatter.getIso2(user));
			params.add(Trade12Lead.REFFERAL, REFFERAL_ID);
			params.add(Trade12Lead.CAMPAIGN_ID, CAMPAIGN_ID);
			
			return new Trade12Lead(params, user.getId(), ip);
		}
		
		return null;
	}

}
