package com.charlieaffs.data.web.dao;

import org.springframework.stereotype.Repository;

import com.charlieaffs.data.BaseDao;
import com.charlieaffs.data.web.model.Metadata;

@Repository("metadataDao")
public class MetadataDaoImpl extends BaseDao<Metadata> implements MetadataDao {

	public final static String CLASS_NAME = "com.charlieaffs.data.web.model.Metadata";
	public final static String TABLE_NAME = "Metadata";
	
	public final static String ID = "id";
	public final static String URI = "uri";
	public final static String TITLE = "title";
	public final static String DESCRIPTION = "description";
	public final static String KEYWORDS = "keywords";
	
	@Override
	public Metadata findByUri(String uri) {
		if(uri != null) {
			return findEntityByProperty(URI, uri);
		}
		return null;
	}

	@Override
	public Metadata getDefault() {
		return findEntityByProperty(URI, ":default");
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
