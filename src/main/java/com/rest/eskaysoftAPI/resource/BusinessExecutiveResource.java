
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

import com.rest.eskaysoftAPI.dto.BusinessExecutiveDTO;
import com.rest.eskaysoftAPI.service.BusinessExecutiveService;
import com.rest.eskaysoftAPI.util.util;

/**
 * Resource for Schedules to create/update/get/delete
 * 
 * @author Suryasree
 * @since 7th May, 2018
 *
 */

@Resource(name = "businessexecutive")
@Path("/businessexecutive")
public class BusinessExecutiveResource {

	@Autowired
	BusinessExecutiveService businessExecutiveService;

	
	@GET
	@Produces("application/json")
	public Response getAllBusinessExecutive() {
		return util.buildResponse(businessExecutiveService.getBusinessExecutive());
	}

	
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Response getAreaById(@PathParam("id") Long id) throws URISyntaxException {
		BusinessExecutiveDTO businessExecutive = businessExecutiveService.getBusinessExecutiveById(id);
		return util.buildResponse(businessExecutive);
	}

	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response createBusinessExecutive(BusinessExecutiveDTO businessExecutive) throws URISyntaxException {
		if (businessExecutive == null) {
			return Response.status(404).build();
		}
		businessExecutiveService.createBusinessExecutive(businessExecutive);
		return Response.status(200).build();
	}

	
	@PUT
	@Consumes("application/json")
	@Produces("application/json")
	public Response updateBusinessExecutive(BusinessExecutiveDTO businessExecutiveDTO) throws URISyntaxException {
		businessExecutiveDTO = businessExecutiveService.updateBusinessExecutive(businessExecutiveDTO);
		if (businessExecutiveDTO == null) {
			return Response.status(404).build();
		}
		return Response.status(200).build();
	}

	
	@DELETE
	@Path("/{id}")
	public Response deleteBusinessExecutive(@PathParam("id") Long id) throws URISyntaxException {
		BusinessExecutiveDTO businessExecutiveDTO = businessExecutiveService.getBusinessExecutiveById(id);
		if (businessExecutiveDTO != null) {
			boolean isDeleted = businessExecutiveService.deleteBusinessExecutive(businessExecutiveDTO);
			if (isDeleted) {
				return Response.status(200).build();
			}
		}
		return Response.status(404).build();
	}
}

