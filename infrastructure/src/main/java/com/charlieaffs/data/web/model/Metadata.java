package com.charlieaffs.data.web.model;

import java.io.Serializable;

import com.charlieaffs.data.DataModelObject;

public class Metadata implements DataModelObject {
	private static final long serialVersionUID = -6633617867645356414L;
	
	private Integer id;
	private String uri;
	private String title;
	private String description;
	private String keywords;
	
	public Metadata() { }
	
	public Metadata(Integer id, String uri, String title, String description, String keywords) {
		this.id = id;
		this.uri = uri;
		this.title = title;
		this.description = description;
		this.keywords = keywords;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	@Override
	public String toString() {
		return "Metadata [id=" + id + ", uri=" + uri + ", title=" + title + ", description=" + description
				+ ", keywords=" + keywords + "]";
	}

	@Override
	public Serializable getSerializedId() {
		return id;
	}

	@Override
	public void setSerializedId(Serializable id) throws ClassCastException {
		this.id = (Integer) id;
	}
	
}
