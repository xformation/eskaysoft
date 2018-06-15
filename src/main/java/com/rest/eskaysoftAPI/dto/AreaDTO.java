package com.rest.eskaysoftAPI.dto;

import java.io.Serializable;
import java.util.Date;

public class AreaDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2099654952913091298L;
	private Long Id;
	private String AreaName;
	private String ExecutiveName;
	private String createdBy;
	private Date createdOn;
	private String updatedBy;
	private Date updatedOn;

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public AreaDTO() {

	}

	public AreaDTO(String areaName, String executiveName, String createdBy, Date createdOn, String updatedBy,
			Date updatedOn) {
		super();
		AreaName = areaName;
		ExecutiveName = executiveName;
		this.createdBy = createdBy;
		this.createdOn = createdOn;
		this.updatedBy = updatedBy;
		this.updatedOn = updatedOn;
	}

	public AreaDTO(Long id, String areaName, String executiveName, String createdBy, Date createdOn, String updatedBy,
			Date updatedOn) {
		super();
		Id = id;
		AreaName = areaName;
		ExecutiveName = executiveName;
		this.createdBy = createdBy;
		this.createdOn = createdOn;
		this.updatedBy = updatedBy;
		this.updatedOn = updatedOn;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	/**
	 * @return the areaName
	 */
	public String getAreaName() {
		return AreaName;
	}

	/**
	 * @param areaName
	 *            the areaName to set
	 */
	public void setAreaName(String areaName) {
		AreaName = areaName;
	}

	/**
	 * @return the executiveName
	 */
	public String getExecutiveName() {
		return ExecutiveName;
	}

	/**
	 * @param executiveName
	 *            the executiveName to set
	 */
	public void setExecutiveName(String executiveName) {
		ExecutiveName = executiveName;
	}

}