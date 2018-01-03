package com.myretail.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.myretail.entity.Product;

/**
 * @author navee
 *
 */
public interface ProductRepository extends MongoRepository<Product, String> {
	
	/**
	 * @param productId
	 * @return
	 */
	public Product getProductByproductId(String productId);
}
