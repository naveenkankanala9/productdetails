package com.myretail.feignclient;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

/**
 * @author navee
 *
 */
@Component
public class ProductInfoClientMock implements ProductInfoClient {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.myretail.feignclient.ProductInfoClient#
	 * getProductInfoById(java.lang.String)
	 */
	@Override
	public ResponseEntity<String> getProductInfoById(String productId) {
		String productInfo = "{\"product\": {\"item\": {\"product_description\": {\"title\": \"The Big Lebowski (Blu-ray) (Widescreen)\"}}}}";

		return new ResponseEntity<String>(productInfo, HttpStatus.OK);
	}

}

