package com.rest.eskaysoftAPI.service;

import java.util.List;

import com.rest.eskaysoftAPI.dto.AccountInformationDTO;

public interface AccountInformationService {
	List<AccountInformationDTO> getaccountInformation();

	AccountInformationDTO getaccountInformationById(Long id);
}
