package com.rest.eskaysoftAPI.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.eskaysoftAPI.dao.AreaDao;
import com.rest.eskaysoftAPI.dto.AreaDTO;
import com.rest.eskaysoftAPI.entity.Area;
import com.rest.eskaysoftAPI.service.AreaService;

@Service("areaService")
public class AreaServiceImpl implements AreaService {

	@Autowired
	AreaDao areaDao;

	@Override
	public List<AreaDTO> getArea() {
		List<Area> area = new ArrayList<>(areaDao.findAll());
		List<AreaDTO> areaList = null;
		if (area != null) {
			areaList = new ArrayList<AreaDTO>();
			for (Area areas : area) {
				AreaDTO areaDTO = new AreaDTO(areas.getId(), areas.getAreaName(), areas.getExecutiveName(),
						areas.getCreatedBy(), areas.getCreatedOn(), areas.getUpdatedBy(), areas.getUpdatedOn());
				areaList.add(areaDTO);
			}
		}
		return areaList;
	}

	@Override
	public AreaDTO updateArea(AreaDTO areaDTO) {
		Area area = areaDao.findOne(areaDTO.getId());
		if (area != null) {
			area.setAreaName(areaDTO.getAreaName());
			area.setExecutiveName(areaDTO.getExecutiveName());
			area.setCreatedBy(areaDTO.getCreatedBy());
			area.setCreatedOn(areaDTO.getCreatedOn());
			area.setUpdatedBy(areaDTO.getUpdatedBy());
			area.setUpdatedOn(areaDTO.getUpdatedOn());

			area = areaDao.save(area);
			if (null != area) {
				return areaDTO;
			}
		}
		return null;
	}

	@Override
	public boolean createArea(AreaDTO areaDTO) {
		try {
			Area area = new Area(areaDTO.getAreaName(), areaDTO.getExecutiveName(), areaDTO.getCreatedBy(),
					areaDTO.getCreatedOn(), areaDTO.getUpdatedBy(), areaDTO.getUpdatedOn());
			Area savedArea = areaDao.save(area);
			return savedArea == null ? false : true;
		} catch (Exception e) {
			System.out.println("Unable to create Area:" + areaDTO.getAreaName());
		}
		return false;
	}

	@Override
	public boolean deleteArea(AreaDTO areaDTO) {
		try {
			areaDao.delete(areaDTO.getId());
			return true;
		} catch (Exception e) {
			System.out.println("Unable to delete area having id:" + areaDTO.getId());
		}
		return false;
	}

	@Override
	public AreaDTO getAreaById(Long id) {
		Area area = areaDao.findOne(id);
		if (area != null) {
			AreaDTO areaDTO = new AreaDTO(area.getId(), area.getAreaName(), area.getExecutiveName(),
					area.getCreatedBy(), area.getCreatedOn(), area.getUpdatedBy(), area.getUpdatedOn());
			return areaDTO;
		}
		return null;
	}

}