package com.rest.eskaysoftAPI.dto;

import java.io.Serializable;
import java.util.Date;

public class CustomerWiseDiscountsDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long Id;
	private String customer;
	private String companyOption;
	private String discount;
	private String companyDiscription;
	private String disc;
	private String createdBy;
	private Date createdOn;
	private String updatedBy;
	private Date updatedOn;

	public CustomerWiseDiscountsDTO(Long id, String customer, String companyOption, String discount,
			String companyDiscription, String disc, String createdBy, Date createdOn, String updatedBy,
			Date updatedOn) {
		super();
		Id = id;
		this.customer = customer;
		this.companyOption = companyOption;
		this.discount = discount;
		this.companyDiscription = companyDiscription;
		this.disc = disc;
		this.createdBy = createdBy;
		this.createdOn = createdOn;
		this.updatedBy = updatedBy;
		this.updatedOn = updatedOn;
	}

	public CustomerWiseDiscountsDTO(String customer, String companyOption, String discount, String companyDiscription,
			String disc, String createdBy, Date createdOn, String updatedBy, Date updatedOn) {
		super();
		this.customer = customer;
		this.companyOption = companyOption;
		this.discount = discount;
		this.companyDiscription = companyDiscription;
		this.disc = disc;
		this.createdBy = createdBy;
		this.createdOn = createdOn;
		this.updatedBy = updatedBy;
		this.updatedOn = updatedOn;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getCompanyOption() {
		return companyOption;
	}

	public void setCompanyOption(String companyOption) {
		this.companyOption = companyOption;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public String getCompanyDiscription() {
		return companyDiscription;
	}

	public void setCompanyDiscription(String companyDiscription) {
		this.companyDiscription = companyDiscription;
	}

	public String getDisc() {
		return disc;
	}

	public void setDisc(String disc) {
		this.disc = disc;
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

	public CustomerWiseDiscountsDTO() {
		super();
	}

}
