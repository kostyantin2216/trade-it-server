package com.charlieaffs.data.tradeit.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Transient;

import com.charlieaffs.data.DataModelObject;

public class DataTableUpdateTime implements DataModelObject {
	private static final long serialVersionUID = -2358949205200670841L;

	private Integer id;
	private String tableName;
	private Date updateTime;
	
	public DataTableUpdateTime() { }
	
	public DataTableUpdateTime(Integer id, String tableName, Date updateTime) {
		this.id = id;
		this.tableName = tableName;
		this.updateTime = updateTime;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public void setId(Integer id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "DataTableUpdateTime [tableName=" + tableName + ", updateTime=" + updateTime + "]";
	}

}
