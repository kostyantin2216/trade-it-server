package com.charlieaffs.rest.configuration;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;

import com.owlike.genson.ext.jaxrs.GensonJsonConverter;

public class JerseyConfig extends ResourceConfig {

	public JerseyConfig() {
        register(RequestContextFilter.class);
        packages("com.charlieaffs.rest");
        register(GensonJsonConverter.class);
      //  register(LoggingFilter.class);
      //  registerInstances(new LoggingFilter(Logger.getLogger(JerseyConfig.class.getName()), true));
    }
}