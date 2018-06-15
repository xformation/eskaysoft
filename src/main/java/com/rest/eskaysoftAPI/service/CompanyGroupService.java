package com.rest.eskaysoftAPI.service;

import java.util.List;

import com.rest.eskaysoftAPI.dto.CompanyGroupDTO;

public interface CompanyGroupService {
	/**
	 * 
	 * @return
	 */
	List<CompanyGroupDTO> getCompaniesGroup();

	/**
	 * 
	 * @param companyId
	 * @return
	 */
	CompanyGroupDTO getCompanyGroupDTOById(Long Id);

	/**
	 * 
	 * @param CompaniesGroup
	 * @return
	 */
	boolean createCompanyGroup(CompanyGroupDTO companyGroup);

	/**
	 * 
	 * @param CompaniesGroup
	 * @return
	 */
	CompanyGroupDTO updateCompanyGroup(CompanyGroupDTO companyGroup);

	/**
	 * 
	 * @param CompaniesGroup
	 * @return
	 */
	boolean deleteCompanyGroup(CompanyGroupDTO companyGroup);



	

}
