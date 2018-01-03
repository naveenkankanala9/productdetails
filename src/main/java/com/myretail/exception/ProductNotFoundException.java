package com.myretail.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author navee
 *
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Product not found. ")
public class ProductNotFoundException extends RuntimeException {

	/**
	 * SUID
	 */
	private static final long serialVersionUID = 1L;

	public ProductNotFoundException() {
		
	}

}
