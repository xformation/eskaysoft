package com.rest.eskaysoftAPI.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.eskaysoftAPI.dao.ProductDao;
import com.rest.eskaysoftAPI.dto.ProductDTO;
import com.rest.eskaysoftAPI.entity.Product;
import com.rest.eskaysoftAPI.service.ProductService;

@Service("productService")
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDao productDao;

	@Override
	public List<ProductDTO> getProducts() {
		List<Product> product = new ArrayList<>(productDao.findAll());
		List<ProductDTO> productList = null;
		if (product != null) {
			productList = new ArrayList<ProductDTO>();
			for (Product products : product) {
				ProductDTO productDTO = new ProductDTO(products.getProductId(), products.getProductCode(),
						products.getProductName(), products.getPacking(), products.getBoxQty(), products.getGroup(),
						products.getCaseQty(), products.getCategory(), products.getNetRate(),
						products.getIsNetRateItem(), products.getSchemeQty(), products.getFree(), products.getTax());
				productList.add(productDTO);
			}
		}

		return productList;
	}

	@Override
	public ProductDTO getProductById(Long productId) {
		Product product = productDao.findOne(productId);
		if (product != null) {
			ProductDTO productDTO = new ProductDTO(product.getProductId(), product.getProductCode(),
					product.getProductName(), product.getPacking(), product.getBoxQty(), product.getGroup(),
					product.getCaseQty(), product.getCategory(), product.getNetRate(), product.getIsNetRateItem(),
					product.getSchemeQty(), product.getFree(), product.getTax());
			return productDTO;
		}
		return null;
	}

	@Override
	public ProductDTO updateProduct(ProductDTO productDTO) {
		Product product = productDao.findOne(productDTO.getProductId());

		if (product != null) {
			product.setProductCode(productDTO.getProductCode());
			product.setProductName(productDTO.getProductName());
			product.setPacking(productDTO.getPacking());
			product.setBoxQty(productDTO.getBoxQty());
			product.setGroup(productDTO.getGroup());
			product.setCaseQty(productDTO.getCaseQty());
			product.setCategory(productDTO.getCategory());
			product.setNetRate(productDTO.getNetRate());
			product.setIsNetRateItem(productDTO.getIsNetRateItem());
			product.setSchemeQty(productDTO.getSchemeQty());
			product.setFree(productDTO.getFree());
			product.setTax(productDTO.getTax());

			if (null != product) {
				return productDTO;
			}
		}

		return null;
	}

	@Override
	public boolean createProduct(ProductDTO productDTO) {
		try {
			Product product = new Product(null, productDTO.getProductCode(), productDTO.getProductName(),
					productDTO.getPacking(), productDTO.getBoxQty(), productDTO.getGroup(), productDTO.getCaseQty(),
					productDTO.getCategory(), productDTO.getNetRate(), productDTO.getIsNetRateItem(),
					productDTO.getSchemeQty(), productDTO.getFree(), productDTO.getTax());
			Product savedProduct = productDao.save(product);
			return savedProduct == null ? false : true;
		} catch (Exception e) {
			System.out.println("Unable to create product:" + productDTO.getProductName());
		}
		return false;
	}

	@Override
	public boolean deleteProduct(ProductDTO productDTO) {
		try {
			productDao.delete(productDTO.getProductId());
			return true;
		} catch (Exception e) {
			System.out.println("Unable to delete product having id:" + productDTO.getProductId());
		}
		return false;
	}

}
