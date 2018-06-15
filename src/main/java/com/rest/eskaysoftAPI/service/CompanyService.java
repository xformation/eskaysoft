package com.rest.eskaysoftAPI.service;

import java.util.List;

import com.rest.eskaysoftAPI.dto.CompanyDTO;

public interface CompanyService {
	/**
	 * 
	 * @return
	 */
	List<CompanyDTO> getCompanies();

	/**
	 * 
	 * @param companyId
	 * @return
	 */
	CompanyDTO getCompanyById(Long Id);

	/**
	 * 
	 * @param company
	 * @return
	 */
	boolean createCompany(CompanyDTO company);

	/**
	 * 
	 * @param company
	 * @return
	 */
	CompanyDTO updateCompany(CompanyDTO company);

	/**
	 * 
	 * @param company
	 * @return
	 */
	boolean deleteCompany(CompanyDTO company);

}
