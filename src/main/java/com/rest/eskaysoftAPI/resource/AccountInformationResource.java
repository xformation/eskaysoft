package com.rest.eskaysoftAPI.resource;

import java.net.URISyntaxException;

import javax.annotation.Resource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import com.rest.eskaysoftAPI.dto.AccountInformationDTO;
import com.rest.eskaysoftAPI.service.AccountInformationService;
import com.rest.eskaysoftAPI.util.util;

@Resource(name = "accountInformation")
@Path("/accountInformation")
public class AccountInformationResource {

	@Autowired
	AccountInformationService accountInformationService;

	@GET
	@Produces("application/json")
	public Response getaccountInformation() {
		return util.buildResponse(accountInformationService.getaccountInformation());
	}

	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Response getaccountInformationById(@PathParam("id") Long id) throws URISyntaxException {
		AccountInformationDTO accountInformation = accountInformationService.getaccountInformationById(id);
		return util.buildResponse(accountInformation);
	}
}
