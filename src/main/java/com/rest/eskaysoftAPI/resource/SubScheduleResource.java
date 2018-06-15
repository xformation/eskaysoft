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

import com.rest.eskaysoftAPI.dto.SubScheduleDTO;
import com.rest.eskaysoftAPI.service.SubScheduleService;
import com.rest.eskaysoftAPI.util.util;

/**
 * Resource for Schedules to create/update/get/delete
 * 
 * @author Lavanya
 * @since 7th May, 2018
 */
@Resource(name = "subschedules")
@Path("/subschedules")
public class SubScheduleResource {

	@Autowired
	SubScheduleService subScheduleService;

	/**
	 * Returns all SubSchedules
	 * 
	 * @return
	 */

	@GET
	@Produces("application/json")
	public Response getAllSubSchedules() {
		return util.buildResponse(subScheduleService.getSubSchedules());
	}

	/**
	 * Return the SubSchedule details for given subScheduleId
	 * 
	 * @param subScheduleId
	 * @return
	 * @throws URISyntaxException
	 */
	@GET
	@Path("/{subScheduleId}")
	@Produces("application/json")
	public Response getSubScheduleById(@PathParam("subScheduleId") Long subScheduleId) throws URISyntaxException {
		System.out.println("subScheduleService=" + subScheduleService);
		SubScheduleDTO subschedule = subScheduleService.getSubScheduleById(subScheduleId);
		return util.buildResponse(subschedule);
	}

	/**
	 * Creates a SubSchedule with given details
	 * 
	 * @param subschedule
	 * @return
	 * @throws URISyntaxException
	 */
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response createSubSchedules(SubScheduleDTO subschedule) throws URISyntaxException {
		if (subschedule == null) {
			return Response.status(404).build();
		}
		subScheduleService.createSubSchedule(subschedule);
		return Response.status(200).build();
	}

	/**
	 * Update the SubSchedule details
	 * 
	 * @param subScheduleDTO
	 * @return
	 * @throws URISyntaxException
	 */
	@PUT
	@Consumes("application/json")
	@Produces("application/json")
	public Response updateSubSchedule(SubScheduleDTO subScheduleDTO) throws URISyntaxException {
		subScheduleDTO = subScheduleService.upadateSubSchedule(subScheduleDTO);
		if (subScheduleDTO == null) {
			return Response.status(404).build();
		}
		return Response.status(200).build();
	}

	/**
	 * Delete the SubSchedule
	 * 
	 * @param subScheduleId
	 * @return
	 * @throws URISyntaxException
	 */
	@DELETE
	@Path("/{subScheduleId}")
	public Response deleteSubSchedule(@PathParam("subScheduleId") Long subScheduleId) throws URISyntaxException {
		SubScheduleDTO subScheduleDTO = subScheduleService.getSubScheduleById(subScheduleId);
		if (subScheduleDTO != null) {
			boolean isDeleted = subScheduleService.deleteSubSchedule(subScheduleDTO);
			if (isDeleted) {
				return Response.status(200).build();
			}

		}
		return Response.status(404).build();

	}

}
