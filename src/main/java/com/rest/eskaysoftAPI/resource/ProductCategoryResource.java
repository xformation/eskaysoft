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

import com.rest.eskaysoftAPI.dto.ProductCategoryDTO;
import com.rest.eskaysoftAPI.service.ProductCategoryService;
import com.rest.eskaysoftAPI.util.util;

/**
 * Resource for ProductCategory to create/update/get/delete
 * 
 * @author Lavanya
 * @since 7th May, 2018
 *
 */

@Resource(name = "productcategory")
@Path("/productcategory")
public class ProductCategoryResource {

	@Autowired
	ProductCategoryService productCategoryService;

	/**
	 * Returns all productcategories
	 * 
	 * @return
	 */
	@GET
	@Produces("application/json")
	public Response getAllProductGroups() {
		return util.buildResponse(productCategoryService.getProductCategory());
	}

	/**
	 * 
	 * @param productCategoryId
	 * @return
	 * @throws URISyntaxException
	 */
	@GET
	@Path("/{productCategoryId}")
	@Produces("application/json")
	public Response getProductCategoryById(@PathParam("productCategoryId") Long productCategoryId)
			throws URISyntaxException {
		ProductCategoryDTO productcategory = productCategoryService.getProductCategoryById(productCategoryId);
		return util.buildResponse(productcategory);
	}

	/**
	 * 
	 * @param productcategory
	 * @return
	 * @throws URISyntaxException
	 */
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response createProductCategory(ProductCategoryDTO productcategory) throws URISyntaxException {
		if (productcategory == null) {
			return Response.status(404).build();
		}
		productCategoryService.createProductCategory(productcategory);
		return Response.status(200).build();
	}

	/**
	 * 
	 * @param productcategoryDTO
	 * @return
	 * @throws URISyntaxException
	 */
	@PUT
	@Consumes("application/json")
	@Produces("application/json")
	public Response updateProductCategory(ProductCategoryDTO productcategoryDTO) throws URISyntaxException {
		productcategoryDTO = productCategoryService.updateProductCategory(productcategoryDTO);
		if (productcategoryDTO == null) {
			return Response.status(404).build();
		}
		return Response.status(200).build();
	}

	/**
	 * 
	 * @param productCategoryId
	 * @return
	 * @throws URISyntaxException
	 */
	@DELETE
	@Path("/{productCategoryId}")
	public Response deleteProductCategory(@PathParam("productCategoryId") Long productCategoryId)
			throws URISyntaxException {
		ProductCategoryDTO productcategoryDTO = productCategoryService.getProductCategoryById(productCategoryId);
		if (productcategoryDTO != null) {
			boolean isDeleted = productCategoryService.deleteProductCategory(productcategoryDTO);
			if (isDeleted) {
				return Response.status(200).build();
			}
		}
		return Response.status(404).build();
	}
}