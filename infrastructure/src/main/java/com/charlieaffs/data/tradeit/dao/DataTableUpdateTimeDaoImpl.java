package com.charlieaffs.data.tradeit.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.charlieaffs.data.BaseDao;
import com.charlieaffs.data.tradeit.model.DataTableUpdateTime;
import com.charlieaffs.ifs.logging.TILogger;

@Repository("updateTimeDao")
public class DataTableUpdateTimeDaoImpl extends BaseDao<DataTableUpdateTime> implements DataTableUpdateTimeDao {

	public final static String CLASS_NAME = "com.charlieaffs.data.tradeit.model.DataTableUpdateTime";
	public final static String TABLE_NAME = "update_timestamp";
	
	public final static String FLD_ID = "id";
	public final static String FLD_TABLE_NAME = "tableName";
	public final static String FLD_UPDATE_TIME = "updateTime";
	
	@Override
	@SuppressWarnings("unchecked")
	public Map<String, Date> getUpdateTimeMapForTables(String[] tables) {
		Map<String, Date> updateTimeMap = new HashMap<>();
		
		TILogger.getLog().info("fetching update timestamps for tables: " + tables);
		
		Criteria crit = getSession().createCriteria(CLASS_NAME);
		
		Criterion[] tableRestrictions = new Criterion[tables.length];
		for(int i = 0; i < tables.length; i++) {
			tableRestrictions[i] = Restrictions.eq(FLD_TABLE_NAME, tables[i]);
		}
		crit.add(Restrictions.or(tableRestrictions));
		
		TILogger.getLog().info("Criteria for update timestamps " + crit.toString());
		
		List<DataTableUpdateTime> l = crit.list();		
		
		TILogger.getLog().info("Results for update timestamps query: " + l.toArray().toString());
		
		for(DataTableUpdateTime updateTime : l) {
			updateTimeMap.put(updateTime.getTableName(), updateTime.getUpdateTime());
		}
		
		return updateTimeMap;
	}
	
	@Override
	public String getTableName() {
		return TABLE_NAME;
	}

	@Override
	public String getClassName() {
		return CLASS_NAME;
	}

}
