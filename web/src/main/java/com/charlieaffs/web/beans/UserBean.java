package com.charlieaffs.web.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.charlieaffs.data.tradeit.dao.UserDao;
import com.charlieaffs.data.tradeit.model.User;

@Component
@ManagedBean
@SessionScoped
public class UserBean {
	
	@Autowired
	private UserDao userDao;
	
	private static List<User> usersCache;
	
	public List<User> getUsers() {
		if(usersCache == null) {
			usersCache = userDao.findAll();
		}
		return usersCache;
	}
	
}
