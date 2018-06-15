package com.rest.eskaysoftAPI.service;

import java.util.List;

import com.rest.eskaysoftAPI.dto.ProductDTO;

public interface ProductService {
	/**
	 * 
	 * @return
	 */
	List<ProductDTO> getProducts();

	/**
	 * 
	 * @param productGroupId
	 * @return
	 */
	ProductDTO getProductById(Long productId);

	/**
	 * 
	 * @param productgroup
	 * @return
	 */
	boolean createProduct(ProductDTO product);

	/**
	 * 
	 * @param productgroup
	 * @return
	 */
	ProductDTO updateProduct(ProductDTO product);

	/**
	 * 
	 * @param productgroup
	 * @return
	 */
	boolean deleteProduct(ProductDTO product);

}
