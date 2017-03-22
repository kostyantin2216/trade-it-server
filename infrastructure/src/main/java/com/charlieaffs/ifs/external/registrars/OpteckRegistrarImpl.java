package com.charlieaffs.ifs.external.registrars;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.charlieaffs.data.Constants;
import com.charlieaffs.data.external.OpteckLead;
import com.charlieaffs.data.tradeit.model.BrokerRegistration;
import com.charlieaffs.rest.client.BrokerLeadRestClient;
import com.charlieaffs.rest.client.OpteckRestClient;


/**
 * Registration response example: 
 * 
 * 	{
 *		"returnCode": 1,
 *		"description": "Successful call",
 *		"timestampGenerated": "2016-05-06T17:07:26+03:00",
 *		"data": {
 *			"leadID": "160506683950",
 *			"dateRegistered": "2016-05-06T17:07:25+03:00",
 *			"campaign": null,
 *			"subcampaign": null,
 *			"status": "Cancelled",
 *			"languageCode": "EN",
 *			"countryCode": "AU",
 *			"currencyCode": "USD"
 *		}
 *	}
 *
 */
@Component("opteckRegistrar")
public class OpteckRegistrarImpl extends BaseBrokerRegistrar<OpteckLead> 
		implements OpteckRegistrar {

	public final static String RETURN_CODE = "returnCode";
	public final static String DESC = "description";
	public final static String DATA = "data";
	public final static String LEAD_ID = "leadID";
	
	public final static int SUCCESS_CODE = 1;

	@Autowired
	@Qualifier("opteckRestClient")
	private OpteckRestClient client;

	@Override
	@SuppressWarnings("unchecked")
	protected void fillBrokerRegistration(BrokerRegistration br, Map<String, Object> params) {
		Object returnCodeObj = params.get(RETURN_CODE);
		if(returnCodeObj != null) {
			br.setIsSuccess(((Double) returnCodeObj) == SUCCESS_CODE);
			if(br.getIsSuccess()) {
				Object dataObj = params.get(DATA);
				if(dataObj != null) {
					Map<String, Object> data = (Map<String, Object>) dataObj;
					br.setUserBrokerId((String) data.get(LEAD_ID));
				}
			}
		}
		
		Object descObj = params.get(DESC);
		if(descObj != null) {
			br.setMessage((String) descObj);
		}
	}

	@Override
	protected BrokerLeadRestClient<OpteckLead> getRestClient() {
		return client;
	}

	@Override
	public int getBrokerId() {
		return Constants.OPTECK_CODE;
	}

	@Override
	public String getBrokerName() {
		return Constants.OPTECK_NAME;
	}

}
