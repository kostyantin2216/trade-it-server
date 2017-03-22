package com.charlieaffs.data.external;

import java.util.Map;

import com.charlieaffs.ifs.utils.Formatter;

/**
 *   string FirstName;           // First name
 *   string LastName;            // Last name
 *   string PhoneNumber;         // Phone number
 *   string Email;               // Email
 *   string Password;            // Password
 *   string LanguageCode;        // optional - user preferred language (see details below)
 *   ulong Tlid;                 // optional - tracking link id (64 bits)
 *   string FromIp;              // optional - explicit client IP, if not specified IP is taken from request
 *   string CountryCode;         // optional - explicit country code, if not specified country is based on IP
 *   string Ctag;                // optional - a free parameter; it comes back in report API
 *   string AdData;              // optional - a free parameter (usually information about a campaign)
 *   string Comment;             // optional - a registration comment
 *   
 *   reference: <a>https://github.com/Ubinary/api.ubinary.com/blob/master/affiliates/lead-register.md</a>
 *   
 *   @author Kostyantin
 */
public class UBinaryLead implements BrokerLead {
	
	public final static String FIRST_NAME = "FirstName";
	public final static String LAST_NAME = "LastName";
	public final static String PHONE_NUMBER = "PhoneNumber";
	public final static String EMAIL = "Email";
	public final static String PASSWORD = "Password";
	public final static String LANGUAGE_CODE = "LanguageCode";
	public final static String TRACKING_LINK_ID = "Tlid";
	public final static String FROM_IP ="FromIp";
	public final static String COUNTRY_CODE = "CountryCode";
	public final static String C_TAG = "Ctag";
	public final static String AD_DATA = "AdData";
	public final static String COMMENT = "Comment";
	
	private Map<String, String> params;
	private Integer userId;
	
	public UBinaryLead(Map<String, String> params, Integer userId) {
		this.params = params;
		this.userId = userId;
	}
	
	public Map<String, String> getParams() {
		return params;
	}

	public void setParams(Map<String, String> params) {
		this.params = params;
	}

	@Override
	public String getFirstName() {
		return params.get(FIRST_NAME);
	}

	@Override
	public String getLastName() {
		return params.get(LAST_NAME);
	}

	@Override
	public String getPhoneNumber() {
		return params.get(PHONE_NUMBER);
	}

	@Override
	public String getEmail() {
		return params.get(EMAIL);
	}

	@Override
	public String getLanguage() {
		return params.get(LANGUAGE_CODE);
	}

	@Override
	public String getIp() {
		return params.get(FROM_IP);
	}

	@Override
	public String getCountryCode() {
		return params.get(COUNTRY_CODE);
	}

	@Override
	public String getComment() {
		return params.get(COMMENT);
	}
	
	@Override
	public String toString() {
		return Formatter.mapToString(params);
	}

	@Override
	public Integer getId() {
		return userId;
	}

	@Override
	public Map<String, String> getParamsMap() {
		return params;
	}
	
}
