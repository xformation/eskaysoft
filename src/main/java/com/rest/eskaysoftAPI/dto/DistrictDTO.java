package com.rest.eskaysoftAPI.dto;

import java.io.Serializable;
import java.util.Date;

import com.rest.eskaysoftAPI.entity.States;

public class DistrictDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long Id;

	private String districtName;
	private States state;

	private String createdBy;
	private Date createdOn;
	private String updatedBy;
	private Date updatedOn;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

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

	public void setState(States state) {
		this.state = state;
	}

	public DistrictDTO() {

	}

	public States getState() {
		return state;
	}

	public States setStates() {
		return state;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public DistrictDTO(Long id, String districtName, States state, String createdBy, Date createdOn, String updatedBy,
			Date updatedOn) {
		super();
		Id = id;
		this.districtName = districtName;
		this.state = state;
		this.createdBy = createdBy;
		this.createdOn = createdOn;
		this.updatedBy = updatedBy;
		this.updatedOn = updatedOn;
	}

	public DistrictDTO(String districtName, States state, String createdBy, Date createdOn, String updatedBy,
			Date updatedOn) {
		super();
		this.districtName = districtName;
		this.state = state;
		this.createdBy = createdBy;
		this.createdOn = createdOn;
		this.updatedBy = updatedBy;
		this.updatedOn = updatedOn;
	}

}