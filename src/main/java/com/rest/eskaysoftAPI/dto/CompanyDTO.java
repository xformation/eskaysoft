package com.rest.eskaysoftAPI.dto;

import java.io.Serializable;
import java.util.Date;

public class CompanyDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2099654952913091298L;
	private Long id;
	private String companyCode;
	private String companyGroup;
	private String companyStatus;
	private String invGenType;
	private String invPrefix;
	private String companyType;
	private String createdBy;
	private Date createdOn;
	private String updatedBy;
	private Date updatedOn;

	public CompanyDTO() {
		super();
	}

	public CompanyDTO(Long id, String companyCode, String companyGroup, String companyStatus, String invGenType,
			String invPrefix, String companyType, String createdBy, Date createdOn, String updatedBy, Date updatedOn) {
		super();
		this.id = id;
		this.companyCode = companyCode;
		this.companyGroup = companyGroup;
		this.companyStatus = companyStatus;
		this.invGenType = invGenType;
		this.invPrefix = invPrefix;
		this.companyType = companyType;
		this.createdBy = createdBy;
		this.createdOn = createdOn;
		this.updatedBy = updatedBy;
		this.updatedOn = updatedOn;
	}

	public CompanyDTO(String companyCode, String companyGroup, String companyStatus, String invGenType,
			String invPrefix, String companyType, String createdBy, Date createdOn, String updatedBy, Date updatedOn) {
		super();
		this.companyCode = companyCode;
		this.companyGroup = companyGroup;
		this.companyStatus = companyStatus;
		this.invGenType = invGenType;
		this.invPrefix = invPrefix;
		this.companyType = companyType;
		this.createdBy = createdBy;
		this.createdOn = createdOn;
		this.updatedBy = updatedBy;
		this.updatedOn = updatedOn;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getCompanyGroup() {
		return companyGroup;
	}

	public void setCompanyGroup(String companyGroup) {
		this.companyGroup = companyGroup;
	}

	public String getCompanyStatus() {
		return companyStatus;
	}

	public void setCompanyStatus(String companyStatus) {
		this.companyStatus = companyStatus;
	}

	public String getInvGenType() {
		return invGenType;
	}

	public void setInvGenType(String invGenType) {
		this.invGenType = invGenType;
	}

	public String getInvPrefix() {
		return invPrefix;
	}

	public void setInvPrefix(String invPrefix) {
		this.invPrefix = invPrefix;
	}

	public String getCompanyType() {
		return companyType;
	}

	public void setCompanyType(String companyType) {
		this.companyType = companyType;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

}