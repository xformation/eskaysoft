package com.rest.eskaysoftAPI.dto;

import java.io.Serializable;
import java.util.Date;

public class StateDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long Id;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	private String stateName;
	private Long stateCode;
	private String zone;
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

	public StateDTO() {

	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public Long getStateCode() {
		return stateCode;
	}

	public void setStateCode(Long stateCode) {
		this.stateCode = stateCode;
	}

	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

	public StateDTO(Long id, String stateName, Long stateCode, String zone, String createdBy, Date createdOn,
			String updatedBy, Date updatedOn) {
		super();
		this.Id = id;
		this.stateName = stateName;
		this.stateCode = stateCode;
		this.zone = zone;
		this.createdBy = createdBy;
		this.createdOn = createdOn;
		this.updatedBy = updatedBy;
		this.updatedOn = updatedOn;
	}

	public StateDTO(String stateName, Long stateCode, String zone, String createdBy, Date createdOn, String updatedBy,
			Date updatedOn) {
		super();
		this.stateName = stateName;
		this.stateCode = stateCode;
		this.zone = zone;
		this.createdBy = createdBy;
		this.createdOn = createdOn;
		this.updatedBy = updatedBy;
		this.updatedOn = updatedOn;
	}

}