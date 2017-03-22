package com.charlieaffs.ifs.external.registrars;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.charlieaffs.data.Constants;
import com.charlieaffs.data.external.UBinaryLead;
import com.charlieaffs.data.tradeit.model.BrokerRegistration;
import com.charlieaffs.rest.client.BrokerLeadRestClient;
import com.charlieaffs.rest.client.UBinaryRestClient;

@Component("uBinaryRegistrar")
public class UBinaryRegistrarImpl extends BaseBrokerRegistrar<UBinaryLead> 
		implements UBinaryRegistrar {
	
	public final static String USER_ID = "UserId";
	public final static String TRACKING_ID = "TrackingId";
	public final static String ERROR_CODE = "ErrorCode";
	public final static String ERROR_MSG = "ErrorMessage";
	
	public final static String BASE_URL = "";
	
	@Autowired
	private UBinaryRestClient client;

	@Override
	protected void fillBrokerRegistration(BrokerRegistration br, Map<String, Object> params) {
		Object userBrokerId = params.get(USER_ID);
		if(userBrokerId != null) {
			br.setUserBrokerId(userBrokerId.toString());
		}
		
		Object errorCode = params.get(ERROR_CODE);
		if(errorCode != null) {
			br.setIsSuccess(errorCode.toString().equalsIgnoreCase("RC_OK"));
			Object errorMsg = params.get(ERROR_MSG);
			if(errorMsg != null) {
				br.setMessage("code: " + errorCode.toString() + ", msg: " + errorMsg.toString());					
			}
		}
		
		Object trackingId = params.get(TRACKING_ID);
		if(trackingId != null) {				
			br.setTrackingId(trackingId.toString());
		}
	}

	@Override
	protected BrokerLeadRestClient<UBinaryLead> getRestClient() {
		return client;
	}
	
	@Override
	public int getBrokerId() {
		return Constants.UBINARY_CODE;
	}
	
	@Override
	public String getBrokerName() {
		return Constants.OPTECK_NAME;
	}

}
