package com.charlieaffs.rest.requests;

public class RecycleLeadsRequest {
	
	private Integer[] userIds;
	private Integer[] companyIds;
	
	public RecycleLeadsRequest() { }

	public RecycleLeadsRequest(Integer[] companyIds, Integer[] userIds) {
		this.companyIds = companyIds;
		this.userIds = userIds;
	}

	public Integer[] getUserIds() {
		return userIds;
	}

	public void setUserIds(Integer[] userIds) {
		this.userIds = userIds;
	}

	public Integer[] getCompanyIds() {
		return companyIds;
	}

	public void setCompanyIds(Integer[] companyIds) {
		this.companyIds = companyIds;
	}
	
}
