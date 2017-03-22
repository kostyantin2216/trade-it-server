package com.charlieaffs.ifs.controllers;

import com.charlieaffs.data.tradeit.model.User;

public interface UserController {
	
	/**
	 * Check database for similar user, if none exist create new user.
	 * Will always return a User either with the old id or the new id
	 * unless errors occur (id -1 = user with this email already exists).
	 * 
	 * @param user
	 * @return 
	 */
	User registerUser(User user);
	
	/**
	 * Will check for country and if one does not exist will get it from IP and
	 * then check database for similar user, if none exist create new user.
	 * Will always return a User either with the old id or the new id
	 * unless errors occur (id -1 = user with this email already exists).
	 * 
	 * @param user
	 * @param ip
	 * @return 
	 */
	User registerUser(User user, String ip);
	
	/**
	 * creates a user from parameters and tries to get country from ip, if no country could be found
	 * then this method will return null otherwise will call UserController::registerUser(User user)
	 * with user created from method parameters. 
	 * 
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param telephone
	 * @param ip
	 * @return
	 */
	User registerUser(String firstName, String lastName, String email, String telephone, String ip);
	
}
