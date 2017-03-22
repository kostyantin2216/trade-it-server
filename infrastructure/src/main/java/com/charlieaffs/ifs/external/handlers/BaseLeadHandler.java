package com.charlieaffs.ifs.external.handlers;

import com.charlieaffs.data.external.Lead;
import com.charlieaffs.data.external.LeadRegistrationDetails;
import com.charlieaffs.data.tradeit.model.User;
import com.charlieaffs.ifs.external.converters.LeadConverter;
import com.charlieaffs.ifs.external.registrars.Registrar;

public abstract class BaseLeadHandler<E extends Lead> implements LeadHandler {
	
	private LeadConverter<E> converter;
	private Registrar<E> registrar;
	
	public BaseLeadHandler(LeadConverter<E> converter, Registrar<E> registrar) {
		this.converter = converter;
		this.registrar = registrar;
	}
	
	@Override
	public LeadRegistrationDetails registerLead(User user, String ip) {
		E lead = converter.convert(user, ip);
		
		if(lead != null) {
			return registrar.registerLead(lead);			
		}
		return null;
	}
	
}
