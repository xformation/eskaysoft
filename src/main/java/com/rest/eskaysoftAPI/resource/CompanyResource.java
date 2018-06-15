
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

import com.rest.eskaysoftAPI.dto.CompanyDTO;
import com.rest.eskaysoftAPI.service.CompanyService;
import com.rest.eskaysoftAPI.util.util;

/**
 * Resource for Company to create/update/get/delete
 * 
 * @author SuryaSree
 * @since 7th May, 2018
 *
 */
@Resource(name = "company")
@Path("/company")
public class CompanyResource {

	@Autowired
	CompanyService companyService;

	/**
	 * Returns all 
	 * 
	 * @return
	 */
	@GET
	@Produces("application/json")
	public Response getAllCompanies() {
		return util.buildResponse(companyService.getCompanies());
	}

	/**
	 * Return the Company details for given id
	 * 
	 * @param id
	 * @return
	 * @throws URISyntaxException
	 */
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Response getCompanyById(@PathParam("id") Long id) throws URISyntaxException {
		CompanyDTO company = companyService.getCompanyById(id);
		return util.buildResponse(company);
	}

	/**
	 * Creates a company with given details
	 * 
	 * @param company
	 * @return
	 * @throws URISyntaxException
	 */
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response createCompany(CompanyDTO company) throws URISyntaxException {
		if (company == null) {
			return Response.status(404).build();
		}
		companyService.createCompany(company);
		return Response.status(200).build();
	}

	/**
	 * Update the Company details
	 * 
	 * @param companyDTO
	 * @return
	 * @throws URISyntaxException
	 */
	@PUT
	@Consumes("application/json")
	@Produces("application/json")
	public Response updateCompany(CompanyDTO companyDTO) throws URISyntaxException {
		companyDTO = companyService.updateCompany(companyDTO);
		if (companyDTO == null) {
			return Response.status(404).build();
		}
		return Response.status(200).build();
	}

	/**
	 * Delete the Company
	 * 
	 * @param id
	 * @return
	 * @throws URISyntaxException
	 */
	@DELETE
	@Path("/{id}")
	public Response deleteCompany(@PathParam("id") Long id) throws URISyntaxException {
		CompanyDTO companyDTO = companyService.getCompanyById(id);
		if (companyDTO != null) {
			boolean isDeleted = companyService.deleteCompany(companyDTO);
			if (isDeleted) {
				return Response.status(200).build();
			}
		}
		return Response.status(404).build();
	}
}