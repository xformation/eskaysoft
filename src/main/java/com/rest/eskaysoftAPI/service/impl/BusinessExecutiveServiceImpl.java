package com.rest.eskaysoftAPI.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.eskaysoftAPI.dao.BusinessExecutivesDao;
import com.rest.eskaysoftAPI.dto.BusinessExecutiveDTO;
import com.rest.eskaysoftAPI.entity.BusinessExecutive;
import com.rest.eskaysoftAPI.service.BusinessExecutiveService;

@Service("businessExecutiveService")
public class BusinessExecutiveServiceImpl implements BusinessExecutiveService {

	@Autowired
	BusinessExecutivesDao businessExecutiveDao;

	@Override
	public List<BusinessExecutiveDTO> getBusinessExecutive() {
		List<BusinessExecutive> businessExecutive = new ArrayList<>(businessExecutiveDao.findAll());
		List<BusinessExecutiveDTO> businessExecutiveList = null;
		if (businessExecutive != null) {
			businessExecutiveList = new ArrayList<BusinessExecutiveDTO>();
			for (BusinessExecutive businessExecutives : businessExecutive) {
				BusinessExecutiveDTO businessExecutiveDTO = new BusinessExecutiveDTO(businessExecutives.getId(),
						businessExecutives.getAddress(), businessExecutives.getName(), businessExecutives.getTown(),
						businessExecutives.getMobile(), businessExecutives.getCreatedBy(),
						businessExecutives.getCreatedOn(), businessExecutives.getUpdatedBy(),
						businessExecutives.getUpdatedOn());
				businessExecutiveList.add(businessExecutiveDTO);
			}
		}
		return businessExecutiveList;
	}

	@Override
	public BusinessExecutiveDTO updateBusinessExecutive(BusinessExecutiveDTO businessExecutiveDTO) {
		BusinessExecutive businessExecutive = businessExecutiveDao.findOne(businessExecutiveDTO.getId());
		if (businessExecutive != null) {
			businessExecutive.setName(businessExecutiveDTO.getName());
			businessExecutive.setAddress(businessExecutiveDTO.getAddress());
			businessExecutive.setTown(businessExecutiveDTO.getTown());
			businessExecutive.setMobile(businessExecutiveDTO.getMobile());
			businessExecutive.setCreatedBy(businessExecutiveDTO.getCreatedBy());
			businessExecutive.setCreatedOn(businessExecutiveDTO.getCreatedOn());
			businessExecutive.setUpdatedBy(businessExecutiveDTO.getUpdatedBy());
			businessExecutive.setUpdatedOn(businessExecutiveDTO.getUpdatedOn());

			businessExecutive = businessExecutiveDao.save(businessExecutive);
			if (null != businessExecutive) {
				return businessExecutiveDTO;
			}
		}
		return null;
	}

	@Override
	public boolean createBusinessExecutive(BusinessExecutiveDTO businessExecutiveDTO) {
		try {
			BusinessExecutive businessExecutive = new BusinessExecutive(businessExecutiveDTO.getName(),
					businessExecutiveDTO.getAddress(), businessExecutiveDTO.getTown(), businessExecutiveDTO.getMobile(),
					businessExecutiveDTO.getCreatedBy(), businessExecutiveDTO.getCreatedOn(),
					businessExecutiveDTO.getUpdatedBy(), businessExecutiveDTO.getUpdatedOn());
			BusinessExecutive savedBusinessExecutive = businessExecutiveDao.save(businessExecutive);
			return savedBusinessExecutive == null ? false : true;
		} catch (Exception e) {
			System.out.println("Unable to create business executive:" + businessExecutiveDTO.getName());
		}
		return false;
	}

	@Override
	public boolean deleteBusinessExecutive(BusinessExecutiveDTO businessExecutiveDTO) {
		try {
			businessExecutiveDao.delete(businessExecutiveDTO.getId());
			return true;
		} catch (Exception e) {
			System.out.println("Unable to delete business executive having id:" + businessExecutiveDTO.getId());
		}
		return false;
	}

	@Override
	public BusinessExecutiveDTO getBusinessExecutiveById(Long id) {
		BusinessExecutive businessExecutive = businessExecutiveDao.findOne(id);
		if (businessExecutive != null) {
			BusinessExecutiveDTO businessExecutiveDTO = new BusinessExecutiveDTO(businessExecutive.getId(),
					businessExecutive.getName(), businessExecutive.getAddress(), businessExecutive.getTown(),
					businessExecutive.getMobile(), businessExecutive.getCreatedBy(), businessExecutive.getCreatedOn(),
					businessExecutive.getUpdatedBy(), businessExecutive.getUpdatedOn());
			return businessExecutiveDTO;
		}
		return null;
	}

}