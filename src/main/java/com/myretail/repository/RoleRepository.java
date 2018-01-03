package com.myretail.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.myretail.entity.Role;

/**
 * @author navee
 *
 */
public interface RoleRepository extends MongoRepository<Role, String> {

}
