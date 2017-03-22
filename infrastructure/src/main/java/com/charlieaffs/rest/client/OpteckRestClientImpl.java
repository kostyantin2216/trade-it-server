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

import com.charlieaffs.data.external.OpteckLead;


@Component("opteckRestClient")
public class OpteckRestClientImpl extends BaseBrokerLeadRestClient<OpteckLead> 
		implements OpteckRestClient {
	
	public final static String BASE_URL = "https://api.optaffiliates.com/v1";
	public final static String LEAD_REGISTRATION_URL = "/lead/create";
	
	@Override
	public void initRestTemplate(RestTemplate rest) {
		rest.setMessageConverters(Arrays.asList(new HttpMessageConverter[]{
				new FormHttpMessageConverter(), 
				new GsonHttpMessageConverter()
		}));
	}
	
	@Override
	public void initHeaders(HttpHeaders headers) {
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));	
	}

	@Override
	public Map<String, Object> registerLead(OpteckLead lead) {
		return postLead(lead, BASE_URL + LEAD_REGISTRATION_URL);
	}

}
