package com.charlieaffs.data.external;

import java.util.Map;

import org.springframework.util.MultiValueMap;

/**
 * 	String email - Valid Email Address (Required)
 * 	String Fname - Lead First-name (Required)
 * 	String Lname - Lead Last-name (Required)
 * 	String prefix - Phone Prefix (Required)
 * 	String phone - Phone Without Prefix (Required)
 * 	String countryCode - Example US IL PH (Required)
 * 	String Refferal - ASK US (Required)
 * 	Integer CampaignID - ASK US (Required)
 * 
 * 	reference: located in google drive
 */
public class Trade12Lead implements BrokerLead {
	
	public final static String EMAIL = "email";
	public final static String FIRST_NAME = "Fname";
	public final static String LAST_NAME = "Lname";
	public final static String PREFIX = "prefix";
	public final static String PHONE = "phone";
	public final static String COUNTRY_CODE = "countryCode";
	public final static String REFFERAL = "Refferal";
	public final static String CAMPAIGN_ID = "CampaignID";

	private Integer userId;
	private String ip;
	private MultiValueMap<String, String> params;
	private Map<String, String> paramsCopy;
	
	public Trade12Lead(MultiValueMap<String, String> params, Integer userId, String ip) {
		this.params = params;
		this.paramsCopy = params.toSingleValueMap();
		this.userId = userId;
		this.ip = ip;
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
		// TODO: fix.
		return "en";
	}

	@Override
	public String getIp() {
		return ip;
	}

	@Override
	public String getCountryCode() {
		return paramsCopy.get(COUNTRY_CODE);
	}

	@Override
	public String getComment() {
		return "NA";
	}

	@Override
	public MultiValueMap<String, String> getParamsMap() {
		return params;
	}

}
