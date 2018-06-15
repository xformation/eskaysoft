package com.rest.eskaysoftAPI.service;

import java.util.List;

import com.rest.eskaysoftAPI.dto.AccountOpeningsDTO;

public interface AccountOpeningsService {

	List<AccountOpeningsDTO> getaccountOpenings();

	AccountOpeningsDTO getaccountOpeningsById(Long id);

	boolean createAccountOpenings(AccountOpeningsDTO accountOpenings);

	AccountOpeningsDTO updateAccountOpenings(AccountOpeningsDTO accountOpenings);

	boolean deleteAccountOpenings(AccountOpeningsDTO accountOpenings);

}
