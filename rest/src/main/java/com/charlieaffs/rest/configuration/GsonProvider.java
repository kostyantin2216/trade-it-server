package com.charlieaffs.rest.configuration;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonProvider {

	private final static GsonProvider instance = new GsonProvider();
	
	public static GsonProvider getInstance() {
		return instance;
	}
	
	private Gson gson;
	
	public GsonProvider() {
    	final GsonBuilder gsonBuilder = new GsonBuilder();
        gson = gsonBuilder.disableHtmlEscaping()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .serializeNulls()
                .create();
	}
	
	public Gson getGson() {
		return gson;
	}
}
