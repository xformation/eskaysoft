package com.rest.eskaysoftAPI.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.eskaysoftAPI.dao.ScheduleDao;
import com.rest.eskaysoftAPI.dto.ScheduleDTO;
import com.rest.eskaysoftAPI.entity.Schedule;
import com.rest.eskaysoftAPI.service.ScheduleService;

@Service("scheduleService")
public class ScheduleServiceImpl implements ScheduleService {

	@Autowired
	ScheduleDao scheduleDao;

	@Override
	public List<ScheduleDTO> getSchedules() {
		List<Schedule> schedules = new ArrayList<>(scheduleDao.findAll());
		List<ScheduleDTO> scheduleList = null;
		if (schedules != null) {
			scheduleList = new ArrayList<ScheduleDTO>();
			for (Schedule schedule : schedules) {
				ScheduleDTO scheduleDTO = new ScheduleDTO(schedule.getId(), schedule.getScheduleName(),
						schedule.getScheduleIndex(), schedule.getScheduleType(), schedule.getCreatedBy(),
						schedule.getCreatedOn(), schedule.getUpdatedBy(), schedule.getUpdatedOn());
				scheduleList.add(scheduleDTO);
			}
		}
		return scheduleList;
	}

	@Override
	public ScheduleDTO updateSchedule(ScheduleDTO scheduleDTO) {
		Schedule schedule = scheduleDao.findOne(scheduleDTO.getId());
		if (schedule != null) {
			schedule.setScheduleIndex(scheduleDTO.getScheduleIndex());
			schedule.setScheduleName(scheduleDTO.getScheduleName());
			schedule.setScheduleType(scheduleDTO.getScheduleType());
			schedule.setCreatedBy(scheduleDTO.getCreatedBy());
			schedule.setCreatedOn(scheduleDTO.getCreatedOn());
			schedule.setUpdatedBy(scheduleDTO.getUpdatedBy());
			schedule.setUpdatedOn(scheduleDTO.getUpdatedOn());
			schedule = scheduleDao.save(schedule);
			if (null != schedule) {
				return scheduleDTO;
			}
		}
		return null;
	}

	@Override
	public boolean createSchedule(ScheduleDTO scheduleDTO) {
		try {
			Schedule schedule = new Schedule(scheduleDTO.getScheduleName(), scheduleDTO.getScheduleIndex(),
					scheduleDTO.getScheduleType(), scheduleDTO.getCreatedBy(), scheduleDTO.getCreatedOn(),
					scheduleDTO.getUpdatedBy(), scheduleDTO.getUpdatedOn());
			Schedule savedSchedule = scheduleDao.save(schedule);
			return savedSchedule == null ? false : true;
		} catch (Exception e) {
			System.out.println("Unable to create schedule:" + scheduleDTO.getScheduleName());
		}
		return false;
	}

	@Override
	public boolean deleteSchedule(ScheduleDTO scheduleDTO) {
		try {
			scheduleDao.delete(scheduleDTO.getId());
			return true;
		} catch (Exception e) {
			System.out.println("Unable to delete schedule having id:" + scheduleDTO.getId());
		}
		return false;
	}

	@Override
	public ScheduleDTO getScheduleById(Long scheduleId) {
		Schedule schedule = scheduleDao.findOne(scheduleId);
		if (schedule != null) {
			ScheduleDTO scheduleDTO = new ScheduleDTO(schedule.getId(), schedule.getScheduleName(),
					schedule.getScheduleIndex(), schedule.getScheduleType(), schedule.getCreatedBy(),
					schedule.getCreatedOn(), schedule.getUpdatedBy(), schedule.getUpdatedOn());
			return scheduleDTO;
		}
		return null;
	}

}