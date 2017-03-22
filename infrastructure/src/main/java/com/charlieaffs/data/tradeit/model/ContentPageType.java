package com.charlieaffs.data.tradeit.model;

import java.io.Serializable;

import javax.persistence.Transient;

import com.charlieaffs.data.DataModelObject;

public class ContentPageType implements DataModelObject {
	private static final long serialVersionUID = -2792042545259736112L;
	
	private Integer id;
	private String name;
	
	public ContentPageType() { }
	
	public ContentPageType(Integer id, String name) {
		this.id = id;
		this.name = name;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "ContentPageType [id=" + id + ", name=" + name + "]";
	}

}
