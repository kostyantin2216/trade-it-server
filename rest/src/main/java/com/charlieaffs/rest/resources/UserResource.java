package com.charlieaffs.rest.resources;

import javax.ws.rs.core.Response;

import com.charlieaffs.data.tradeit.model.User;

public interface UserResource extends DataModelResource<User> {
	String END_POINT = "Users";
	
	Response register(User user);
}
