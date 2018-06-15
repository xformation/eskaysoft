package com.rest.eskaysoftAPI.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.eskaysoftAPI.dao.CustomerWiseDiscountsDao;
import com.rest.eskaysoftAPI.dto.CustomerWiseDiscountsDTO;
import com.rest.eskaysoftAPI.entity.CustomerWiseDiscounts;
import com.rest.eskaysoftAPI.service.CustomerWiseDiscountsService;

@Service("customerWiseDiscountsService")
public class CustomerWiseDiscountsImpl implements CustomerWiseDiscountsService {
	@Autowired
	CustomerWiseDiscountsDao customerWiseDiscountsDao;

	@Override
	public List<CustomerWiseDiscountsDTO> getcustomerWiseDiscounts() {
		List<CustomerWiseDiscounts> customerWiseDiscounts = new ArrayList<>(customerWiseDiscountsDao.findAll());
		List<CustomerWiseDiscountsDTO> customerWiseDiscountsList = null;
		if (customerWiseDiscounts != null) {
			customerWiseDiscountsList = new ArrayList<CustomerWiseDiscountsDTO>();
			for (CustomerWiseDiscounts customerWise : customerWiseDiscounts) {
				CustomerWiseDiscountsDTO customerWiseDiscountsDTO = new CustomerWiseDiscountsDTO(customerWise.getId(),
						customerWise.getCustomer(), customerWise.getCompanyOption(), customerWise.getDiscount(),
						customerWise.getCompanyDiscription(), customerWise.getDisc(), customerWise.getCreatedBy(),
						customerWise.getCreatedOn(), customerWise.getUpdatedBy(), customerWise.getUpdatedOn());
				customerWiseDiscountsList.add(customerWiseDiscountsDTO);
			}
		}
		return customerWiseDiscountsList;
	}

	@Override
	public CustomerWiseDiscountsDTO getCustomerWiseDiscountsById(Long id) {
		CustomerWiseDiscounts customerWiseDiscounts = customerWiseDiscountsDao.findOne(id);
		if (customerWiseDiscounts != null) {
			CustomerWiseDiscountsDTO customerWiseDiscountsDTO = new CustomerWiseDiscountsDTO(
					customerWiseDiscounts.getCustomer(), customerWiseDiscounts.getCompanyOption(),
					customerWiseDiscounts.getDiscount(), customerWiseDiscounts.getCompanyDiscription(),
					customerWiseDiscounts.getDisc(), customerWiseDiscounts.getCreatedBy(),
					customerWiseDiscounts.getCreatedOn(), customerWiseDiscounts.getUpdatedBy(),
					customerWiseDiscounts.getUpdatedOn());

			return customerWiseDiscountsDTO;
		}
		return null;
	}

	@Override
	public CustomerWiseDiscountsDTO updateCustomerWiseDiscounts(CustomerWiseDiscountsDTO customerWiseDiscountsDTO) {
		CustomerWiseDiscounts customerWiseDiscounts = customerWiseDiscountsDao
				.findOne(customerWiseDiscountsDTO.getId());
		if (customerWiseDiscounts != null) {
			customerWiseDiscounts.setCustomer(customerWiseDiscountsDTO.getCustomer());
			customerWiseDiscounts.setCompanyOption(customerWiseDiscountsDTO.getCompanyOption());
			customerWiseDiscounts.setDiscount(customerWiseDiscountsDTO.getDiscount());
			customerWiseDiscounts.setCompanyDiscription(customerWiseDiscountsDTO.getCompanyDiscription());
			customerWiseDiscounts.setDisc(customerWiseDiscountsDTO.getDisc());
			customerWiseDiscounts.setCreatedBy(customerWiseDiscountsDTO.getCreatedBy());
			customerWiseDiscounts.setCreatedOn(customerWiseDiscountsDTO.getCreatedOn());
			customerWiseDiscounts.setUpdatedBy(customerWiseDiscountsDTO.getUpdatedBy());
			customerWiseDiscounts.setUpdatedOn(customerWiseDiscountsDTO.getUpdatedOn());

			customerWiseDiscounts = customerWiseDiscountsDao.save(customerWiseDiscounts);
			if (null != customerWiseDiscounts) {

				return customerWiseDiscountsDTO;
			}
		}
		return null;
	}

	@Override
	public boolean deleteCustomerWiseDiscounts(CustomerWiseDiscountsDTO customerWiseDiscountsDTO) {
		try {
			customerWiseDiscountsDao.delete(customerWiseDiscountsDTO.getId());
			return true;
		} catch (Exception e) {
			System.out.println("Unable to delete customerWiseDiscounts having id:" + customerWiseDiscountsDTO.getId());
		}
		return false;
	}

	@Override
	public boolean createCustomerWiseDiscounts(CustomerWiseDiscountsDTO customerWiseDiscountsDTO) {
		try {
			CustomerWiseDiscounts customerWiseDiscounts = new CustomerWiseDiscounts(
					customerWiseDiscountsDTO.getCustomer(), customerWiseDiscountsDTO.getCompanyOption(),
					customerWiseDiscountsDTO.getDiscount(), customerWiseDiscountsDTO.getCompanyDiscription(),
					customerWiseDiscountsDTO.getDisc(), customerWiseDiscountsDTO.getUpdatedBy(),
					customerWiseDiscountsDTO.getUpdatedOn(), customerWiseDiscountsDTO.getCreatedBy(),
					customerWiseDiscountsDTO.getCreatedOn());

			CustomerWiseDiscounts savedCustomerWiseDiscounts = customerWiseDiscountsDao.save(customerWiseDiscounts);
			return savedCustomerWiseDiscounts == null ? false : true;
		} catch (Exception e) {
			System.out.println("Unable to create customerWiseDiscounts:" + customerWiseDiscountsDTO.getCompanyOption());
		}
		return false;
	}

}
