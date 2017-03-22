package com.charlieaffs.rest.client;

import java.util.Arrays;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.charlieaffs.data.external.Trade12Lead;

@Component("trade12RestClient")
public class Trade12RestClientImpl extends BaseBrokerLeadRestClient<Trade12Lead> 
		implements Trade12RestClient {
	
	public final static String BASE_URL = "https://gwu-crm.com";
	public final static String LEAD_REGISTRATION_URL = "/SendLeadAPI.aspx";
	
	@Override
	public void initHeaders(HttpHeaders headers) {
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));	
	}
	
	@Override
	public void initRestTemplate(RestTemplate rest) {
		rest.setMessageConverters(Arrays.asList(new HttpMessageConverter[]{
				new FormHttpMessageConverter(), 
				new GsonHttpMessageConverter()
		}));
	}

	@Override
	public Map<String, Object> registerLead(Trade12Lead lead) {
		return postLead(lead, BASE_URL + LEAD_REGISTRATION_URL);
	}

}
