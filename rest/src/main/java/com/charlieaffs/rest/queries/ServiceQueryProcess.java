package com.charlieaffs.rest.queries;

import java.util.List;

import com.charlieaffs.data.CommonDao;
import com.charlieaffs.data.DataModelObject;

public interface ServiceQueryProcess<E extends DataModelObject> {
	void setDao(CommonDao<E> dao);
	List<E> process(List<ServiceQuery> queries);
}
