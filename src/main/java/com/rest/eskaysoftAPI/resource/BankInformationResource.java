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

import com.rest.eskaysoftAPI.dto.BankInformationDTO;
import com.rest.eskaysoftAPI.service.BankInformationService;
import com.rest.eskaysoftAPI.util.util;

/**
 * Resource for Schedules to create/update/get/delete
 * 
 * @author Lavanya
 * @since 7th May, 2018
 *
 */

@Resource(name = "bankinformation")
@Path("/bankinformation")
public class BankInformationResource {

	@Autowired
	BankInformationService bankinformationService;

	/**
	 * Returns all bankinformation
	 * 
	 * @return
	 */
	@GET
	@Produces("application/json")
	public Response getAllBankInformation() {
		return util.buildResponse(bankinformationService.getBankInformation());
	}

	/**
	 * 
	 * @param bankId
	 * @return
	 * @throws URISyntaxException
	 */
	@GET
	@Path("/{bankId}")
	@Produces("application/json")
	public Response getBankInformationById(@PathParam("id") Long id) throws URISyntaxException {
		BankInformationDTO bankinformation = bankinformationService.getBankInformationById(id);
		return util.buildResponse(bankinformation);
	}

	/**
	 * Creates bankinformation with given details
	 * 
	 * @param bankinformation
	 * @return
	 * @throws URISyntaxException
	 */
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response createBankInformation(BankInformationDTO bankinformation) throws URISyntaxException {
		if (bankinformation == null) {
			return Response.status(404).build();
		}
		bankinformationService.createBankInformation(bankinformation);
		return Response.status(200).build();
	}

	/**
	 * Update the BankInformation details
	 * 
	 * @param bankinformationDTO
	 * @return
	 * @throws URISyntaxException
	 */
	@PUT
	@Consumes("application/json")
	@Produces("application/json")
	public Response updateBankInformation(BankInformationDTO bankinformationDTO) throws URISyntaxException {
		bankinformationDTO = bankinformationService.updateBankInformation(bankinformationDTO);
		if (bankinformationDTO == null) {
			return Response.status(404).build();
		}
		return Response.status(200).build();
	}

	/**
	 * Delete the BankInformation
	 * 
	 * @param bankId
	 * @return
	 * @throws URISyntaxException
	 */
	@DELETE
	@Path("/{bankId}")
	public Response deleteBankInformation(@PathParam("id") Long id) throws URISyntaxException {
		BankInformationDTO bankinformationDTO = bankinformationService.getBankInformationById(id);
		if (bankinformationDTO != null) {
			boolean isDeleted = bankinformationService.deleteBankInformation(bankinformationDTO);
			if (isDeleted) {
				return Response.status(200).build();
			}
		}
		return Response.status(404).build();
	}
}
