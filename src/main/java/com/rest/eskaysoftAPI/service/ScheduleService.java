package com.rest.eskaysoftAPI.service;

import java.util.List;

import com.rest.eskaysoftAPI.dto.ScheduleDTO;

public interface ScheduleService {
	/**
	 * 
	 * @return
	 */
	List<ScheduleDTO> getSchedules();
	/**
	 * 
	 * @param scheduleId
	 * @return
	 */
	ScheduleDTO getScheduleById(Long scheduleId);
	/**
	 * 
	 * @param schedule
	 * @return
	 */
	boolean createSchedule(ScheduleDTO schedule);
	/**
	 * 
	 * @param schedule
	 * @return
	 */
	ScheduleDTO updateSchedule(ScheduleDTO schedule);
	/**
	 * 
	 * @param schedule
	 * @return
	 */
	boolean deleteSchedule(ScheduleDTO schedule);
}

