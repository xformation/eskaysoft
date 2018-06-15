package com.rest.eskaysoftAPI.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.eskaysoftAPI.dao.DistrictsDao;
import com.rest.eskaysoftAPI.dto.DistrictDTO;
import com.rest.eskaysoftAPI.entity.Districts;
import com.rest.eskaysoftAPI.service.DistrictService;

@Service("districtService")
public class DistrictServiceImpl implements DistrictService {

	@Autowired
	DistrictsDao districtDao;

	@Override
	public List<DistrictDTO> getDistricts() {
		List<Districts> districts = new ArrayList<>(districtDao.findAll());
		List<DistrictDTO> districtList = null;
		if (districts != null) {
			districtList = new ArrayList<DistrictDTO>();
			for (Districts district : districts) {
				DistrictDTO districtDTO = new DistrictDTO(district.getDistrictId(), district.getDistrictName(),
						district.getState(), district.getCreatedBy(), district.getCreatedOn(), district.getUpdatedBy(),
						district.getUpdatedOn());
				districtList.add(districtDTO);
			}
		}

		return districtList;
	}

	@Override
	public DistrictDTO getDistrictsById(Long districtId) {
		Districts district = districtDao.findOne(districtId);
		if (district != null) {
			DistrictDTO districtDTO = new DistrictDTO(district.getDistrictId(), district.getDistrictName(),
					district.getState(), district.getCreatedBy(), district.getCreatedOn(), district.getUpdatedBy(),
					district.getUpdatedOn());
			return districtDTO;
		}
		return null;
	}

	@Override
	public DistrictDTO updateDistrict(DistrictDTO districtDTO) {
		Districts district = districtDao.findOne(districtDTO.getId());

		if (district != null) {
			district.setDistrictName(districtDTO.getDistrictName());
			district.setStateName(districtDTO.getState());
			district.setCreatedBy(districtDTO.getCreatedBy());
			district.setCreatedOn(districtDTO.getCreatedOn());
			district.setUpdatedBy(districtDTO.getUpdatedBy());
			district.setUpdatedOn(districtDTO.getUpdatedOn());
			district = districtDao.save(district);
			if (null != district) {
				return districtDTO;

			}

		}
		return null;
	}

	@Override
	public boolean createDistrict(DistrictDTO districtDTO) {
		try {
			Districts district = new Districts(districtDTO.getDistrictName(), districtDTO.getState(),
					districtDTO.getCreatedBy(), districtDTO.getCreatedOn(), districtDTO.getUpdatedBy(),
					districtDTO.getUpdatedOn());
			Districts savedDistrict = districtDao.save(district);
			return savedDistrict == null ? false : true;
		} catch (Exception e) {
			System.out.println("Unable to create district:" + districtDTO.getDistrictName());
		}
		return false;
	}

	@Override
	public boolean deleteDistrict(DistrictDTO districtDTO) {
		try {
			districtDao.delete(districtDTO.getId());
			return true;
		} catch (Exception e) {
			System.out.println("Unable to delete district having id:" + districtDTO.getId());
		}
		return false;
	}
}