package com.spring.master.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.spring.master.entity.UserEntry;

/**
 * @author NaveenWodeyar
 * @date 30-Aug-2024
 */
public interface UserEntryRepository extends MongoRepository<UserEntry, Object> {

}
