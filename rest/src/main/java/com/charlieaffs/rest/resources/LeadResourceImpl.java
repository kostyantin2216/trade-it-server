package com.charlieaffs.rest.resources;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.charlieaffs.data.tradeit.model.BrokerRegistration;
import com.charlieaffs.data.tradeit.model.User;
import com.charlieaffs.ifs.configuration.SpringContextProvider;
import com.charlieaffs.ifs.controllers.BrokerController;
import com.charlieaffs.ifs.controllers.UserController;
import com.charlieaffs.rest.requests.LeadBrokerRegistrationRequest;
import com.charlieaffs.rest.requests.LeadRegistrationRequest;
import com.charlieaffs.rest.requests.RecycleLeadsRequest;
import com.charlieaffs.rest.responses.UserBrokerRegistrationResponse;

@Path(LeadResource.END_POINT)
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class LeadResourceImpl implements LeadResource {

	@Context
	private HttpServletRequest httpReq;
	
	@Override
	public String getEndPoint() {
		return END_POINT;
	}
	
	public LeadResourceImpl() { }

	@POST
	@Path("registerUser")
	@Override
	public Response registerUser(LeadRegistrationRequest req) {
		User user = req.getUser();
		
		if(user == null) {
			return Response.notModified("no user was found").build();
		}

		String ip = httpReq.getRemoteAddr();
		
		UserController userController = SpringContextProvider.getUserController();
		user = userController.registerUser(user, ip);
		
		BrokerRegistration[] details = null;
		if(req.getRegisterWithBrokers()) {
			BrokerController brokerController = SpringContextProvider.getBrokerController();
			details = brokerController.registerWithBrokers(user, ip);
		}
		
		return Response
				.ok(new UserBrokerRegistrationResponse(
							user, 
							ip,
							details))
				.build();
	}
	
	@POST
	@Path("register")
	@Override
	public Response registerNewUserWithBrokers(LeadBrokerRegistrationRequest req) {
		BrokerController controller = SpringContextProvider.getBrokerController();
		BrokerRegistration[] details = controller.registerWithBrokers(req.getUser(), httpReq.getRemoteAddr());
		
		return Response.ok(details).build();
	}
	
	@POST
	@Path("recycle")
	@Override
	public Response registerOldUsersWithBroker(RecycleLeadsRequest req) {
		BrokerController controller = SpringContextProvider.getBrokerController();
		BrokerRegistration[] details = controller.registerOldUsersWithBrokers(req.getUserIds(), req.getCompanyIds());
		
		return Response.ok(details).build();
	}

}
