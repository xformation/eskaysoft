package com.rest.eskaysoftAPI.service;

import java.util.List;

import com.rest.eskaysoftAPI.dto.ProductCategoryDTO;

public interface ProductCategoryService {
	/**
	 * 
	 * @return
	 */
	List<ProductCategoryDTO> getProductCategory();

	/**
	 * 
	 * @param productCategoryId
	 * @return
	 */
	ProductCategoryDTO getProductCategoryById(Long productCategoryId);

	/**
	 * 
	 * @param productcategory
	 * @return
	 */
	boolean createProductCategory(ProductCategoryDTO productcategory);

	/**
	 * 
	 * @param productcategory
	 * @return
	 */
	ProductCategoryDTO updateProductCategory(ProductCategoryDTO productcategory);

	/**
	 * 
	 * @param productcategory
	 * @return
	 */
	boolean deleteProductCategory(ProductCategoryDTO productcategory);

}
