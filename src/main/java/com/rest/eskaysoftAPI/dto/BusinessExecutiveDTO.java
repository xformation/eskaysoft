package com.rest.eskaysoftAPI.dto;

import java.io.Serializable;
import java.util.Date;

public class BusinessExecutiveDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private String address;
	private String town;
	private Long mobile;
	private String createdBy;
	private Date createdOn;
	private String updatedBy;
	private Date updatedOn;

	public BusinessExecutiveDTO() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public Long getMobile() {
		return mobile;
	}

	public void setMobile(Long mobile) {
		this.mobile = mobile;
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

	public BusinessExecutiveDTO(Long id, String name, String address, String town, Long mobile, String createdBy,
			Date createdOn, String updatedBy, Date updatedOn) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.town = town;
		this.mobile = mobile;
		this.createdBy = createdBy;
		this.createdOn = createdOn;
		this.updatedBy = updatedBy;
		this.updatedOn = updatedOn;
	}

	public BusinessExecutiveDTO(String name, String address, String town, Long mobile, String createdBy, Date createdOn,
			String updatedBy, Date updatedOn) {
		super();
		this.name = name;
		this.address = address;
		this.town = town;
		this.mobile = mobile;
		this.createdBy = createdBy;
		this.createdOn = createdOn;
		this.updatedBy = updatedBy;
		this.updatedOn = updatedOn;
	}

}
