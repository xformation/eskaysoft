
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

import com.rest.eskaysoftAPI.dto.DistrictDTO;
import com.rest.eskaysoftAPI.service.DistrictService;
import com.rest.eskaysoftAPI.util.util;

/**
 * Resource for Districts to create/update/get/delete
 * 
 * @author SuryaSree
 * @since 7th May, 2018
 *
 */
@Resource(name = "districts")
@Path("/districts")
public class DistrictResource {

	@Autowired
	DistrictService districtsService;

	/**
	 * Returns all districts
	 * 
	 * @return
	 */
	@GET
	@Produces("application/json")
	public Response getAllDistricts() {
		return util.buildResponse(districtsService.getDistricts());
	}

	/**
	 * Return the Districts details for given id
	 * 
	 * @param id
	 * @return
	 * @throws URISyntaxException
	 */
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Response getDistrictsById(@PathParam("id") Long id) throws URISyntaxException {
		DistrictDTO district = districtsService.getDistrictsById(id);
		return util.buildResponse(district);
	}

	/**
	 * Creates a district with given details
	 * 
	 * @param district
	 * @return
	 * @throws URISyntaxException
	 */
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response createDistrict(DistrictDTO district) throws URISyntaxException {
		if (district == null) {
			return Response.status(404).build();
		}
		districtsService.createDistrict(district);
		return Response.status(200).build();
	}

	/**
	 * Update the District details
	 * 
	 * @param districtDTO
	 * @return
	 * @throws URISyntaxException
	 */
	@PUT
	@Consumes("application/json")
	@Produces("application/json")
	public Response updateDistrict(DistrictDTO districtDTO) throws URISyntaxException {
		districtDTO = districtsService.updateDistrict(districtDTO);
		if (districtDTO == null) {
			return Response.status(404).build();
		}
		return Response.status(200).build();
	}

	/**
	 * Delete the District
	 * 
	 * @param id
	 * @return
	 * @throws URISyntaxException
	 */
	@DELETE
	@Path("/{id}")
	public Response deleteDistrict(@PathParam("id") Long id) throws URISyntaxException {
		DistrictDTO districtDTO = districtsService.getDistrictsById(id);
		if (districtDTO != null) {
			boolean isDeleted = districtsService.deleteDistrict(districtDTO);
			if (isDeleted) {
				return Response.status(200).build();
			}
		}
		return Response.status(404).build();
	}
}