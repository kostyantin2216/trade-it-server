package com.charlieaffs.data.tradeit.dao;

import java.util.List;

import com.charlieaffs.data.CommonDao;
import com.charlieaffs.data.tradeit.model.User;

public interface UserDao extends CommonDao<User> {
	
	List<User> findUsers(Integer... userIds);
	List<User> findSimilar(User user);
	
}
