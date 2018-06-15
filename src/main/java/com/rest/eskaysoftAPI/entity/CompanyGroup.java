package com.rest.eskaysoftAPI.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "compnanyGroup")
public class CompanyGroup implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long compnanyGroupId;
	private Company company;
	private String companyGroup;
	private String createdBy;
	private Date createdOn;
	private String updatedBy;
	private Date updatedOn;

	public Long getId() {
		return compnanyGroupId;
	}

	public void setId(Long id) {
		compnanyGroupId = id;
	}

	public CompanyGroup() {
		super();
	}

	public Long getCompnanyGroupId() {
		return compnanyGroupId;
	}

	public void setCompnanyGroupId(Long compnanyGroupId) {
		this.compnanyGroupId = compnanyGroupId;
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

	public CompanyGroup(Long id, Company company, String companyGroup, String createdBy, Date createdOn,
			String updatedBy, Date updatedOn) {
		super();
		this.compnanyGroupId = id;
		this.company = company;
		this.companyGroup = companyGroup;
		this.createdBy = createdBy;
		this.createdOn = createdOn;
		this.updatedBy = updatedBy;
		this.updatedOn = updatedOn;
	}

	public CompanyGroup(Company company, String companyGroup, String createdBy, Date createdOn, String updatedBy,
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