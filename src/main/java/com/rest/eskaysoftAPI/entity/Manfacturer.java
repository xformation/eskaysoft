package com.rest.eskaysoftAPI.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "manfacturer")
public class Manfacturer implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long manfacturerId;
	private String manfacturerName;

	public Manfacturer() {
		super();
	}

	public Manfacturer(Long manfacturerId, String manfacturerName) {
		super();
		this.manfacturerId = manfacturerId;
		this.manfacturerName = manfacturerName;
	}

	public Manfacturer(String manfacturerName) {
		super();
		this.manfacturerName = manfacturerName;
	}

	/**
	 * @return the manfacturerId
	 */
	public Long getManfacturerId() {
		return manfacturerId;
	}

	/**
	 * @param manfacturerId
	 *            the manfacturerId to set
	 */
	public void setManfacturerId(Long manfacturerId) {
		this.manfacturerId = manfacturerId;
	}

	/**
	 * @return the manfacturerName
	 */
	public String getManfacturerName() {
		return manfacturerName;
	}

	/**
	 * @param manfacturerName
	 *            the manfacturerName to set
	 */
	public void setManfacturerName(String manfacturerName) {
		this.manfacturerName = manfacturerName;
	}

}
