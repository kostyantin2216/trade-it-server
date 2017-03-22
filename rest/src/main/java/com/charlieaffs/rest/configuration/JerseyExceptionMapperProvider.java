package com.charlieaffs.rest.configuration;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.charlieaffs.ifs.logging.TILogger;

@Provider
public class JerseyExceptionMapperProvider implements ExceptionMapper<Exception> {

	@Override
	public Response toResponse(Exception exception) {
		TILogger.getLog().error("exception found in exception mapper", exception);
		return Response.status(500).build();
	}

}
