package com.rest.eskaysoftAPI.service;

import java.util.List;

import com.rest.eskaysoftAPI.dto.CustomerWiseDiscountsDTO;

public interface CustomerWiseDiscountsService {

	/**
	 * 
	 * @return
	 */
	List<CustomerWiseDiscountsDTO> getcustomerWiseDiscounts();

	/**
	 * 
	 * @param customerWiseDiscountsId
	 * @return
	 */
	CustomerWiseDiscountsDTO getCustomerWiseDiscountsById(Long id);

	/**
	 * 
	 * @param CustomerWiseDiscounts
	 * @return
	 */
	boolean createCustomerWiseDiscounts(CustomerWiseDiscountsDTO customerWiseDiscounts);

	/**
	 * 
	 * @param CustomerWiseDiscounts
	 * @return
	 */
	CustomerWiseDiscountsDTO updateCustomerWiseDiscounts(CustomerWiseDiscountsDTO customerWiseDiscounts);

	/**
	 * 
	 * @param schedule
	 * @return
	 */
	boolean deleteCustomerWiseDiscounts(CustomerWiseDiscountsDTO customerWiseDiscounts);

}
