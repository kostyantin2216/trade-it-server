package com.charlieaffs.data.external;

import java.util.Map;

import org.springframework.util.MultiValueMap;

/**
 * 	affiliateID		Affiliate ID from “Promotion > API” page		Integer					Mandatory
 *	email			Email address. It should be valid.				String. Length: ≤60		Mandatory
 * 	firstName		First name										String. Length: ≤100	Mandatory
 * 	lastName		Last name										String. Length: ≤100	Mandatory
 * 	phone			Phone number									String. Length: ≤255	Mandatory
 *	language		Language code in ISO 639-1. Example: EN, FR		String. Length: 2		Mandatory
 *	country			Country code in ISO 3166-1. Example: US, GB		String. Length: 2		Mandatory
 * 	town			Town											String. Length: ≤255	Optional
 * 	postalCode		Postal code										String. Length: ≤20		Optional
 * 	address			Address											String. Length: ≤255	Optional
 * 	cellphone		Cellphone number								String. Length: ≤255	Optional
 * 	birthday		Date of birth, format: YYYY-MM-DD. 				String. Length: ≤10		Optional
 *	ip				Lead IP address, e.g. 127.0.0.1					String. Length: ≤32		Optional
 * 	campaign		Campaign tracking								String. Length: ≤255	Optional
 * 	subcampaign		Subcampaign tracking							String. Length: ≤255	Optional
 *  password		Lead password									String. Length: ≤255	Optional
 *  comment			Comment about lead								String. Length: ≤255	Optional
 * 	marker			Short info about lead that might be crucial 
 * 					for lead conversion. Always visible to agents.	String. Length: ≤140	Optional
 * 	checksum		See “Checksum mechanism”						String. Length: 32		Mandatory
 *
 * 	reference: <a>http://developers.optaffiliates.com/1.0/api/affiliates/createAccount</a>
 *
 */
public class OpteckLead implements BrokerLead {
	
    public final static String AFFILIATE_ID = "affiliateID";
    public final static String PARTNER_ID = "partnerID";
    public final static String EMAIL = "email";
    public final static String FIRST_NAME = "firstName";
    public final static String LAST_NAME = "lastName";
    public final static String PHONE = "phone";
    public final static String LANGUAGE = "language";
    public final static String IP_ADDRESS = "ip";
    public final static String COUNTRY_CODE = "country";
    public final static String COMMENT = "comment";
    public final static String CHECKSUM = "checksum";

    private Integer userId;
    private MultiValueMap<String, String> params;
    private Map<String, String> paramsCopy;
    
    public OpteckLead(MultiValueMap<String, String> params, Integer userId) {
    	this.userId = userId;
    	this.params = params;
    	this.paramsCopy = params.toSingleValueMap();
	}
    
	@Override
	public Integer getId() {
		return userId;
	}

	@Override
	public String getFirstName() {
		return paramsCopy.get(FIRST_NAME);
	}

	@Override
	public String getLastName() {
		return paramsCopy.get(LAST_NAME);
	}

	@Override
	public String getPhoneNumber() {
		return paramsCopy.get(PHONE);
	}

	@Override
	public String getEmail() {
		return paramsCopy.get(EMAIL);
	}

	@Override
	public String getLanguage() {
		return paramsCopy.get(LANGUAGE);
	}

	@Override
	public String getIp() {
		return paramsCopy.get(IP_ADDRESS);
	}

	@Override
	public String getCountryCode() {
		return paramsCopy.get(COUNTRY_CODE);
	}

	@Override
	public String getComment() {
		return paramsCopy.get(COMMENT);
	}

	@Override
	public Map<?, ?> getParamsMap() {
		return params;
	}

}
