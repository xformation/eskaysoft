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

import com.rest.eskaysoftAPI.dto.ManfacturerDTO;
import com.rest.eskaysoftAPI.service.ManfacturerService;
import com.rest.eskaysoftAPI.util.util;

/**
 * Resource for Schedules to create/update/get/delete
 * 
 * @author Lavanya
 * @since 7th May, 2018
 *
 */

@Resource(name = "manfacturer")
@Path("/manfacturer")
public class ManfacturerResource {

	@Autowired
	ManfacturerService manfacturerService;

	/**
	 * Returns all manfacturers
	 * 
	 * @return
	 */
	@GET
	@Produces("application/json")
	public Response getAllManfacturers() {
		return util.buildResponse(manfacturerService.getManfacturer());
	}

	/**
	 * 
	 * @param manfacturerId
	 * @return
	 * @throws URISyntaxException
	 */
	@GET
	@Path("/{manfacturerId}")
	@Produces("application/json")
	public Response getManfacturerById(@PathParam("manfacturerId") Long manfacturerId) throws URISyntaxException {
		ManfacturerDTO manfacturer = manfacturerService.getManfacturerById(manfacturerId);
		return util.buildResponse(manfacturer);
	}

	/**
	 * 
	 * @param manfacturer
	 * @return
	 * @throws URISyntaxException
	 */
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response createManfacturer(ManfacturerDTO manfacturer) throws URISyntaxException {
		if (manfacturer == null) {
			return Response.status(404).build();
		}
		manfacturerService.createManfacturer(manfacturer);
		return Response.status(200).build();
	}

	/**
	 * 
	 * @param manfacturerDTO
	 * @return
	 * @throws URISyntaxException
	 */
	@PUT
	@Consumes("application/json")
	@Produces("application/json")
	public Response updateManfacturer(ManfacturerDTO manfacturerDTO) throws URISyntaxException {
		manfacturerDTO = manfacturerService.updateManfacturer(manfacturerDTO);
		if (manfacturerDTO == null) {
			return Response.status(404).build();
		}
		return Response.status(200).build();
	}

	/**
	 * 
	 * @param manfacturerId
	 * @return
	 * @throws URISyntaxException
	 */
	@DELETE
	@Path("/{manfacturerId}")
	public Response deleteManfacturer(@PathParam("manfacturerId") Long manfacturerId) throws URISyntaxException {
		ManfacturerDTO manfacturerDTO = manfacturerService.getManfacturerById(manfacturerId);
		if (manfacturerDTO != null) {
			boolean isDeleted = manfacturerService.deleteManfacturer(manfacturerDTO);
			if (isDeleted) {
				return Response.status(200).build();
			}
		}
		return Response.status(404).build();
	}
}