package com.rest.eskaysoftAPI.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customerWiseDiscounts")
public class CustomerWiseDiscounts implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long customerWiseDiscountsId;
	private String customer;
	private String companyOption;
	private String discount;
	private String companyDiscription;
	private String disc;
	private String createdBy;
	private Date createdOn;
	private String updatedBy;
	private Date updatedOn;

	public Long getId() {
		return customerWiseDiscountsId;
	}

	public void setId(Long id) {
		customerWiseDiscountsId = id;
	}

	public Long getCustomerWiseDiscountsId() {
		return customerWiseDiscountsId;
	}

	public void setCustomerWiseDiscountsId(Long customerWiseDiscountsId) {
		this.customerWiseDiscountsId = customerWiseDiscountsId;
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

	public CustomerWiseDiscounts(Long id, String customer, String companyOption, String discount,
			String companyDiscription, String disc, String createdBy, Date createdOn, String updatedBy,
			Date updatedOn) {
		super();
		this.customerWiseDiscountsId = id;
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

	public CustomerWiseDiscounts(String customer, String companyOption, String discount, String companyDiscription,
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

}
