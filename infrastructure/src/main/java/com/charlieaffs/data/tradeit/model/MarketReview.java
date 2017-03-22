package com.charlieaffs.data.tradeit.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Transient;

import com.charlieaffs.data.DataModelObject;

public class MarketReview implements DataModelObject {
	private static final long serialVersionUID = 1292210310288843512L;
	
	private Integer id;
	private String title;
	private String content;
	private String imageUrl;
	private Date createdAt;
	private Date updatedAt;

	public MarketReview() { }

	public MarketReview(String title, String content, String imageUrl, Date createdAt, 
			Date updatedAt) {
		this.title = title;
		this.content = content;
		this.imageUrl = imageUrl;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public MarketReview(Integer id, String title, String content, String imageUrl, 
			Date createdAt, Date updatedAt) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.imageUrl = imageUrl;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	@Override
	@Transient
	public void setSerializedId(Serializable id) throws ClassCastException {
		this.id = (Integer) id;
	}
	
	@Override
	@Transient
	public Serializable getSerializedId() {
		return id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	public Date getUpdatedAt() {
		return updatedAt;
	}
	
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "MarketReview [id=" + id + ", title=" + title + ", content=" + (content.length() > 20 ? content.substring(0, 20) : content) + ", imageUrl=" + imageUrl
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}

}
