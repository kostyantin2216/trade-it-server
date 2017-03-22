package com.charlieaffs.data.tradeit.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Transient;

import com.charlieaffs.data.DataModelObject;

public class ContentPage implements DataModelObject {
	private static final long serialVersionUID = -449100442244808338L;
	
	private Integer id;
    private Integer pageTypeId;
    private String title;
    private String description;
    private String androidIconResId;
    private String templateFileName;
    private String htmlContent;
    private Date createdAt;
    private Date updatedAt;

    public ContentPage() { }

    public ContentPage(Integer pageTypeId, String title, String description, String templateFileName, String htmlContent,
    		String androidIonResId, Date createdAt, Date updatedAt) {
        this.pageTypeId = pageTypeId;
        this.title = title;
        this.description = description;
        this.templateFileName = templateFileName;
        this.htmlContent = htmlContent;
        this.androidIconResId = androidIonResId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public ContentPage(Integer id, Integer pageTypeId, String title, String description, String templateFileName, 
    		String htmlContent, String androidIconResId, Date createdAt, Date updatedAt) {
        this.id = id;
        this.pageTypeId = pageTypeId;
        this.title = title;
        this.description = description;
        this.templateFileName = templateFileName;
        this.htmlContent = htmlContent;
        this.androidIconResId = androidIconResId;
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

    public Integer getPageTypeId() {
        return pageTypeId;
    }

    public void setPageTypeId(Integer pageTypeId) {
        this.pageTypeId = pageTypeId;
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

    public String getAndroidIconResId() {
        return androidIconResId;
    }

    public void setAndroidIconResId(String androidIconResId) {
        this.androidIconResId = androidIconResId;
    }

    public String getTemplateFileName() {
        return templateFileName;
    }

    public void setTemplateFileName(String templateFileName) {
        this.templateFileName = templateFileName;
    }

    public String getHtmlContent() {
        return htmlContent;
    }

    public void setHtmlContent(String htmlContent) {
        this.htmlContent = htmlContent;
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
		return "ContentPage [id=" + id + ", pageTypeId=" + pageTypeId + ", title=" + title + ", description="
				+ description + ", androidIconResId=" + androidIconResId + ", templateFileName=" + templateFileName
				+ ", htmlContent=" + (htmlContent.length() > 20 ? htmlContent.substring(0, 20) : htmlContent) + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}
    
}
