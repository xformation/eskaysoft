
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

import com.rest.eskaysoftAPI.dto.ScheduleDTO;
import com.rest.eskaysoftAPI.service.ScheduleService;
import com.rest.eskaysoftAPI.util.util;

/**
 * Resource for Schedules to create/update/get/delete
 * 
 * @author SuryaSree
 * @since 7th May, 2018
 *
 */
@Resource(name = "schedules")
@Path("/schedules")
public class ScheduleResource {

	@Autowired
	ScheduleService scheduleService;

	/**
	 * Returns all schedules
	 * 
	 * @return
	 */
	@GET
	@Produces("application/json")
	public Response getAllSchedules() {
		return util.buildResponse(scheduleService.getSchedules());
	}

	/**
	 * Return the Schedule details for given id
	 * 
	 * @param id
	 * @return
	 * @throws URISyntaxException
	 */
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Response getScheduleById(@PathParam("id") Long id) throws URISyntaxException {
		System.out.println("scheduleService=" + scheduleService);
		ScheduleDTO schedule = scheduleService.getScheduleById(id);
		return util.buildResponse(schedule);
	}

	/**
	 * Creates a schedule with given details
	 * 
	 * @param schedule
	 * @return
	 * @throws URISyntaxException
	 */
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response createSchedule(ScheduleDTO schedule) throws URISyntaxException {
		if (schedule == null) {
			return Response.status(404).build();
		}
		scheduleService.createSchedule(schedule);
		return Response.status(200).build();
	}

	/**
	 * Update the Schedule details
	 * 
	 * @param scheduleDTO
	 * @return
	 * @throws URISyntaxException
	 */
	@PUT
	@Consumes("application/json")
	@Produces("application/json")
	public Response updateSchedule(ScheduleDTO scheduleDTO) throws URISyntaxException {
		scheduleDTO = scheduleService.updateSchedule(scheduleDTO);
		if (scheduleDTO == null) {
			return Response.status(404).build();
		}
		return Response.status(200).build();
	}

	/**
	 * Delete the Schedule
	 * 
	 * @param id
	 * @return
	 * @throws URISyntaxException
	 */
	@DELETE
	@Path("/{id}")
	public Response deleteSchedule(@PathParam("id") Long id) throws URISyntaxException {
		ScheduleDTO scheduleDTO = scheduleService.getScheduleById(id);
		if (scheduleDTO != null) {
			boolean isDeleted = scheduleService.deleteSchedule(scheduleDTO);
			if (isDeleted) {
				return Response.status(200).build();
			}
		}
		return Response.status(404).build();
	}
}