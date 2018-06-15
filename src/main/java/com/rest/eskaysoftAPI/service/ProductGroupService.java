package com.rest.eskaysoftAPI.service;

import java.util.List;

import com.rest.eskaysoftAPI.dto.ProductGroupDTO;

public interface ProductGroupService {
	/**
	 * 
	 * @return
	 */
	List<ProductGroupDTO> getProductGroup();

	/**
	 * 
	 * @param productGroupId
	 * @return
	 */
	ProductGroupDTO getProductGroupById(Long productGroupId);

	/**
	 * 
	 * @param productgroup
	 * @return
	 */
	boolean createProductGroup(ProductGroupDTO productgroup);

	/**
	 * 
	 * @param productgroup
	 * @return
	 */
	ProductGroupDTO updateProductGroup(ProductGroupDTO productgroup);

	/**
	 * 
	 * @param productgroup
	 * @return
	 */
	boolean deleteProductGroup(ProductGroupDTO productgroup);

}
