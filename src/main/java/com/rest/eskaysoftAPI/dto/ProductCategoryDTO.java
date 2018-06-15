package com.rest.eskaysoftAPI.dto;

import java.io.Serializable;

public class ProductCategoryDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2099654952913091298L;
	private Long ProductCategoryId;
	private String ProductCategoryName;

	public ProductCategoryDTO() {
		super();
	}

	public ProductCategoryDTO(Long productCategoryId, String productCategoryName) {
		super();
		ProductCategoryId = productCategoryId;
		ProductCategoryName = productCategoryName;
	}

	public ProductCategoryDTO(String productCategoryName) {
		super();
		ProductCategoryName = productCategoryName;
	}

	/**
	 * @return the productCategoryId
	 */
	public Long getProductCategoryId() {
		return ProductCategoryId;
	}

	/**
	 * @param productCategoryId
	 *            the productCategoryId to set
	 */
	public void setProductCategoryId(Long productCategoryId) {
		ProductCategoryId = productCategoryId;
	}

	/**
	 * @return the productCategoryName
	 */
	public String getProductCategoryName() {
		return ProductCategoryName;
	}

	/**
	 * @param productCategoryName
	 *            the productCategoryName to set
	 */
	public void setProductCategoryName(String productCategoryName) {
		ProductCategoryName = productCategoryName;
	}

}