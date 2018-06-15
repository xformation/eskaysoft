package com.rest.eskaysoftAPI.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "districts")
public class Districts {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long districtId;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "stateId")
	private States state;

	private String districtName;
	private String createdBy;
	private Date createdOn;
	private String updatedBy;
	private Date updatedOn;

	public Districts() {
	}

	public void setState(States state) {
		this.state = state;
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

	/**
	 * @return the state
	 */
	public States getState() {
		return state;
	}

	public Long getDistrictId() {
		return districtId;
	}

	public void setDistrictId(Long districtId) {
		this.districtId = districtId;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public States setStateName(States state) {
		return this.state = state;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return districtId;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.districtId = id;
	}

	public Districts(Long id, States state, String districtName, String createdBy, Date createdOn, String updatedBy,
			Date updatedOn) {
		super();
		this.districtId = id;
		this.state = state;
		this.districtName = districtName;
		this.createdBy = createdBy;
		this.createdOn = createdOn;
		this.updatedBy = updatedBy;
		this.updatedOn = updatedOn;
	}

	public Districts(String districtName, States state, String createdBy, Date createdOn, String updatedBy,
			Date updatedOn) {
		super();
		this.state = state;
		this.districtName = districtName;
		this.createdBy = createdBy;
		this.createdOn = createdOn;
		this.updatedBy = updatedBy;
		this.updatedOn = updatedOn;
	}

}
