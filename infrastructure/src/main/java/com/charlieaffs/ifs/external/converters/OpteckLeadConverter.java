package com.charlieaffs.ifs.external.converters;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.charlieaffs.data.external.OpteckLead;
import com.charlieaffs.data.tradeit.model.User;
import com.charlieaffs.ifs.logging.TILogger;
import com.charlieaffs.ifs.utils.Formatter;

@Component("opteckLeadConverter")
public class OpteckLeadConverter implements LeadConverter<OpteckLead> {

	public final static String AFFILIATE_ID = "2778";
	public final static String PARTNER_ID = "JGJZoG";
	
	@Override
	public OpteckLead convert(User user, String ip) {
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add(OpteckLead.AFFILIATE_ID, AFFILIATE_ID);
		params.add(OpteckLead.FIRST_NAME, user.getFirstName());
		params.add(OpteckLead.LAST_NAME, user.getLastName());
		params.add(OpteckLead.EMAIL, user.getEmail());
		params.add(OpteckLead.PHONE, user.getTelephone());
		params.add(OpteckLead.IP_ADDRESS, ip);
		params.add(OpteckLead.COUNTRY_CODE, Formatter.getIso2(user));
		// TODO: remove hard coded en....
		params.add(OpteckLead.LANGUAGE, "en");
		
		String checksum = generateChecksum(params.toSingleValueMap());
		if(checksum != null) {
			params.add(OpteckLead.CHECKSUM, checksum);
		}
		return new OpteckLead(params, user.getId());
	}
	
	private String generateChecksum(Map<String, String> params) {
        String encoded = null;
		try {
			String unencoded = PARTNER_ID + Formatter.mapToString(params, true);			
			encoded = Formatter.MD5(unencoded);
	        TILogger.getLog().debug("Converted md5: " + encoded);
		} catch (UnsupportedEncodingException e) {
			TILogger.getLog().error("could not convert opteck params to md5 with utf-8 encoding", e, true);
		} catch (NoSuchAlgorithmException e) {
			TILogger.getLog().error("could not encode opteck params using MD5 Algorithim", e, true);
		}

        if(encoded != null) {
            return encoded.toUpperCase();
        }
        return null;
    }

}
