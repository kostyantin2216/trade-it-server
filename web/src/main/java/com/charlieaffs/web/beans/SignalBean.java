package com.charlieaffs.web.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.charlieaffs.data.tradeit.dao.SignalDao;
import com.charlieaffs.data.tradeit.model.Signal;

@Component
@ManagedBean
@SessionScoped
public class SignalBean {
	
	@Autowired
	private SignalDao signalDao;
	
	private static List<Signal> signalsCache;
	
	@Autowired
	public List<Signal> getSignals() {
		if(signalsCache == null) {
			signalsCache = signalDao.findAll();
		}
		return signalsCache;
	}
	
}
