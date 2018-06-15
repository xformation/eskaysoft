
package com.rest.eskaysoftAPI.service;

import java.util.List;

import com.rest.eskaysoftAPI.dto.BusinessExecutiveDTO;

public interface BusinessExecutiveService {
	/**
	 * 
	 * @return
	 */
	List<BusinessExecutiveDTO> getBusinessExecutive();

	/**
	 * 
	 * @param id
	 * @return
	 */

	BusinessExecutiveDTO getBusinessExecutiveById(Long id);

	/**
	 * 
	 * @param businessExecutive
	 * @return
	 */

	boolean createBusinessExecutive(BusinessExecutiveDTO businessExecutive);

	/**
	 * 
	 * @param businessExecutive
	 * @return
	 */

	BusinessExecutiveDTO updateBusinessExecutive(BusinessExecutiveDTO businessExecutive);

	/**
	 * 
	 * @param businessExecutive
	 * @return
	 */
	boolean deleteBusinessExecutive(BusinessExecutiveDTO businessExecutive);

}
