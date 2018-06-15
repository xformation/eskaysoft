package com.rest.eskaysoftAPI.service;

import java.util.List;

import com.rest.eskaysoftAPI.dto.AreaDTO;

public interface AreaService {
	/**
	 * 
	 * @return
	 */
	List<AreaDTO> getArea();

	/**
	 * 
	 * @param areaId
	 * @return
	 */
	AreaDTO getAreaById(Long id);

	/**
	 * 
	 * @param area
	 * @return
	 */
	boolean createArea(AreaDTO area);

	/**
	 * 
	 * @param area
	 * @return
	 */
	AreaDTO updateArea(AreaDTO area);

	/**
	 * 
	 * @param area
	 * @return
	 */
	boolean deleteArea(AreaDTO area);

}
