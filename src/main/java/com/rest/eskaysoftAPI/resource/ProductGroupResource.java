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

import com.rest.eskaysoftAPI.dto.ProductGroupDTO;
import com.rest.eskaysoftAPI.service.ProductGroupService;
import com.rest.eskaysoftAPI.util.util;

/**
 * Resource for product groups to create/update/get/delete
 * 
 * @author Lavanya
 * @since 7th May, 2018
 *
 */

@Resource(name = "productgroup")
@Path("/productgroup")
public class ProductGroupResource {

	@Autowired
	ProductGroupService productGroupService;

	/**
	 * Returns all productgroups
	 * 
	 * @return
	 */
	@GET
	@Produces("application/json")
	public Response getAllProductGroups() {
		return util.buildResponse(productGroupService.getProductGroup());
	}

	/**
	 * 
	 * @param productGroupId
	 * @return
	 * @throws URISyntaxException
	 */
	@GET
	@Path("/{productCategoryId}")
	@Produces("application/json")
	public Response getProductGroupById(@PathParam("productGroupId") Long productGroupId) throws URISyntaxException {
		ProductGroupDTO productgroup = productGroupService.getProductGroupById(productGroupId);
		return util.buildResponse(productgroup);
	}

	/**
	 * 
	 * @param productgroup
	 * @return
	 * @throws URISyntaxException
	 */
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response createProductGroup(ProductGroupDTO productgroup) throws URISyntaxException {
		if (productgroup == null) {
			return Response.status(404).build();
		}
		productGroupService.createProductGroup(productgroup);
		return Response.status(200).build();
	}

	/**
	 * 
	 * @param productgroupDTO
	 * @return
	 * @throws URISyntaxException
	 */
	@PUT
	@Consumes("application/json")
	@Produces("application/json")
	public Response updateProductGroup(ProductGroupDTO productgroupDTO) throws URISyntaxException {
		productgroupDTO = productGroupService.updateProductGroup(productgroupDTO);
		if (productgroupDTO == null) {
			return Response.status(404).build();
		}
		return Response.status(200).build();
	}

	/**
	 * 
	 * @param productGroupId
	 * @return
	 * @throws URISyntaxException
	 */
	@DELETE
	@Path("/{productGroupId}")
	public Response deleteProductGroup(@PathParam("productGroupId") Long productGroupId) throws URISyntaxException {
		ProductGroupDTO productgroupDTO = productGroupService.getProductGroupById(productGroupId);
		if (productgroupDTO != null) {
			boolean isDeleted = productGroupService.deleteProductGroup(productgroupDTO);
			if (isDeleted) {
				return Response.status(200).build();
			}
		}
		return Response.status(404).build();
	}
}
