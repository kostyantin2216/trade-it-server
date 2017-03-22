package com.charlieaffs.data.tradeit.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Transient;

import com.charlieaffs.data.DataModelObject;

public class Broker implements DataModelObject {
	private static final long serialVersionUID = 8631457678917604956L;
	
	private Integer id;
	private String name;
	private String description;
	private String logoUrl;
	private Integer minDeposit;
	private Integer minWithdrawal;
	private String promotion;
	private Float rating;
	private Date createdAt;
	private Date updatedAt;
	private String url;
	private Boolean isRecommended;
	private Boolean isActive;

	public Broker() { }

	public Broker(String name, String description, String logoUrl, Integer minDeposit, 
			Integer minWithdrawal, String promotion, Float rating, Date createdAt, 
			Date updatedAt, String url, Boolean isRecommended, Boolean isActive) {
		this.name = name;
		this.description = description;
		this.logoUrl = logoUrl;
		this.minDeposit = minDeposit;
		this.minWithdrawal = minWithdrawal;
		this.promotion = promotion;
		this.rating = rating;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.url = url;
		this.isRecommended = isRecommended;
		this.isActive = isActive;
	}

	public Broker(Integer id, String name, String description, String logoUrl, Integer minDeposit, 
			Integer minWithdrawal, String promotion, Float rating, Date createdAt, Date updatedAt, 
			String url, Boolean isRecommended, Boolean isActive) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.logoUrl = logoUrl;
		this.minDeposit = minDeposit;
		this.minWithdrawal = minWithdrawal;
		this.promotion = promotion;
		this.rating = rating;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.url = url;
		this.isRecommended = isRecommended;
		this.isActive = isActive;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLogoUrl() {
		return logoUrl;
	}

	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}

	public Integer getMinDeposit() {
		return minDeposit;
	}

	public void setMinDeposit(Integer minDeposit) {
		this.minDeposit = minDeposit;
	}

	public Integer getMinWithdrawal() {
		return minWithdrawal;
	}

	public void setMinWithdrawal(Integer minWithdrawal) {
		this.minWithdrawal = minWithdrawal;
	}

	public String getPromotion() {
		return promotion;
	}

	public void setPromotion(String promotion) {
		this.promotion = promotion;
	}

	public Float getRating() {
		return rating;
	}

	public void setRating(Float rating) {
		this.rating = rating;
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
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}

	public Boolean getIsRecommended() {
		return isRecommended;
	}

	public void setIsRecommended(Boolean isRecommended) {
		this.isRecommended = isRecommended;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "Broker [id=" + id + ", name=" + name + ", description=" + description + ", logoUrl=" + logoUrl
				+ ", minDeposit=" + minDeposit + ", minWithdrawal=" + minWithdrawal + ", promotion=" + promotion
				+ ", rating=" + rating + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", url=" + url
				+ ", isRecommended=" + isRecommended + ", isActive=" + isActive + "]";
	}
	
}
