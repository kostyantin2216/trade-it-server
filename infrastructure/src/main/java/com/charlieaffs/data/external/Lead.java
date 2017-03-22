package com.charlieaffs.data.external;

import java.io.Serializable;

public interface Lead {
	Serializable getId();
	String getFirstName();
	String getLastName();
	String getPhoneNumber();
	String getEmail();
	String getLanguage();
	String getIp();
	String getCountryCode();
	String getComment();
}
