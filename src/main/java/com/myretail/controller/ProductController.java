package com.myretail.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.myretail.entity.Product;
import com.myretail.exception.CustomResponse;
import com.myretail.exception.ProductMissMatchException;
import com.myretail.exception.ProductNotFoundException;
import com.myretail.service.ProductService;


/**
 * @author navee
 *
 */
@RequestMapping(value="/products")
@RestController
public class ProductController {

	protected Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	ProductService productService;
	
	/**
	 * @return
	 * This method can be used to fetch all the products. 
	 *
	 */
	@RequestMapping(value = "",method = RequestMethod.GET)
	public String index() {
		return "I can show all the products when implemented.";
	}

	/**
	 * @param productId
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> getProductInfo(@PathVariable("id") String productId) {
		logger.info("Inside getproductInfo  " + productId);

		Product product = null;
		try {
			product = productService.getProductById(productId);
		} catch (Exception e) {
			logger.debug("Product Not Found Exception  " + e);
			throw new ProductNotFoundException();
		}
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}

	/**
	 * @param prodInfo
	 * @param productId
	 * @return
	 *  
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = "application/json")
	public ResponseEntity<CustomResponse> modifyPrice(@RequestBody Product product,
			@PathVariable("id") String productId) {
		if (!product.getProductId().equalsIgnoreCase(productId)) {
			throw new ProductMissMatchException();
		}
		try {
			productService.updateProductById(product);
		} catch (Exception e) {
			logger.debug("Product Not Found Exception while update " + e);
			throw new ProductNotFoundException();
		}

		return new ResponseEntity<CustomResponse>(
				new CustomResponse(HttpStatus.OK.value(), "Product price has been updated"), HttpStatus.OK);
	}
}
