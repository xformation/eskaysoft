package com.rest.eskaysoftAPI.dto;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.rest.eskaysoftAPI.entity.Schedule;

public class SubScheduleDTO {

	private Long SubScheduleId;
	private String SubScheduleName;
	private String SubScheduleType;
	private Long SubScheduleIndex;
	private float Credit;

	private float Debit;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "scheduleId")
	private Schedule schedule;

	public SubScheduleDTO() {

	}

	public SubScheduleDTO(Long subScheduleId, String subScheduleName, Long subScheduleIndex, String subScheduleType,
			float credit, float debit, Schedule schedule) {

		SubScheduleId = subScheduleId;
		SubScheduleName = subScheduleName;
		SubScheduleType = subScheduleType;
		SubScheduleIndex = subScheduleIndex;
		Credit = credit;
		Debit = debit;
		this.schedule = schedule;
	}

	public SubScheduleDTO(String subScheduleName, String subScheduleType, Long subScheduleIndex, float credit,
			float debit, Schedule schedule) {

		SubScheduleName = subScheduleName;
		SubScheduleType = subScheduleType;
		SubScheduleIndex = subScheduleIndex;
		Credit = credit;
		Debit = debit;
		this.schedule = schedule;
	}

	/**
	 * @return the subScheduleId
	 */
	public Long getSubScheduleId() {
		return SubScheduleId;
	}

	/**
	 * @param subScheduleId
	 *            the subScheduleId to set
	 */
	public void setSubScheduleId(Long subScheduleId) {
		SubScheduleId = subScheduleId;
	}

	/**
	 * @return the subScheduleName
	 */
	public String getSubScheduleName() {
		return SubScheduleName;
	}

	/**
	 * @param subScheduleName
	 *            the subScheduleName to set
	 */
	public void setSubScheduleName(String subScheduleName) {
		SubScheduleName = subScheduleName;
	}

	/**
	 * @return the scheduleType
	 */
	public String getSubScheduleType() {
		return SubScheduleType;
	}

	/**
	 * @param scheduleType
	 *            the scheduleType to set
	 */
	public void setSubScheduleType(String subScheduleType) {
		SubScheduleType = subScheduleType;
	}

	/**
	 * @return the subScheduleIndex
	 */
	public Long getSubScheduleIndex() {
		return SubScheduleIndex;
	}

	/**
	 * @param subScheduleIndex
	 *            the subScheduleIndex to set
	 */
	public void setSubScheduleIndex(Long subScheduleIndex) {
		SubScheduleIndex = subScheduleIndex;
	}

	/**
	 * @return the credit
	 */
	public float getCredit() {
		return Credit;
	}

	/**
	 * @param credit
	 *            the credit to set
	 */
	public void setCredit(float credit) {
		Credit = credit;
	}

	/**
	 * @return the debit
	 */
	public float getDebit() {
		return Debit;
	}

	/**
	 * @param debit
	 *            the debit to set
	 */
	public void setDebit(float debit) {
		Debit = debit;
	}

	/**
	 * @return the schedule
	 */
	public Schedule getSchedule() {
		return schedule;
	}

	/**
	 * @param schedule
	 *            the schedule to set
	 */
	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

}
