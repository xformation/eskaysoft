package com.rest.eskaysoftAPI.dto;

import java.io.Serializable;
import java.util.Date;

import com.rest.eskaysoftAPI.entity.Company;

public class CompanyGroupDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2099654952913091298L;
	private Long Id;
	private Company company;
	private String companyGroup;
	private String createdBy;
	private Date createdOn;
	private String updatedBy;
	private Date updatedOn;

	public CompanyGroupDTO() {
		super();
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public String getCompanyGroup() {
		return companyGroup;
	}

	public void setCompanyGroup(String companyGroup) {
		this.companyGroup = companyGroup;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
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

	public CompanyGroupDTO(Long id, Company company, String companyGroup, String createdBy, Date createdOn,
			String updatedBy, Date updatedOn) {
		super();
		Id = id;
		this.company = company;
		this.companyGroup = companyGroup;
		this.createdBy = createdBy;
		this.createdOn = createdOn;
		this.updatedBy = updatedBy;
		this.updatedOn = updatedOn;
	}

	public CompanyGroupDTO(Company company, String companyGroup, String createdBy, Date createdOn, String updatedBy,
			Date updatedOn) {
		super();
		this.company = company;
		this.companyGroup = companyGroup;
		this.createdBy = createdBy;
		this.createdOn = createdOn;
		this.updatedBy = updatedBy;
		this.updatedOn = updatedOn;
	}

}