package com.charlieaffs.rest.resources;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import com.charlieaffs.data.tradeit.dao.UserDao;
import com.charlieaffs.data.tradeit.model.User;
import com.charlieaffs.ifs.configuration.SpringContextProvider;
import com.charlieaffs.ifs.controllers.UserController;

@Path(UserResource.END_POINT)
public class UserResourceImpl extends DataModelResourceImpl<UserDao, User> implements UserResource {

	@Context
	private HttpServletRequest httpReq;
	
	@Autowired
	public UserResourceImpl(UserDao dao) {
		super(dao);
	}
	
	@Override
	public String getEndPoint() {
		return UserResource.END_POINT;
	}

	@Override
	public Response register(User user) {
		String ip = httpReq.getRemoteAddr();
		
		UserController userController = SpringContextProvider.getUserController();
		return Response.ok(userController.registerUser(user, ip)).build();
	}

}
