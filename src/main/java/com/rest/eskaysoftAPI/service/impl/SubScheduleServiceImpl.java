package com.rest.eskaysoftAPI.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.eskaysoftAPI.dao.SubScheduleDao;
import com.rest.eskaysoftAPI.dto.SubScheduleDTO;
import com.rest.eskaysoftAPI.entity.SubSchedule;
import com.rest.eskaysoftAPI.service.SubScheduleService;

@Service("subScheduleService")
public class SubScheduleServiceImpl implements SubScheduleService {

	@Autowired
	SubScheduleDao subScheduleDao;

	@Override
	public List<SubScheduleDTO> getSubSchedules() {
		List<SubSchedule> subschedules = new ArrayList<>(subScheduleDao.findAll());
		List<SubScheduleDTO> subScheduleList = null;
		if (subschedules != null) {
			subScheduleList = new ArrayList<SubScheduleDTO>();
			for (SubSchedule subschedule : subschedules) {
				SubScheduleDTO subScheduleDTO = new SubScheduleDTO(subschedule.getSubScheduleId(),
						subschedule.getSubScheduleName(), subschedule.getSubScheduleIndex(),
						subschedule.getSubScheduleType(), subschedule.getCredit(), subschedule.getDebit(),
						subschedule.getSchedule());
				subScheduleList.add(subScheduleDTO);
			}
		}

		return subScheduleList;
	}

	@Override
	public SubScheduleDTO getSubScheduleById(Long subScheduleId) {
		SubSchedule subschedule = subScheduleDao.findOne(subScheduleId);
		if (subschedule != null) {
			SubScheduleDTO subScheduleDTO = new SubScheduleDTO(subschedule.getSubScheduleId(),
					subschedule.getSubScheduleName(), subschedule.getSubScheduleIndex(),
					subschedule.getSubScheduleType(), subschedule.getCredit(), subschedule.getDebit(),
					subschedule.getSchedule());
			return subScheduleDTO;
		}
		return null;
	}

	@Override
	public SubScheduleDTO upadateSubSchedule(SubScheduleDTO subScheduleDTO) {
		SubSchedule subschedule = subScheduleDao.findOne(subScheduleDTO.getSubScheduleId());

		if (subschedule != null) {
			subschedule.setSubScheduleIndex(subScheduleDTO.getSubScheduleIndex());
			subschedule.setSubScheduleName(subScheduleDTO.getSubScheduleName());
			subschedule.setScheduleType(subScheduleDTO.getSubScheduleType());
			subschedule.setCredit(subScheduleDTO.getCredit());
			subschedule.setDebit(subScheduleDTO.getDebit());
			subschedule.setSchedule(subScheduleDTO.getSchedule());
			subschedule = subScheduleDao.save(subschedule);
			if (null != subschedule) {
				return subScheduleDTO;
			}
		}

		return null;
	}

	@Override
	public boolean createSubSchedule(SubScheduleDTO subScheduleDTO) {
		try {
			SubSchedule subschedule = new SubSchedule(null, subScheduleDTO.getSubScheduleName(),
					subScheduleDTO.getSubScheduleIndex(), subScheduleDTO.getSubScheduleType(),
					subScheduleDTO.getCredit(), subScheduleDTO.getDebit(), subScheduleDTO.getSchedule());
			SubSchedule savedSubSchedule = subScheduleDao.save(subschedule);
			return savedSubSchedule == null ? false : true;
		} catch (Exception e) {
			System.out.println("Unable to create subschedule:" + subScheduleDTO.getSubScheduleName());
		}
		return false;
	}

	@Override
	public boolean deleteSubSchedule(SubScheduleDTO subScheduleDTO) {
		try {
			subScheduleDao.delete(subScheduleDTO.getSubScheduleId());
			return true;
		} catch (Exception e) {
			System.out.println("Unable to delete subschedule having id:" + subScheduleDTO.getSubScheduleId());
		}
		return false;
	}

}
