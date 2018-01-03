/**
 * 
 */
package com.myretail.service;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.myretail.entity.Product;
import com.myretail.feignclient.ProductInfoClient;
import com.myretail.repository.ProductRepository;

/**
 * @author navee
 *
 */
@Component
public class AsyncProductService {
	
	@Autowired
	private ProductInfoClient productInfoClient;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Async
	public Future<Product> getProductByproductId(String productId) {
		System.out.println("From product start");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("From product end");
	    return new AsyncResult<>(productRepository.getProductByproductId(productId));
	    
	}
	
	/**
	 * @param productId
	 * @return
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 * @throws Exception
	 * 
	 * get the title from 
	 */
	@Async
	@SuppressWarnings({"unchecked","rawtypes"}) 
	public Future<String> getTitleForProduct(String productId) throws JsonParseException, JsonMappingException, IOException {
		System.out.println("From title start");
		Map<String, Map> infoMap = getProductInfoFromProductInfoService(productId);

		Map<String,Map> productMap = infoMap.get("product");
        Map<String,Map> itemMap = productMap.get("item");
        Map<String,String> prodDescrMap = itemMap.get(("product_description"));
        
        try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        System.out.println("From title end");
        return new AsyncResult<>(prodDescrMap.get("title"));
	}
	
	/**
	 * @param productId
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 * 
	 * Getting remote data using Feign product service.
	 */
	@SuppressWarnings({"unchecked","rawtypes"})
	private Map<String, Map> getProductInfoFromProductInfoService(String productId) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper infoMapper = new ObjectMapper();
		System.out.println(productInfoClient);
		ResponseEntity<String> response = productInfoClient.getProductInfoById(productId);
		System.out.println(response.getStatusCode().value());
		Map<String, Map> infoMap = infoMapper.readValue(response.getBody(), Map.class);
		
		return infoMap;
	}

}
