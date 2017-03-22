package com.charlieaffs.rest.resources;

import javax.ws.rs.core.Response;

import com.charlieaffs.data.DataModelObject;
import com.charlieaffs.rest.requests.QueryServiceRequest;

public interface DataModelResource<E extends DataModelObject> extends RestResource {

	Response create(E entity);
	Response update(E entity);
	Response delete(String id);
	Response get(String id);
	Response get();
	Response getWithQueries(QueryServiceRequest req);
	
}
