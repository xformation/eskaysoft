package com.rest.eskaysoftAPI.dto;

import java.io.Serializable;
import java.util.Date;

public class ScheduleDTO implements Serializable {

	/**
	 * ScheduleDTO for Schedules
	 * 
	 * @author SuryaSree
	 * @since 7th May, 2018
	 *
	 */
	private static final long serialVersionUID = 2099654952913091298L;
	private Long Id;
	private String ScheduleName;
	private int ScheduleIndex;
	private String ScheduleType;
	private String createdBy;
	private Date createdOn;
	private String updatedBy;
	private Date updatedOn;

	public ScheduleDTO() {
	}

	/*
	 * return id
	 * 
	 */
	public Long getId() {
		return Id;
	}

	/*
	 * @param set the id
	 */
	public void setId(Long id) {
		Id = id;
	}

	/*
	 * return schedule name
	 */
	public String getScheduleName() {
		return ScheduleName;
	}

	/*
	 * @param set thr chedule name
	 */
	public void setScheduleName(String scheduleName) {
		ScheduleName = scheduleName;
	}

	/*
	 * return schedule index
	 */
	public int getScheduleIndex() {
		return ScheduleIndex;
	}

	/*
	 * @param set the schedule index
	 */
	public void setScheduleIndex(int scheduleIndex) {
		ScheduleIndex = scheduleIndex;
	}

	/*
	 * return schedule type
	 */
	public String getScheduleType() {
		return ScheduleType;
	}

	/*
	 * set the schedule type
	 */
	public void setScheduleType(String scheduleType) {
		ScheduleType = scheduleType;
	}

	/*
	 * return create by name
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/*
	 * @param set create by name
	 */

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/*
	 * get the created date
	 */
	public Date getCreatedOn() {
		return createdOn;
	}

	/*
	 * @param set create date
	 */
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	/*
	 * get update by name
	 */
	public String getUpdatedBy() {
		return updatedBy;
	}

	/*
	 * @param set update by name
	 */
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	/*
	 * return updated date
	 */
	public Date getUpdatedOn() {
		return updatedOn;
	}

	/*
	 * @param set update on date
	 */
	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public ScheduleDTO(Long id, String scheduleName, int scheduleIndex, String scheduleType, String createdBy,
			Date createdOn, String updatedBy, Date updatedOn) {
		super();
		this.Id = id;
		this.ScheduleName = scheduleName;
		this.ScheduleIndex = scheduleIndex;
		this.ScheduleType = scheduleType;
		this.createdBy = createdBy;
		this.createdOn = createdOn;
		this.updatedBy = updatedBy;
		this.updatedOn = updatedOn;
	}

	public ScheduleDTO(String scheduleName, int scheduleIndex, String scheduleType, String createdBy, Date createdOn,
			String updatedBy, Date updatedOn) {
		super();
		this.ScheduleName = scheduleName;
		this.ScheduleIndex = scheduleIndex;
		this.ScheduleType = scheduleType;
		this.createdBy = createdBy;
		this.createdOn = createdOn;
		this.updatedBy = updatedBy;
		this.updatedOn = updatedOn;
	}

}