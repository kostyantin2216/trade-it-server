package com.charlieaffs.data.web.dao;

import com.charlieaffs.data.CommonDao;
import com.charlieaffs.data.web.model.Metadata;

public interface MetadataDao extends CommonDao<Metadata>{
	Metadata findByUri(String uri);
	Metadata getDefault();
}
