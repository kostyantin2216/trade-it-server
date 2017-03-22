package com.charlieaffs.data.tradeit.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.charlieaffs.data.BaseDao;
import com.charlieaffs.data.tradeit.model.User;

@Repository("userDao")
public class UserDaoImpl extends BaseDao<User> implements UserDao {
	
	public final static String CLASS_NAME = "com.charlieaffs.data.tradeit.model.User";
	public final static String TABLE_NAME = "User";
	
	public final static String ID = "id";
	public final static String FIRST_NAME = "firstName";
	public final static String LAST_NAME = "lastName";
	public final static String PASSWORD = "password";
	public final static String TEMP_PASSWORD = "tempPassword";
	public final static String EMAIL = "email";
	public final static String TELEPHONE = "telephone";
	public final static String COUNTRY_ID = "countryId";
	public final static String COUNTRY = "country";
	public final static String CHANNELS = "channels";
	public final static String IS_REGISTERED = "isRegistered";
	public final static String IS_ADMIN = "isAdmin";
	public final static String IS_ON_TRIAL = "isOnTrial";
	public final static String LAST_PAYMENT = "lastPayment";
	public final static String CREATED_AT = "createdAt";
	public final static String UPDATED_AT = "updatedAt";
	public final static String TEMP_PASSWORD_REQUEST_TIME = "tempPasswordRequestTime";

	@Override
	public List<User> findUsers(Integer... userIds) {
		List<User> users = new ArrayList<>();
		for(int i = 0; i < userIds.length; i++) {
			users.add(findById(userIds[i]));
		}
		return users;
	}
	
	@Override
	public String getTableName() {
		return TABLE_NAME;
	}

	@Override
	public String getClassName() {
		return CLASS_NAME;
	}

	@Override
	public List<User> findSimilar(User user) {
		Map<String, Object> properties = new HashMap<>();
		properties.put(FIRST_NAME, user.getFirstName());
		properties.put(LAST_NAME, user.getLastName());
		properties.put(EMAIL, user.getEmail());
		properties.put(COUNTRY, user.getCountry());
		properties.put(TELEPHONE, user.getTelephone());
		
		return findByMap(properties);
	}

}