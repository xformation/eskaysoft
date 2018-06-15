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

import com.rest.eskaysoftAPI.dto.ProductDTO;
import com.rest.eskaysoftAPI.service.ProductService;
import com.rest.eskaysoftAPI.util.util;

/**
 * Resource for Schedules to create/update/get/delete
 * 
 * @author Lavanya
 * @since 7th May, 2018
 */

@Resource(name = "product")
@Path("/product")
public class ProductResource {

	@Autowired
	ProductService productService;

	/**
	 * Returns all products
	 * 
	 * @return
	 */

	@GET
	@Produces("application/json")
	public Response getAllproducts() {
		return util.buildResponse(productService.getProducts());
	}

	/**
	 * Return the product details for given productId
	 * 
	 * @param productId
	 * @return
	 * @throws URISyntaxException
	 */
	@GET
	@Path("/{productId}")
	@Produces("application/json")
	public Response getSubScheduleById(@PathParam("productId") Long productId) throws URISyntaxException {
		ProductDTO product = productService.getProductById(productId);
		return util.buildResponse(product);
	}

	/**
	 * Creates a product with given details
	 * 
	 * @param product
	 * @return
	 * @throws URISyntaxException
	 */
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response createProduct(ProductDTO product) throws URISyntaxException {
		if (product == null) {
			return Response.status(404).build();
		}
		productService.createProduct(product);
		return Response.status(200).build();
	}

	/**
	 * Update the Product details
	 * 
	 * @param productDTO
	 * @return
	 * @throws URISyntaxException
	 */
	@PUT
	@Consumes("application/json")
	@Produces("application/json")
	public Response updateProduct(ProductDTO productDTO) throws URISyntaxException {
		productDTO = productService.updateProduct(productDTO);
		if (productDTO == null) {
			return Response.status(404).build();
		}
		return Response.status(200).build();
	}

	/**
	 * Delete the Product
	 * 
	 * @param productId
	 * @return
	 * @throws URISyntaxException
	 */
	@DELETE
	@Path("/{productId}")
	public Response deleteProduct(@PathParam("productId") Long productId) throws URISyntaxException {
		ProductDTO productDTO = productService.getProductById(productId);
		if (productDTO != null) {
			boolean isDeleted = productService.deleteProduct(productDTO);
			if (isDeleted) {
				return Response.status(200).build();
			}

		}
		return Response.status(404).build();

	}

}
