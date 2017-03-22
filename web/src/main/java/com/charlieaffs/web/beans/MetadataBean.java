package com.charlieaffs.web.beans;

import javax.faces.bean.ManagedBean;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.charlieaffs.data.web.dao.MetadataDao;
import com.charlieaffs.data.web.model.Metadata;
import com.charlieaffs.ifs.utils.Formatter;

@Controller
@ManagedBean
@Scope("request")
public class MetadataBean  {

	private Metadata metadata;
	
	@Autowired
	public MetadataBean(MetadataDao metadataDao, HttpServletRequest req) {
		String uri = req.getRequestURI();
		if(Formatter.notEmpty(uri)) {
			this.metadata = metadataDao.findByUri(uri);
			// TODO: if metadata is null generate default.
		}
		if(metadata == null) {
			this.metadata = metadataDao.getDefault();
		}
	}
	
	public String getTitle() {
		return metadata.getTitle();
	}
	
	public String getDescription() {
		return metadata.getDescription();
	}
	
	public String getKeywords() {
		return metadata.getKeywords();
	}
	
}
