
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

import com.rest.eskaysoftAPI.dto.CompanyGroupDTO;
import com.rest.eskaysoftAPI.service.CompanyGroupService;
import com.rest.eskaysoftAPI.util.util;
/**
 * Resource for CompanyGroup to create/update/get/delete
 * 
 * @author SuryaSree
 * @since 7th May, 2018
 *
 */
@Resource(name = "companyGroup")
@Path("/companyGroup")
public class CompnayGroupResource {

	@Autowired
	CompanyGroupService companyGroupService;

	/**
	 * Returns all companyGroupService
	 * 
	 * @return
	 */
	@GET
	@Produces("application/json")
	public Response getAllCompaniesGroup() {
		return util.buildResponse(companyGroupService.getCompaniesGroup());
	}

	/**
	 * Return the CompanyGroup details for given id
	 * 
	 * @param id
	 * @return
	 * @throws URISyntaxException
	 */
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Response getCompanyGroupById(@PathParam("id") Long id) throws URISyntaxException {
		CompanyGroupDTO companyGroup = companyGroupService.getCompanyGroupDTOById(id);
		return util.buildResponse(companyGroup);
	}

	/**
	 * Creates a companyGroup with given details
	 * 
	 * @param companyGroup
	 * @return
	 * @throws URISyntaxException
	 */
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response createCompany(CompanyGroupDTO companyGroup) throws URISyntaxException {
		if (companyGroup == null) {
			return Response.status(404).build();
		}
		companyGroupService.createCompanyGroup(companyGroup);
		return Response.status(200).build();
	}

	@PUT
	@Consumes("application/json")
	@Produces("application/json")
	public Response updateCompanyGroup(CompanyGroupDTO companyGroup) throws URISyntaxException {
		companyGroup = companyGroupService.updateCompanyGroup(companyGroup);
		if (companyGroup == null) {
			return Response.status(404).build();
		}
		return Response.status(200).build();
	}

	/**
	 * Delete the CompanyGroup
	 * 
	 * @param id
	 * @return
	 * @throws URISyntaxException
	 */
	@DELETE
	@Path("/{id}")
	public Response deleteCompanyGroup(@PathParam("id") Long id) throws URISyntaxException {
		CompanyGroupDTO companyGroupDTO = companyGroupService.getCompanyGroupDTOById(id);
		if (companyGroupDTO != null) {
			boolean isDeleted = companyGroupService.deleteCompanyGroup(companyGroupDTO);
			if (isDeleted) {
				return Response.status(200).build();
			}
		}
		return Response.status(404).build();
	}
}