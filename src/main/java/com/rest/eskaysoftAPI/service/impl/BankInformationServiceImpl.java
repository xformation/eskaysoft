package com.rest.eskaysoftAPI.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.eskaysoftAPI.dao.BankInformationDao;
import com.rest.eskaysoftAPI.dto.BankInformationDTO;
import com.rest.eskaysoftAPI.entity.BankInformation;
import com.rest.eskaysoftAPI.service.BankInformationService;

@Service("bankinformationService")
public class BankInformationServiceImpl implements BankInformationService {

	@Autowired
	BankInformationDao bankinformationDao;

	@Override
	public List<BankInformationDTO> getBankInformation() {
		List<BankInformation> bankinformation = new ArrayList<>(bankinformationDao.findAll());
		List<BankInformationDTO> bankinformationList = null;
		if (bankinformation != null) {
			bankinformationList = new ArrayList<BankInformationDTO>();
			for (BankInformation bankInformation : bankinformation) {
				BankInformationDTO bankinformationDTO = new BankInformationDTO(bankInformation.getId(),
						bankInformation.getName(), bankInformation.getAddress(), bankInformation.getCreatedBy(),
						bankInformation.getCreatedOn(), bankInformation.getUpdatedBy(), bankInformation.getUpdatedOn());
				bankinformationList.add(bankinformationDTO);
			}
		}
		return bankinformationList;
	}

	@Override
	public BankInformationDTO updateBankInformation(BankInformationDTO bankinformationDTO) {
		BankInformation bankinformation = bankinformationDao.findOne(bankinformationDTO.getId());
		if (bankinformation != null) {
			bankinformation.setName(bankinformationDTO.getName());
			bankinformation.setAddress(bankinformationDTO.getAddress());
			bankinformation.setCreatedBy(bankinformationDTO.getCreatedBy());
			bankinformation.setCreatedOn(bankinformationDTO.getCreatedOn());
			bankinformation.setUpdatedBy(bankinformationDTO.getUpdatedBy());
			bankinformation.setUpdatedOn(bankinformationDTO.getUpdatedOn());

			bankinformation = bankinformationDao.save(bankinformation);
			if (null != bankinformation) {
				return bankinformationDTO;
			}
		}
		return null;
	}

	@Override
	public boolean createBankInformation(BankInformationDTO bankinformationDTO) {
		try {
			BankInformation bankinformation = new BankInformation(bankinformationDTO.getName(),
					bankinformationDTO.getAddress(), bankinformationDTO.getCreatedBy(),
					bankinformationDTO.getCreatedOn(), bankinformationDTO.getUpdatedBy(),
					bankinformationDTO.getUpdatedOn());
			BankInformation savedBankInformation = bankinformationDao.save(bankinformation);
			return savedBankInformation == null ? false : true;
		} catch (Exception e) {
			System.out.println("Unable to create bankinformation:" + bankinformationDTO.getName());
		}
		return false;
	}

	@Override
	public boolean deleteBankInformation(BankInformationDTO bankinformationDTO) {
		try {
			bankinformationDao.delete(bankinformationDTO.getId());
			return true;
		} catch (Exception e) {
			System.out.println("Unable to delete bankinformation having id:" + bankinformationDTO.getId());
		}
		return false;
	}

	@Override
	public BankInformationDTO getBankInformationById(Long id) {
		BankInformation bankinformation = bankinformationDao.findOne(id);
		if (bankinformation != null) {
			BankInformationDTO bankinformationDTO = new BankInformationDTO(bankinformation.getId(),
					bankinformation.getName(), bankinformation.getAddress(), bankinformation.getCreatedBy(),
					bankinformation.getCreatedOn(), bankinformation.getUpdatedBy(), bankinformation.getUpdatedOn());
			return bankinformationDTO;
		}
		return null;
	}

}