package com.rest.eskaysoftAPI.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "productgroup")
public class ProductGroup implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productGroupId;
	private String productGroupName;

	public ProductGroup() {
		super();
	}

	public ProductGroup(Long productGroupId, String productGroupName) {
		super();
		this.productGroupId = productGroupId;
		this.productGroupName = productGroupName;
	}

	public ProductGroup(String productGroupName) {
		super();
		this.productGroupName = productGroupName;
	}

	/**
	 * @return the productGroupId
	 */
	public Long getProductGroupId() {
		return productGroupId;
	}

	/**
	 * @param productGroupId
	 *            the productGroupId to set
	 */
	public void setProductGroupId(Long productGroupId) {
		this.productGroupId = productGroupId;
	}

	/**
	 * @return the productGroupName
	 */
	public String getProductGroupName() {
		return productGroupName;
	}

	/**
	 * @param productGroupName
	 *            the productGroupName to set
	 */
	public void setProductGroupName(String productGroupName) {
		this.productGroupName = productGroupName;
	}

}
