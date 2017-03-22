package com.charlieaffs.rest.client;

import java.util.HashMap;
import java.util.Map;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.charlieaffs.data.external.BrokerLead;
import com.charlieaffs.ifs.logging.TILogger;

public abstract class BaseBrokerLeadRestClient<E extends BrokerLead> 
		implements BrokerLeadRestClient<E> {

	private RestTemplate rest;
	private HttpHeaders headers;
	
	public BaseBrokerLeadRestClient() {
		rest = new RestTemplate();
		initRestTemplate(rest);
		headers = new HttpHeaders();
		initHeaders(headers);
	}
	
	public void initRestTemplate(RestTemplate rest) {
	}
	
	public void initHeaders(HttpHeaders headers) {
	}
	
	public Map<String, Object> postLead(E lead, String url) {
		HttpEntity<Map<?, ?>> req = new HttpEntity<>(lead.getParamsMap(), headers);
		
		try {
			ResponseEntity<Map<String, Object>> resp = rest.exchange(url, HttpMethod.POST, req, new ParameterizedTypeReference<Map<String, Object>>() { });
			return resp.getBody();
		} catch(RestClientException e) {
			TILogger.getLog().error("Error while trying to register lead: " + lead.toString() + "\nwith url " + url, e, true);
			return null;
		}
	}
	
	public Map<String, Object> getLead(E lead, String url, Map<String, String> queryParams) {
		UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(url);
		
		for(Map.Entry<String, String> entry : queryParams.entrySet()) {
			uriBuilder.queryParam(entry.getKey(), entry.getValue());
		}

		HttpEntity<String> req = new HttpEntity<String>(this.headers);
		ResponseEntity<Map<String, Object>> resp = rest.exchange(uriBuilder.build().toUri(), 
				HttpMethod.GET, req, new ParameterizedTypeReference<Map<String, Object>>() {});
		return resp.getBody();
	}
	
	
	
}
