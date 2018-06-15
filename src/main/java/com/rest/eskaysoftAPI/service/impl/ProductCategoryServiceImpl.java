package com.rest.eskaysoftAPI.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.eskaysoftAPI.dao.ProductCategoryDao;
import com.rest.eskaysoftAPI.dto.ProductCategoryDTO;
import com.rest.eskaysoftAPI.entity.ProductCategory;
import com.rest.eskaysoftAPI.service.ProductCategoryService;

@Service("productCategoryService")
public class ProductCategoryServiceImpl implements ProductCategoryService {

	@Autowired
	ProductCategoryDao productCategoryDao;

	@Override
	public List<ProductCategoryDTO> getProductCategory() {
		List<ProductCategory> productcategory = new ArrayList<>(productCategoryDao.findAll());
		List<ProductCategoryDTO> productcategoryList = null;
		if (productcategory != null) {
			productcategoryList = new ArrayList<ProductCategoryDTO>();
			for (ProductCategory productcategories : productcategory) {
				ProductCategoryDTO productcategoryDTO = new ProductCategoryDTO(productcategories.getProductCategoryId(),
						productcategories.getProductCategoryName());
				productcategoryList.add(productcategoryDTO);
			}
		}
		return productcategoryList;
	}

	@Override
	public ProductCategoryDTO updateProductCategory(ProductCategoryDTO productcategoryDTO) {
		ProductCategory productcategory = productCategoryDao.findOne(productcategoryDTO.getProductCategoryId());
		if (productcategory != null) {
			productcategory.setProductCategoryName(productcategoryDTO.getProductCategoryName());
			productcategory = productCategoryDao.save(productcategory);
			if (null != productcategory) {
				return productcategoryDTO;
			}
		}
		return null;
	}

	@Override
	public boolean createProductCategory(ProductCategoryDTO productcategoryDTO) {
		try {
			ProductCategory productcategory = new ProductCategory(productcategoryDTO.getProductCategoryName());
			ProductCategory savedProductCategory = productCategoryDao.save(productcategory);
			return savedProductCategory == null ? false : true;
		} catch (Exception e) {
			System.out.println("Unable to create product category:" + productcategoryDTO.getProductCategoryName());
		}
		return false;
	}

	@Override
	public boolean deleteProductCategory(ProductCategoryDTO productcategoryDTO) {
		try {
			productCategoryDao.delete(productcategoryDTO.getProductCategoryId());
			return true;
		} catch (Exception e) {
			System.out
					.println("Unable to delete productcategory having id:" + productcategoryDTO.getProductCategoryId());
		}
		return false;
	}

	@Override
	public ProductCategoryDTO getProductCategoryById(Long productCategoryId) {
		ProductCategory productcategory = productCategoryDao.findOne(productCategoryId);
		if (productcategory != null) {
			ProductCategoryDTO productcategoryDTO = new ProductCategoryDTO(productcategory.getProductCategoryId(),
					productcategory.getProductCategoryName());
			return productcategoryDTO;
		}
		return null;
	}

}
