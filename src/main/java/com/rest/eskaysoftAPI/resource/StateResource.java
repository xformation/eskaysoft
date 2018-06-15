
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

import com.rest.eskaysoftAPI.dto.StateDTO;
import com.rest.eskaysoftAPI.service.StateService;
import com.rest.eskaysoftAPI.util.util;

@Resource(name = "states")
@Path("/states")
public class StateResource {

	@Autowired
	StateService stateService;

	@GET
	@Produces("application/json")
	public Response getAllState() {
		return util.buildResponse(stateService.getState());
	}

	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Response getStateById(@PathParam("id") Long id) throws URISyntaxException {
		StateDTO state = stateService.getStateById(id);
		return util.buildResponse(state);
	}

	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response createState(StateDTO state) throws URISyntaxException {
		if (state == null) {
			return Response.status(404).build();	
		}
		stateService.createState(state);
		return Response.status(200).build();
	}
	
	
	@PUT
	@Consumes("application/json")
	@Produces("application/json")
	public Response updateState(StateDTO stateDTO) throws URISyntaxException {
		stateDTO = stateService.updateState(stateDTO);
		if (stateDTO == null) {
			return Response.status(404).build();	
		}
		return Response.status(200).build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response deleteState(@PathParam("id") Long id) throws URISyntaxException {
		StateDTO stateDTO = stateService.getStateById(id);
		if (stateDTO != null) {
			boolean isDeleted = stateService.deleteState(stateDTO);
			if (isDeleted) {
				return Response.status(200).build();
			}
		}
		
		return Response.status(404).build();
	}
	
}