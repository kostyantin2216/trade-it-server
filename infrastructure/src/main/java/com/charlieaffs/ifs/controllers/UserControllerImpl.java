package com.charlieaffs.ifs.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.charlieaffs.data.tradeit.dao.UserDao;
import com.charlieaffs.data.tradeit.model.Country;
import com.charlieaffs.data.tradeit.model.User;
import com.charlieaffs.ifs.logging.TILogger;
import com.charlieaffs.ifs.utils.CountryUtils;
import com.charlieaffs.ifs.utils.Formatter;

@Component("userController")
public class UserControllerImpl implements UserController {

	@Autowired
	private UserDao userDao;
	
	public UserControllerImpl() { }
	
	@Override
	public User registerUser(User user) {
		user.setIsRegistered(true);

		List<User> similarUsers = userDao.findSimilar(user);
		
		if(Formatter.notEmpty(similarUsers)) {
			user = similarUsers.get(0);
		} else {
			int userId = (int) userDao.save(user);
			user.setId(userId);
		}
		
		return user;
	}
	
	@Override
	public User registerUser(User user, String ip) {
		Integer countryId = user.getCountryId();
		
		if(countryId == null) {
			Country country = CountryUtils.getCountryFromIp(ip);
			if(country != null) {
				user.setCountryId(country.getId());
				user.setCountry(country.getName());
			}
		} else if(Formatter.isEmpty(user.getCountry())) {
			Country country = CountryUtils.findById(countryId);
			if(country != null) {
				user.setCountry(country.getName());
			}
		}
		
		return registerUser(user);
	}
	
	@Override
	public User registerUser(String firstName, String lastName, String email, String telephone, String ip) {
		Country country = CountryUtils.getCountryFromIp(ip);

		if(country != null) {
			User user = new User();
			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setEmail(email);
			user.setTelephone(telephone);
			user.setCountry(country.getName());
			user.setCountryId(country.getId());
			if(email.contains("@")) {
				user.setPassword(email.substring(0, email.indexOf("@")));
			} else{
				user.setPassword("123456");
			}
			
			return registerUser(user);
		} else {
			TILogger.getLog().error("Could not register user becuase country could not be fetched using ip: " + ip, true);
		}

		return null;
	}
	
}
