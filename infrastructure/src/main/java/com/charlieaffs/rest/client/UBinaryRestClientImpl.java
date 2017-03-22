package com.charlieaffs.rest.client;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import com.charlieaffs.data.external.UBinaryLead;
import com.google.gson.Gson;

@Component("uBinaryRestClient")
public class UBinaryRestClientImpl extends BaseBrokerLeadRestClient<UBinaryLead> 
		implements UBinaryRestClient {
	
	public final static int AFFILIATE_ID = 35871;
	public final static String BASE_URL = "http://api.ubinary.com/trading/affiliate/" + AFFILIATE_ID;
	public final static String LEAD_REGISTRATION_URL = "/user/register";
	
	@Override
	public void initHeaders(HttpHeaders headers) {
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));	
	}

	@Override
	public Map<String, Object> registerLead(UBinaryLead lead) {
		String jsonLead = new Gson().toJson(lead.getParams());
		if(jsonLead != null) {
			Map<String, String> queryParams = new HashMap<>();
			queryParams.put("data", jsonLead);
			return getLead(lead, BASE_URL + LEAD_REGISTRATION_URL, queryParams);
		}
		return null;
	}
	
}
