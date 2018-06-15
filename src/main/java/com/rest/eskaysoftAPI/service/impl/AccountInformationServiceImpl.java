package com.rest.eskaysoftAPI.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.eskaysoftAPI.dao.AccountInformationDao;
import com.rest.eskaysoftAPI.dto.AccountInformationDTO;
import com.rest.eskaysoftAPI.entity.AccountInformation;
import com.rest.eskaysoftAPI.service.AccountInformationService;

@Service("accountInformationService")
public class AccountInformationServiceImpl implements AccountInformationService {

	@Autowired
	AccountInformationDao accountInformationDao;

	@Override
	public List<AccountInformationDTO> getaccountInformation() {
		List<AccountInformation> accountInformation = new ArrayList<>(accountInformationDao.findAll());
		List<AccountInformationDTO> accountInformationList = null;
		if (accountInformation != null) {
			accountInformationList = new ArrayList<AccountInformationDTO>();
			for (AccountInformation information : accountInformation) {
				AccountInformationDTO accountInformationDTO = new AccountInformationDTO(information.getId(),
						information.getAccountName(), information.getSchedule(), information.getAddress1(),
						information.getAddress2(), information.getTown(), information.getPinDistrict(),
						information.getState(), information.getAreaName(), information.getPhone(),
						information.getMobile(), information.getEmail(), information.getShortName(),
						information.getLicNo1(), information.getLicNo2(), information.getLicExpiry(),
						information.getRetLicNo1(), information.getRetLicNo2(), information.getRetExpiry(),
						information.getFoodLicNo(), information.getOtherLicense(), information.getOtherLicenseExpiry(),
						information.getGstType(), information.getGstIN(), information.getNatureOfGST(),
						information.getUinNo(), information.getSaleType(), information.getCustomerType(),
						information.getCreditLimit(), information.getDueDays(), information.getContactPerson(),
						information.getHsnCode(), information.getSacCode(), information.getRateOfTax(),
						information.getOpeningBalance(), information.getOpeningType(), information.getSpecialRAemarks(),
						information.getCreatedBy(), information.getCreatedOn(), information.getUpdatedBy(),
						information.getUpdatedOn());

				accountInformationList.add(accountInformationDTO);
			}
		}
		return accountInformationList;
	}

	@Override
	public AccountInformationDTO getaccountInformationById(Long id) {
		AccountInformation accountInformation = accountInformationDao.findOne(id);
		if (accountInformation != null) {
			AccountInformationDTO accountInformationDTO = new AccountInformationDTO(accountInformation.getId(),
					accountInformation.getAccountName(), accountInformation.getSchedule(),
					accountInformation.getAddress1(), accountInformation.getAddress2(), accountInformation.getTown(),
					accountInformation.getPinDistrict(), accountInformation.getState(),
					accountInformation.getAreaName(), accountInformation.getPhone(), accountInformation.getMobile(),
					accountInformation.getEmail(), accountInformation.getShortName(), accountInformation.getLicNo1(),
					accountInformation.getLicNo2(), accountInformation.getLicExpiry(),
					accountInformation.getRetLicNo1(), accountInformation.getRetLicNo2(),
					accountInformation.getRetExpiry(), accountInformation.getFoodLicNo(),
					accountInformation.getOtherLicense(), accountInformation.getOtherLicenseExpiry(),
					accountInformation.getGstType(), accountInformation.getGstIN(), accountInformation.getNatureOfGST(),
					accountInformation.getUinNo(), accountInformation.getSaleType(),
					accountInformation.getCustomerType(), accountInformation.getCreditLimit(),
					accountInformation.getDueDays(), accountInformation.getContactPerson(),
					accountInformation.getHsnCode(), accountInformation.getSacCode(), accountInformation.getRateOfTax(),
					accountInformation.getOpeningBalance(), accountInformation.getOpeningType(),
					accountInformation.getSpecialRAemarks(), accountInformation.getCreatedBy(),
					accountInformation.getCreatedOn(), accountInformation.getUpdatedBy(),
					accountInformation.getUpdatedOn());
			return accountInformationDTO;
		}
		return null;
	}
}
