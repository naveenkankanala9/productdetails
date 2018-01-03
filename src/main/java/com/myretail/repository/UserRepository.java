package com.myretail.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.myretail.entity.User;

/**
 * @author navee
 *
 */
public interface UserRepository extends MongoRepository<User, String> {

	/**
	 * @param username
	 * @return
	 */
	public User findByUsername(String username);
}
