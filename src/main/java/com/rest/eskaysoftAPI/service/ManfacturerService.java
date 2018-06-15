package com.rest.eskaysoftAPI.service;

import java.util.List;

import com.rest.eskaysoftAPI.dto.ManfacturerDTO;

public interface ManfacturerService {
	/**
	 * 
	 * @return
	 */
	List<ManfacturerDTO> getManfacturer();

	/**
	 * 
	 * @param manfacturerId
	 * @return
	 */
	ManfacturerDTO getManfacturerById(Long manfacturerId);

	/**
	 * 
	 * @param manfacturer
	 * @return
	 */
	boolean createManfacturer(ManfacturerDTO manfacturer);

	/**
	 * 
	 * @param manfacturer
	 * @return
	 */
	ManfacturerDTO updateManfacturer(ManfacturerDTO manfacturer);

	/**
	 * 
	 * @param manfacturer
	 * @return
	 */
	boolean deleteManfacturer(ManfacturerDTO manfacturer);

}
