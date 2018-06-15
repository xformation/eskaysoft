package com.rest.eskaysoftAPI.resource;

import java.net.URISyntaxException;

import javax.annotation.Resource;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import com.rest.eskaysoftAPI.dto.CustomerWiseDiscountsDTO;
import com.rest.eskaysoftAPI.service.CustomerWiseDiscountsService;
import com.rest.eskaysoftAPI.util.util;

@Resource(name = "customerWiseDiscounts")
@Path("/customerWiseDiscounts")
public class CustomerWiseDiscountsResource {

	@Autowired
	CustomerWiseDiscountsService customerWiseDiscountsService;

	@GET
	@Produces("application/json")
	public Response getcustomerWiseDiscounts() {
		return util.buildResponse(customerWiseDiscountsService.getcustomerWiseDiscounts());
	}

	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Response getCustomerWiseDiscountsById(@PathParam("id") Long id) throws URISyntaxException {
		CustomerWiseDiscountsDTO customerWiseDiscounts = customerWiseDiscountsService.getCustomerWiseDiscountsById(id);
		return util.buildResponse(customerWiseDiscounts);
	}

	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response createCustomerWiseDiscounts(CustomerWiseDiscountsDTO customerWiseDiscounts)
			throws URISyntaxException {
		if (customerWiseDiscounts == null) {
			return Response.status(404).build();
		}
		customerWiseDiscountsService.createCustomerWiseDiscounts(customerWiseDiscounts);
		return Response.status(200).build();
	}

	@PUT
	@Consumes("application/json")
	@Produces("application/json")
	public Response updateCustomerWiseDiscounts(CustomerWiseDiscountsDTO customerWiseDiscountsDTO)
			throws URISyntaxException {
		customerWiseDiscountsDTO = customerWiseDiscountsService.updateCustomerWiseDiscounts(customerWiseDiscountsDTO);
		if (customerWiseDiscountsDTO == null) {
			return Response.status(404).build();
		}
		return Response.status(200).build();
	}

	@DELETE
	@Path("/{id}")
	public Response deleteCustomerWiseDiscountsDTO(@PathParam("id") Long id) throws URISyntaxException {
		CustomerWiseDiscountsDTO customerWiseDiscountsDTO = customerWiseDiscountsService
				.getCustomerWiseDiscountsById(id);
		if (customerWiseDiscountsDTO != null) {
			boolean isDeleted = customerWiseDiscountsService.deleteCustomerWiseDiscounts(customerWiseDiscountsDTO);
			if (isDeleted) {
				return Response.status(200).build();
			}
		}
		return Response.status(404).build();
	}
}
