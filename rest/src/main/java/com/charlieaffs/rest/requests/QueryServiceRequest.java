package com.charlieaffs.rest.requests;

import com.charlieaffs.rest.queries.ServiceQuery;

public class QueryServiceRequest implements RestRequest {

	private ServiceQuery[] queries;
	
	public QueryServiceRequest() { }
	
	public QueryServiceRequest(ServiceQuery[] queries) {
		this.queries = queries;
	}

	public ServiceQuery[] getQueries() {
		return queries;
	}

	public void setQueries(ServiceQuery[] queries) {
		this.queries = queries;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(ServiceQuery query : queries){
			sb.append(query.toString()).append(",");
		}
		return sb.toString();
	}
	
}
