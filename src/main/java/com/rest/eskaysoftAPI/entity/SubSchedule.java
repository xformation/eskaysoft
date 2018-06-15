package com.rest.eskaysoftAPI.entity;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "subschedules")
public class SubSchedule {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long subScheduleId;
	private String subScheduleName;
	private String subScheduleType;
	private Long subScheduleIndex;
	private float credit;

	private float debit;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "scheduleId")
	private Schedule schedule;

	public SubSchedule() {

	}

	public SubSchedule(String subScheduleName, String subScheduleType, Long subScheduleIndex, float credit, float debit,
			Schedule schedule) {
		super();
		this.subScheduleName = subScheduleName;
		this.subScheduleType = subScheduleType;
		this.subScheduleIndex = subScheduleIndex;
		this.credit = credit;
		this.debit = debit;
		this.schedule = schedule;
	}

	public SubSchedule(Long subScheduleId, String subScheduleName, Long subScheduleIndex, String subScheduleType,
			float credit, float debit, Schedule schedule) {
		super();
		this.subScheduleId = subScheduleId;
		this.subScheduleName = subScheduleName;
		this.subScheduleType = subScheduleType;
		this.subScheduleIndex = subScheduleIndex;
		this.credit = credit;
		this.debit = debit;
		this.schedule = schedule;
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

	public Long getSubScheduleId() {
		return subScheduleId;
	}

	public void setSubScheduleId(Long subScheduleId) {
		this.subScheduleId = subScheduleId;
	}

	public String getSubScheduleName() {
		return subScheduleName;
	}

	public void setSubScheduleName(String subScheduleName) {
		this.subScheduleName = subScheduleName;
	}

	public Long getSubScheduleIndex() {
		return subScheduleIndex;
	}

	public String getSubScheduleType() {
		return subScheduleType;
	}

	public void setScheduleType(String subScheduleType) {
		this.subScheduleType = subScheduleType;
	}

	public void setSubScheduleIndex(Long subScheduleIndex) {
		this.subScheduleIndex = subScheduleIndex;
	}

	public float getCredit() {
		return credit;
	}

	public void setCredit(float credit) {
		this.credit = credit;
	}

	public float getDebit() {
		return debit;
	}

	public void setDebit(float debit) {
		this.debit = debit;
	}
}