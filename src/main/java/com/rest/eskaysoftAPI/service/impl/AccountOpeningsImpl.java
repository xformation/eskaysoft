package com.rest.eskaysoftAPI.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.eskaysoftAPI.dao.AccountOpeningsDao;
import com.rest.eskaysoftAPI.dto.AccountOpeningsDTO;
import com.rest.eskaysoftAPI.entity.AccountOpenings;
import com.rest.eskaysoftAPI.service.AccountOpeningsService;

@Service("accountOpeningsService")
public class AccountOpeningsImpl implements AccountOpeningsService {

	@Autowired
	AccountOpeningsDao accountOpeningsDao;

	@Override
	public List<AccountOpeningsDTO> getaccountOpenings() {
		List<AccountOpenings> accountOpenings = new ArrayList<>(accountOpeningsDao.findAll());
		List<AccountOpeningsDTO> accountOpeningsList = null;
		if (accountOpenings != null) {
			accountOpeningsList = new ArrayList<AccountOpeningsDTO>();
			for (AccountOpenings Openings : accountOpenings) {
				AccountOpeningsDTO accountOpeningsDTO = new AccountOpeningsDTO(Openings.getId(), Openings.getCode(),
						Openings.getAccountName(), Openings.getTown(), Openings.getType(), Openings.getOpenigs(),
						Openings.getCreatedBy(), Openings.getCreatedOn(), Openings.getUpdatedBy(),
						Openings.getUpdatedOn());
				accountOpeningsList.add(accountOpeningsDTO);
			}
		}
		return accountOpeningsList;
	}

	@Override
	public AccountOpeningsDTO updateAccountOpenings(AccountOpeningsDTO accountOpeningsDTO) {
		AccountOpenings accountOpenings = accountOpeningsDao.findOne(accountOpeningsDTO.getId());
		if (accountOpenings != null) {
			accountOpenings.setCode(accountOpeningsDTO.getCode());
			accountOpenings.setAccountName(accountOpeningsDTO.getAccountName());
			accountOpenings.setOpenigs(accountOpeningsDTO.getTown());
			accountOpenings.setOpenigs(accountOpeningsDTO.getOpenigs());
			accountOpenings.setCreatedBy(accountOpeningsDTO.getCreatedBy());
			accountOpenings.setCreatedOn(accountOpeningsDTO.getCreatedOn());
			accountOpenings.setUpdatedBy(accountOpeningsDTO.getUpdatedBy());
			accountOpenings.setUpdatedOn(accountOpeningsDTO.getUpdatedOn());
			accountOpenings = accountOpeningsDao.save(accountOpenings);
			if (null != accountOpenings) {
				return accountOpeningsDTO;
			}
		}
		return null;
	}

	@Override
	public boolean createAccountOpenings(AccountOpeningsDTO accountOpeningsDTO) {
		try {
			AccountOpenings accountOpenings = new AccountOpenings(accountOpeningsDTO.getCode(),
					accountOpeningsDTO.getAccountName(), accountOpeningsDTO.getTown(), accountOpeningsDTO.getType(),
					accountOpeningsDTO.getOpenigs(), accountOpeningsDTO.getCreatedBy(),
					accountOpeningsDTO.getCreatedOn(), accountOpeningsDTO.getUpdatedBy(),
					accountOpeningsDTO.getUpdatedOn());
			AccountOpenings savedaccountOpenings = accountOpeningsDao.save(accountOpenings);
			return savedaccountOpenings == null ? false : true;
		} catch (Exception e) {
			System.out.println("Unable to create accountOpenings:" + accountOpeningsDTO.getAccountName());
		}
		return false;
	}

	@Override
	public boolean deleteAccountOpenings(AccountOpeningsDTO accountOpeningsDTO) {
		try {
			accountOpeningsDao.delete(accountOpeningsDTO.getId());
			return true;
		} catch (Exception e) {
			System.out.println("Unable to delete accountOpening having id:" + accountOpeningsDTO.getId());
		}
		return false;
	}

	@Override
	public AccountOpeningsDTO getaccountOpeningsById(Long id) {
		AccountOpenings accountOpenings = accountOpeningsDao.findOne(id);
		if (accountOpenings != null) {
			AccountOpeningsDTO accountOpeningsDTO = new AccountOpeningsDTO(accountOpenings.getId(),
					accountOpenings.getCode(), accountOpenings.getAccountName(), accountOpenings.getTown(),
					accountOpenings.getType(), accountOpenings.getOpenigs(), accountOpenings.getCreatedBy(),
					accountOpenings.getCreatedOn(), accountOpenings.getUpdatedBy(), accountOpenings.getUpdatedOn());
			return accountOpeningsDTO;
		}
		return null;
	}

}