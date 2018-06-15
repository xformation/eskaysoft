package com.rest.eskaysoftAPI.entity;

import java.util.List;

import com.rest.eskaysoftAPI.dto.CustomerWiseDiscountsDTO;

public class CustomerWiseDiscountsEntity {
	private List<CustomerWiseDiscountsDTO> customerWiseDiscountsDTO;

	public List<CustomerWiseDiscountsDTO> getCustomerWiseDiscountsDTO() {
		return customerWiseDiscountsDTO;
	}

	public void setCustomerWiseDiscountsDTO(List<CustomerWiseDiscountsDTO> customerWiseDiscountsDTO) {
		this.customerWiseDiscountsDTO = customerWiseDiscountsDTO;
	}
}
