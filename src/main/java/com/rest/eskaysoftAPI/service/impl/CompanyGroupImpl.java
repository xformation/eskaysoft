package com.rest.eskaysoftAPI.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.eskaysoftAPI.dao.CompanyGroupDao;
import com.rest.eskaysoftAPI.dto.CompanyGroupDTO;
import com.rest.eskaysoftAPI.entity.CompanyGroup;
import com.rest.eskaysoftAPI.service.CompanyGroupService;

@Service("companyGroupService")
public class CompanyGroupImpl implements CompanyGroupService {

	@Autowired
	CompanyGroupDao companyGroupDao;

	@Override
	public List<CompanyGroupDTO> getCompaniesGroup() {
		List<CompanyGroup> companiesGroup = new ArrayList<>(companyGroupDao.findAll());
		List<CompanyGroupDTO> companiesGroupList = null;
		if (companiesGroup != null) {
			companiesGroupList = new ArrayList<CompanyGroupDTO>();
			for (CompanyGroup comp : companiesGroup) {
				CompanyGroupDTO companiesGroupDTO = new CompanyGroupDTO(comp.getId(), comp.getCompany(),
						comp.getCompanyGroup(), comp.getCreatedBy(), comp.getCreatedOn(), comp.getUpdatedBy(),
						comp.getUpdatedOn());
				companiesGroupList.add(companiesGroupDTO);
			}
		}
		return companiesGroupList;
	}

	@Override
	public CompanyGroupDTO updateCompanyGroup(CompanyGroupDTO companiesGroupDTO) {
		CompanyGroup companiesGroup = companyGroupDao.findOne(companiesGroupDTO.getId());
		if (companiesGroup != null) {
			companiesGroup.setId(companiesGroupDTO.getId());
			companiesGroup.setCompany(companiesGroupDTO.getCompany());
			companiesGroup.setCompanyGroup(companiesGroupDTO.getCompanyGroup());
			companiesGroup = companyGroupDao.save(companiesGroup);
			companiesGroup.setCreatedBy(companiesGroupDTO.getCreatedBy());
			companiesGroup.setCreatedOn(companiesGroupDTO.getCreatedOn());
			companiesGroup.setUpdatedBy(companiesGroupDTO.getUpdatedBy());
			companiesGroup.setUpdatedOn(companiesGroupDTO.getUpdatedOn());

			if (null != companiesGroup) {
				return companiesGroupDTO;
			}
		}
		return null;
	}

	@Override
	public boolean createCompanyGroup(CompanyGroupDTO companiesGroupDTO) {
		try {
			CompanyGroup companiesGroup = new CompanyGroup(companiesGroupDTO.getId(), companiesGroupDTO.getCompany(),
					companiesGroupDTO.getCompanyGroup(), companiesGroupDTO.getCreatedBy(),
					companiesGroupDTO.getCreatedOn(), companiesGroupDTO.getUpdatedBy(),
					companiesGroupDTO.getUpdatedOn());
			CompanyGroup savedCompanyGroup = companyGroupDao.save(companiesGroup);
			return savedCompanyGroup == null ? false : true;
		} catch (Exception e) {
			System.out.println("Unable to create companiesGroup:" + companiesGroupDTO.getCompanyGroup());
		}
		return false;
	}

	@Override
	public boolean deleteCompanyGroup(CompanyGroupDTO companiesGroupDTO) {
		try {
			companyGroupDao.delete(companiesGroupDTO.getId());
			return true;
		} catch (Exception e) {
			System.out.println("Unable to delete companiesGroup having id:" + companiesGroupDTO.getId());
		}
		return false;
	}

	@Override
	public CompanyGroupDTO getCompanyGroupDTOById(Long id) {
		CompanyGroup companiesGroup = companyGroupDao.findOne(id);
		if (companiesGroup != null) {
			CompanyGroupDTO companiesGroupDTO = new CompanyGroupDTO(companiesGroup.getId(), companiesGroup.getCompany(),
					companiesGroup.getCompanyGroup(), companiesGroup.getCreatedBy(), companiesGroup.getCreatedOn(),
					companiesGroup.getUpdatedBy(), companiesGroup.getUpdatedOn());
			return companiesGroupDTO;
		}
		return null;
	}

}
