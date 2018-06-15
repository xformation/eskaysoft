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

import com.rest.eskaysoftAPI.dto.AccountOpeningsDTO;
import com.rest.eskaysoftAPI.service.AccountOpeningsService;
import com.rest.eskaysoftAPI.util.util;

@Resource(name = "accountOpenings")
@Path("/accountOpenings")
public class AccountOpeningsResource {

	@Autowired
	AccountOpeningsService accountOpeningsService;

	@GET
	@Produces("application/json")
	public Response getaccountOpenings() {
		return util.buildResponse(accountOpeningsService.getaccountOpenings());
	}

	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Response getaccountOpeningsById(@PathParam("id") Long id) throws URISyntaxException {
		AccountOpeningsDTO accountOpenings = accountOpeningsService.getaccountOpeningsById(id);
		return util.buildResponse(accountOpenings);
	}

	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response createAccountOpenings(AccountOpeningsDTO accountOpenings) throws URISyntaxException {
		if (accountOpenings == null) {
			return Response.status(404).build();
		}
		accountOpeningsService.createAccountOpenings(accountOpenings);
		return Response.status(200).build();
	}

	@PUT
	@Consumes("application/json")
	@Produces("application/json")
	public Response updateAccountOpenings(AccountOpeningsDTO accountOpeningsDTO) throws URISyntaxException {
		accountOpeningsDTO = accountOpeningsService.updateAccountOpenings(accountOpeningsDTO);
		if (accountOpeningsDTO == null) {
			return Response.status(404).build();
		}
		return Response.status(200).build();
	}

	@DELETE
	@Path("/{id}")
	public Response deleteAccountOpenings(@PathParam("id") Long id) throws URISyntaxException {
		AccountOpeningsDTO accountOpeningsDTO = accountOpeningsService.getaccountOpeningsById(id);
		if (accountOpeningsDTO != null) {
			boolean isDeleted = accountOpeningsService.deleteAccountOpenings(accountOpeningsDTO);
			if (isDeleted) {
				return Response.status(200).build();
			}
		}
		return Response.status(404).build();
	}

}
