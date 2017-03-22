package com.charlieaffs.rest.configuration;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.Consumes;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.Provider;

import com.charlieaffs.ifs.logging.TILogger;
import com.google.gson.Gson;

@Provider
@Consumes(MediaType.APPLICATION_JSON)
public class GsonMessageReader implements MessageBodyReader<Object> {
	
	private Gson gson = GsonProvider.getInstance().getGson();

	@Override
	public boolean isReadable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
		return true;
	}

	@Override
	public Object readFrom(Class<Object> type, Type genericType, Annotation[] annotations, MediaType mediaType,
			MultivaluedMap<String, String> httpHeaders, InputStream entityStream)
					throws IOException, WebApplicationException {
		InputStreamReader streamReader = null;
        try {
            streamReader = new InputStreamReader(entityStream, "utf-8");
        } catch (UnsupportedEncodingException e) {
            TILogger.getLog().error("could not open stream for reading json entity", e, true);
        }
        try {
            Type jsonType;
            if (type.equals(genericType)) {
                jsonType = type;
            } else {
                jsonType = genericType;
            }
            return gson.fromJson(streamReader, jsonType);
        } finally {
            try {
                streamReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
	}

}
