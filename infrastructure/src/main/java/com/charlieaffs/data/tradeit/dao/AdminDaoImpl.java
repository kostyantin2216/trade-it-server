package com.charlieaffs.data.tradeit.dao;

import org.springframework.stereotype.Repository;

import com.charlieaffs.data.BaseDao;
import com.charlieaffs.data.tradeit.model.Admin;

@Repository("adminDao")
public class AdminDaoImpl extends BaseDao<Admin> implements AdminDao {
	
	public final static String CLASS_NAME = "com.charlieaffs.data.tradeit.model.Admin";
	public final static String TABLE_NAME = "Admin";
	
	public final static String ID = "id";
	public final static String USERNAME = "username";
	public final static String PASSWORD = "password";
	
	@Override
	public String getTableName() {
		return TABLE_NAME;
	}

	@Override
	public String getClassName() {
		return CLASS_NAME;
	}

}
