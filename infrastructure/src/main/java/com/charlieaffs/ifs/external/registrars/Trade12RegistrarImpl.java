package com.charlieaffs.ifs.external.registrars;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.charlieaffs.data.Constants;
import com.charlieaffs.data.external.Trade12Lead;
import com.charlieaffs.data.tradeit.model.BrokerRegistration;
import com.charlieaffs.ifs.utils.Formatter;
import com.charlieaffs.rest.client.BrokerLeadRestClient;
import com.charlieaffs.rest.client.Trade12RestClient;

@Component("trade12Registrar")
public class Trade12RegistrarImpl extends BaseBrokerRegistrar<Trade12Lead> implements Trade12Registrar {

	public final static String SUCCESS = "Success";
	public final static String MSG = "Message";
	public final static String LEAD_ID = "LeadID";
	
	@Autowired
	@Qualifier("trade12RestClient")
	private Trade12RestClient client;	
	
	@Override
	protected void fillBrokerRegistration(BrokerRegistration br, Map<String, Object> params) {
		Object userBrokerId = params.get(LEAD_ID);
		if(userBrokerId != null) {
			br.setUserBrokerId(userBrokerId.toString());
		}
		
		Object success = params.get(SUCCESS);
		if(success != null && Formatter.isBoolean(success)) {
			String isSuccess = success.toString().trim();
			br.setIsSuccess(isSuccess.equalsIgnoreCase("true") || isSuccess.equals("1"));
		}
		
		Object message = params.get(MSG);
		if(message != null) {
			br.setMessage(message.toString());
		}
	}

	@Override
	protected BrokerLeadRestClient<Trade12Lead> getRestClient() {
		return client;
	}
	
	@Override
	public String getBrokerName() {
		return Constants.TRADE_12_NAME;
	}
	
	@Override
	public int getBrokerId() {
		return Constants.TRADE_12_CODE;
	}

}
