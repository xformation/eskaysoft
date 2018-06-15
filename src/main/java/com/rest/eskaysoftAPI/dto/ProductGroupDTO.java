package com.rest.eskaysoftAPI.dto;

import java.io.Serializable;

public class ProductGroupDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2099654952913091298L;
	private Long ProductGroupId;
	private String ProductGroupName;

	public ProductGroupDTO() {
		super();
	}

	public ProductGroupDTO(Long productGroupId, String productGroupName) {
		super();
		ProductGroupId = productGroupId;
		ProductGroupName = productGroupName;
	}

	public ProductGroupDTO(String productGroupName) {
		super();
		ProductGroupName = productGroupName;
	}

	/**
	 * @return the productGroupId
	 */
	public Long getProductGroupId() {
		return ProductGroupId;
	}

	/**
	 * @param productGroupId
	 *            the productGroupId to set
	 */
	public void setProductGroupId(Long productGroupId) {
		ProductGroupId = productGroupId;
	}

	/**
	 * @return the productGroupName
	 */
	public String getProductGroupName() {
		return ProductGroupName;
	}

	/**
	 * @param productGroupName
	 *            the productGroupName to set
	 */
	public void setProductGroupName(String productGroupName) {
		ProductGroupName = productGroupName;
	}

}