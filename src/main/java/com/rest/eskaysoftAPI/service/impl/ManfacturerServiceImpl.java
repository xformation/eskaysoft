package com.rest.eskaysoftAPI.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.eskaysoftAPI.dao.ManfacturerDao;
import com.rest.eskaysoftAPI.dto.ManfacturerDTO;
import com.rest.eskaysoftAPI.entity.Manfacturer;
import com.rest.eskaysoftAPI.service.ManfacturerService;

@Service("manfacturerService")
public class ManfacturerServiceImpl implements ManfacturerService {

	@Autowired
	ManfacturerDao manfacturerDao;

	@Override
	public List<ManfacturerDTO> getManfacturer() {
		List<Manfacturer> manfacturer = new ArrayList<>(manfacturerDao.findAll());
		List<ManfacturerDTO> manfacturerList = null;
		if (manfacturer != null) {
			manfacturerList = new ArrayList<ManfacturerDTO>();
			for (Manfacturer manfacturers : manfacturer) {
				ManfacturerDTO manfacturerDTO = new ManfacturerDTO(manfacturers.getManfacturerId(), manfacturers.getManfacturerName());
				manfacturerList.add(manfacturerDTO);
			}
		}
		return manfacturerList;
	}

	@Override
	public ManfacturerDTO updateManfacturer(ManfacturerDTO manfacturerDTO) {
		Manfacturer manfacturer = manfacturerDao.findOne(manfacturerDTO.getManfacturerId());
		if (manfacturer != null) {
			manfacturer.setManfacturerName(manfacturerDTO.getManfacturerName());
			manfacturer = manfacturerDao.save(manfacturer);
			if (null != manfacturer) {
				return manfacturerDTO;
			}
		}
		return null;
	}

	@Override
	public boolean createManfacturer(ManfacturerDTO manfacturerDTO) {
		try {
			Manfacturer manfacturer = new Manfacturer(manfacturerDTO.getManfacturerName());
			Manfacturer savedManfacturer = manfacturerDao.save(manfacturer);
			return savedManfacturer == null ? false : true;
		} catch (Exception e) {
			System.out.println("Unable to create manfacturer:" + manfacturerDTO.getManfacturerName());
		}
		return false;
	}

	@Override
	public boolean deleteManfacturer(ManfacturerDTO manfacturerDTO) {
		try {
			manfacturerDao.delete(manfacturerDTO.getManfacturerId());
			return true;
		} catch (Exception e) {
			System.out.println("Unable to delete manfacturer having id:" + manfacturerDTO.getManfacturerId());
		}
		return false;
	}

	@Override
	public ManfacturerDTO getManfacturerById(Long manfacturerId) {
		Manfacturer manfacturer = manfacturerDao.findOne(manfacturerId);
		if (manfacturer != null) {
			ManfacturerDTO manfacturerDTO = new ManfacturerDTO(manfacturer.getManfacturerId(), manfacturer.getManfacturerName());
			return manfacturerDTO;
		}
		return null;
	}

}