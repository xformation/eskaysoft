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

import com.rest.eskaysoftAPI.dto.AreaDTO;
import com.rest.eskaysoftAPI.service.AreaService;
import com.rest.eskaysoftAPI.util.util;

/**
 * Resource for AreaResource to create/update/get/delete
 * 
 * @author Surya sree
 * @since 7th May, 2018
 *
 */

@Resource(name = "area")
@Path("/area")
public class AreaResource {

	@Autowired
	AreaService areaService;

	/**
	 * Returns all areas
	 * 
	 * @return
	 */
	@GET
	@Produces("application/json")
	public Response getAllAreas() {
		return util.buildResponse(areaService.getArea());
	}

	/**
	 * 
	 * @param areaId
	 * @return
	 * @throws URISyntaxException
	 */
	@GET
	@Path("/{areaId}")
	@Produces("application/json")
	public Response getAreaById(@PathParam("id") Long areaId) throws URISyntaxException {
		AreaDTO area = areaService.getAreaById(areaId);
		return util.buildResponse(area);
	}

	/**
	 * Creates area with given details
	 * 
	 * @param area
	 * @return
	 * @throws URISyntaxException
	 */
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response createArea(AreaDTO area) throws URISyntaxException {
		if (area == null) {
			return Response.status(404).build();
		}
		areaService.createArea(area);
		return Response.status(200).build();
	}

	/**
	 * Update the Area details
	 * 
	 * @param areaDTO
	 * @return
	 * @throws URISyntaxException
	 */
	@PUT
	@Consumes("application/json")
	@Produces("application/json")
	public Response updateArea(AreaDTO areaDTO) throws URISyntaxException {
		areaDTO = areaService.updateArea(areaDTO);
		if (areaDTO == null) {
			return Response.status(404).build();
		}
		return Response.status(200).build();
	}

	/**
	 * Delete the Area
	 * 
	 * @param areaId
	 * @return
	 * @throws URISyntaxException
	 */
	@DELETE
	@Path("/{id}")
	public Response deleteArea(@PathParam("id") Long id) throws URISyntaxException {
		AreaDTO areaDTO = areaService.getAreaById(id);
		if (areaDTO != null) {
			boolean isDeleted = areaService.deleteArea(areaDTO);
			if (isDeleted) {
				return Response.status(200).build();
			}
		}
		return Response.status(404).build();
	}
}
