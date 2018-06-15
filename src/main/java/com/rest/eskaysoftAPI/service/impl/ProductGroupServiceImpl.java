package com.rest.eskaysoftAPI.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.eskaysoftAPI.dao.ProductGroupDao;
import com.rest.eskaysoftAPI.dto.ProductGroupDTO;
import com.rest.eskaysoftAPI.entity.ProductGroup;
import com.rest.eskaysoftAPI.service.ProductGroupService;

@Service("productGroupService")
public class ProductGroupServiceImpl implements ProductGroupService {

	@Autowired
	ProductGroupDao productGroupDao;

	@Override
	public List<ProductGroupDTO> getProductGroup() {
		List<ProductGroup> productgroup = new ArrayList<>(productGroupDao.findAll());
		List<ProductGroupDTO> productgroupList = null;
		if (productgroup != null) {
			productgroupList = new ArrayList<ProductGroupDTO>();
			for (ProductGroup productgroups : productgroup) {
				ProductGroupDTO productgroupDTO = new ProductGroupDTO(productgroups.getProductGroupId(),
						productgroups.getProductGroupName());
				productgroupList.add(productgroupDTO);
			}
		}
		return productgroupList;
	}

	@Override
	public ProductGroupDTO updateProductGroup(ProductGroupDTO productgroupDTO) {
		ProductGroup productgroup = productGroupDao.findOne(productgroupDTO.getProductGroupId());
		if (productgroup != null) {
			productgroup.setProductGroupName(productgroupDTO.getProductGroupName());
			productgroup = productGroupDao.save(productgroup);
			if (null != productgroup) {
				return productgroupDTO;
			}
		}
		return null;
	}

	@Override
	public boolean createProductGroup(ProductGroupDTO productgroupDTO) {
		try {
			ProductGroup productgroup = new ProductGroup(productgroupDTO.getProductGroupName());
			ProductGroup savedProductGroup = productGroupDao.save(productgroup);
			return savedProductGroup == null ? false : true;
		} catch (Exception e) {
			System.out.println("Unable to create product group:" + productgroupDTO.getProductGroupName());
		}
		return false;
	}

	@Override
	public boolean deleteProductGroup(ProductGroupDTO productgroupDTO) {
		try {
			productGroupDao.delete(productgroupDTO.getProductGroupId());
			return true;
		} catch (Exception e) {
			System.out.println("Unable to delete productgroup having id:" + productgroupDTO.getProductGroupId());
		}
		return false;
	}

	@Override
	public ProductGroupDTO getProductGroupById(Long productGroupId) {
		ProductGroup productgroup = productGroupDao.findOne(productGroupId);
		if (productgroup != null) {
			ProductGroupDTO productgroupDTO = new ProductGroupDTO(productgroup.getProductGroupId(),
					productgroup.getProductGroupName());
			return productgroupDTO;
		}
		return null;
	}

}
