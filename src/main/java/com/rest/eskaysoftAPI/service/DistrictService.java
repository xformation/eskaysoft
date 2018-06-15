package com.rest.eskaysoftAPI.service;

import java.util.List;

import com.rest.eskaysoftAPI.dto.DistrictDTO;

public interface DistrictService {
	/**
	 * 
	 * @return
	 */
	List<DistrictDTO> getDistricts();

	DistrictDTO getDistrictsById(Long districtId);

	/**
	 * 
	 * @param district
	 * @return
	 */
	boolean createDistrict(DistrictDTO district);

	/**
	 * 
	 * @param ditrsict
	 * @return
	 */
	DistrictDTO updateDistrict(DistrictDTO ditrsict);

	/**
	 * 
	 * @param district
	 * @return
	 */
	boolean deleteDistrict(DistrictDTO district);
}
