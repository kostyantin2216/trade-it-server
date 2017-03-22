package com.charlieaffs.rest.resources;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.commons.lang3.math.NumberUtils;

import com.charlieaffs.data.CommonDao;
import com.charlieaffs.data.DataModelObject;
import com.charlieaffs.ifs.configuration.SpringContextProvider;
import com.charlieaffs.ifs.logging.TILogger;
import com.charlieaffs.rest.queries.ServiceQuery;
import com.charlieaffs.rest.queries.ServiceQueryProcess;
import com.charlieaffs.rest.requests.QueryServiceRequest;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public abstract class DataModelResourceImpl<DAO extends CommonDao<E>, E extends DataModelObject> 
	implements DataModelResource<E> {
	
	protected DAO dao;
	
	public DataModelResourceImpl(DAO dao) {
		this.dao = dao;
	}
	
	@POST
	@Override
	public Response create(E entity) {
		TILogger.getLog().info("Saving entity(" + dao.getTableName() + "): " + entity);
		
		Serializable entityId = dao.save(entity);
		
		Response response;
		if(entityId == null) {
			response = Response.status(Response.Status.BAD_REQUEST).entity("Could not save object.").build();
		} else {
			entity.setSerializedId(entityId);
			response = Response.ok(entity).build();
		}
		
		return response;
	}
	
	@GET
	public Response get() {
		return Response.ok(dao.findAll()).build();
	}
	
	@SuppressWarnings("unchecked")
	@POST
	@Path("query")
	@Override
	public Response getWithQueries(QueryServiceRequest req) {
		TILogger.getLog().debug("QueryRequest accepted for end point \"" + getEndPoint() + "\", queries = " + req.toString());
		ServiceQuery[] queries = req.getQueries();
		
		if(queries == null || queries.length < 1) {
			TILogger.getLog().warn("No queries in QueryServiceRequest... returning all items");;
			return get();
		}
		
		ServiceQueryProcess<E> processor = (ServiceQueryProcess<E>) 
				SpringContextProvider.getApplicationContext().getBean("queryProcessor");
		processor.setDao(dao);
		List<E> results = processor.process(Arrays.asList(queries));
		
		Response response;
		if(results == null || results.isEmpty()) {
			TILogger.getLog().debug("No results to return");
			response = Response.status(Response.Status.NO_CONTENT).build();
		} else {
			TILogger.getLog().debug("Returning " + results.size() + " results");
			response = Response.ok(results).build();
		}
		
		return response;
	}
	
	@GET
	@Path("{id}")
	@Override
	public Response get(@PathParam("id") String id) {
		TILogger.getLog().info("Fetching entity(" + dao.getTableName() + ") with id: " + id);
		if(NumberUtils.isNumber(id)) {
			E entity = dao.findById(Integer.parseInt(id));
			if(entity != null) {
				TILogger.getLog().info("Found entity(" + dao.getTableName() + "): " + entity);
				return Response.ok(entity).build();
			}
		}
		TILogger.getLog().warn("No entity found");
		return Response.status(Response.Status.BAD_REQUEST).build();
	}
	
	@PUT
	@Override
	public Response update(E entity) {
		TILogger.getLog().info("Updating entity(" + dao.getTableName() + "): " + entity);
		dao.update(entity);
		return Response.status(Status.OK).entity(entity).build();
	}

	@DELETE
	@Path("{id}")
	@Override
	public Response delete(@PathParam("id") String id) {
		TILogger.getLog().info("Deleting entity(" + dao.getTableName() + ") with id: " + id);
		
		if(NumberUtils.isNumber(id)) {
			TILogger.getLog().info("id is " + id + " after parsing to integer " + Integer.parseInt(id));
			dao.delete(Integer.parseInt(id));
		} else {
			dao.delete(id);
		}
		
		return Response.ok().build();
	}

}
