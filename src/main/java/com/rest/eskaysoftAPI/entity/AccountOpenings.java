package com.rest.eskaysoftAPI.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "accountOpenings")
public class AccountOpenings implements Serializable {
	private static final long serialVersionUID = 2099654952913091298L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long accountOpeningsId;
	private String code;
	private String accountName;
	private String town;
	private String openigs;
	private String type;
	private String createdBy;
	private Date createdOn;
	private String updatedBy;
	private Date updatedOn;

	public Long getAccountOpeningsId() {
		return accountOpeningsId;
	}

	public void setAccountOpeningsId(Long accountOpeningsId) {
		this.accountOpeningsId = accountOpeningsId;
	}

	public Long getId() {
		return accountOpeningsId;
	}

	public void setId(Long id) {
		accountOpeningsId = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getOpenigs() {
		return openigs;
	}

	public void setOpenigs(String openigs) {
		this.openigs = openigs;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public AccountOpenings(Long id, String code, String accountName, String town, String openigs, String type,
			String createdBy, Date createdOn, String updatedBy, Date updatedOn) {
		super();
		accountOpeningsId = id;
		this.code = code;
		this.accountName = accountName;
		this.town = town;
		this.openigs = openigs;
		this.type = type;
		this.createdBy = createdBy;
		this.createdOn = createdOn;
		this.updatedBy = updatedBy;
		this.updatedOn = updatedOn;
	}

	public AccountOpenings(String code, String accountName, String town, String openigs, String type, String createdBy,
			Date createdOn, String updatedBy, Date updatedOn) {
		super();
		this.code = code;
		this.accountName = accountName;
		this.town = town;
		this.openigs = openigs;
		this.type = type;
		this.createdBy = createdBy;
		this.createdOn = createdOn;
		this.updatedBy = updatedBy;
		this.updatedOn = updatedOn;
	}

	public AccountOpenings() {
		super();
	}

}
