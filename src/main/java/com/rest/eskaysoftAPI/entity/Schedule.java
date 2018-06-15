package com.rest.eskaysoftAPI.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "schedules")
public class Schedule implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long scheduleId;
	private String scheduleName;
	private int scheduleIndex;
	private String scheduleType;
	private String createdBy;
	private Date createdOn;
	private String updatedBy;
	private Date updatedOn;

	public Schedule() {

	}

	/*
	 * return scheduleId
	 */
	public Long getScheduleId() {
		return scheduleId;
	}
	/*
	 * @param set the scheduleId
	 */

	public void setScheduleId(Long scheduleId) {
		this.scheduleId = scheduleId;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return scheduleId;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.scheduleId = id;
	}

	public Schedule(Long id, String scheduleName, int scheduleIndex, String scheduleType, String createdBy,
			Date createdOn, String updatedBy, Date updatedOn) {
		super();
		this.scheduleId = id;
		this.scheduleName = scheduleName;
		this.scheduleIndex = scheduleIndex;
		this.scheduleType = scheduleType;
		this.createdBy = createdBy;
		this.createdOn = createdOn;
		this.updatedBy = updatedBy;
		this.updatedOn = updatedOn;
	}

	public Schedule(String scheduleName, int scheduleIndex, String scheduleType, String createdBy, Date createdOn,
			String updatedBy, Date updatedOn) {
		super();
		this.scheduleName = scheduleName;
		this.scheduleIndex = scheduleIndex;
		this.scheduleType = scheduleType;
		this.createdBy = createdBy;
		this.createdOn = createdOn;
		this.updatedBy = updatedBy;
		this.updatedOn = updatedOn;
	}

	/*
	 * @return create by name
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/*
	 * @return create on date
	 */
	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	/*
	 * @return update by name
	 */
	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	/*
	 *@return update on date
	 */
	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	/**
	 * @return the scheduleName
	 */
	public String getScheduleName() {
		return scheduleName;
	}

	/**
	 * @param scheduleName
	 *            the scheduleName to set
	 */
	public void setScheduleName(String scheduleName) {
		this.scheduleName = scheduleName;
	}

	/**
	 * @return the scheduleIndex
	 */
	public int getScheduleIndex() {
		return scheduleIndex;
	}

	/**
	 * @param scheduleIndex
	 *            the scheduleIndex to set
	 */
	public void setScheduleIndex(int scheduleIndex) {
		this.scheduleIndex = scheduleIndex;
	}

	/*
	 * @return the schedule type
	 */
	public String getScheduleType() {
		return scheduleType;
	}

	/*
	 * @param scheduleType schedule type to set
	 * 
	 */
	public void setScheduleType(String scheduleType) {
		this.scheduleType = scheduleType;
	}
}
