package com.rest.eskaysoftAPI.service;

import java.util.List;

import com.rest.eskaysoftAPI.dto.SubScheduleDTO;

public interface SubScheduleService {
	/**
	 * 
	 * @return
	 */

	List<SubScheduleDTO> getSubSchedules();
	/**
	 * 
	 * @param subScheduleId
	 * @return
	 */

	SubScheduleDTO getSubScheduleById(Long subScheduleId);
	/**
	 * 
	 * @param subschedule
	 * @return
	 */

	boolean createSubSchedule(SubScheduleDTO subschedule);
	/**
	 * 
	 * @param subschedule
	 * @return
	 */

	SubScheduleDTO upadateSubSchedule(SubScheduleDTO subschedule);
	/**
	 * 
	 * @param subschedule
	 * @return
	 */

	boolean deleteSubSchedule(SubScheduleDTO subschedule);

}
