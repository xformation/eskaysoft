package com.rest.eskaysoftAPI.service;

import java.util.List;

import com.rest.eskaysoftAPI.dto.BankInformationDTO;

public interface BankInformationService {
	/**
	 * 
	 * @return
	 */
	List<BankInformationDTO> getBankInformation();

	/**
	 * 
	 * @param areaId
	 * @return
	 */
	BankInformationDTO getBankInformationById(Long id);

	/**
	 * 
	 * @param area
	 * @return
	 */
	boolean createBankInformation(BankInformationDTO bankinformation);

	/**
	 * 
	 * @param area
	 * @return
	 */
	BankInformationDTO updateBankInformation(BankInformationDTO bankinformation);

	/**
	 * 
	 * @param area
	 * @return
	 */
	boolean deleteBankInformation(BankInformationDTO bankinformation);

}
