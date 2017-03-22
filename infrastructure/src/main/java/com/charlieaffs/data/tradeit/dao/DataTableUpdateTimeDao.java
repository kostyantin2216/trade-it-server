package com.charlieaffs.data.tradeit.dao;

import java.util.Date;
import java.util.Map;

import com.charlieaffs.data.CommonDao;
import com.charlieaffs.data.tradeit.model.DataTableUpdateTime;

public interface DataTableUpdateTimeDao extends CommonDao<DataTableUpdateTime> {
	Map<String, Date> getUpdateTimeMapForTables(String[] tables);
}
