package com.charlieaffs.data.tradeit.model;

import java.io.Serializable;

import javax.persistence.Transient;

import com.charlieaffs.data.DataModelObject;

public class Admin implements DataModelObject {
	private static final long serialVersionUID = 1674819706527287641L;
	
	private Integer id;
	private String username;
	private String password;
	
	public Admin() { }
	
	public Admin(Integer id, String username, String password) {
		this.username = username;
		this.password = password;
	}

	@Override
	@Transient
	public void setSerializedId(Serializable id) throws ClassCastException {
		this.id = (Integer) id;
	}
	
	@Override
	@Transient
	public Serializable getSerializedId() {
		return id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Admin [username=" + username + ", password=" + password + "]";
	}
	
}
