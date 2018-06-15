package com.rest.eskaysoftAPI.dto;

import java.io.Serializable;

public class ManfacturerDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2099654952913091298L;
	private Long ManfacturerId;
	private String ManfacturerName;
	public ManfacturerDTO() {
		super();
	}
	public ManfacturerDTO(Long manfacturerId, String manfacturerName) {
		super();
		ManfacturerId = manfacturerId;
		ManfacturerName = manfacturerName;
	}
	public ManfacturerDTO(String manfacturerName) {
		super();
		ManfacturerName = manfacturerName;
	}
	/**
	 * @return the manfacturerId
	 */
	public Long getManfacturerId() {
		return ManfacturerId;
	}
	/**
	 * @param manfacturerId the manfacturerId to set
	 */
	public void setManfacturerId(Long manfacturerId) {
		ManfacturerId = manfacturerId;
	}
	/**
	 * @return the manfacturerName
	 */
	public String getManfacturerName() {
		return ManfacturerName;
	}
	/**
	 * @param manfacturerName the manfacturerName to set
	 */
	public void setManfacturerName(String manfacturerName) {
		ManfacturerName = manfacturerName;
	}
	
}
