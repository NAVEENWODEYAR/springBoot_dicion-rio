package com.spring.master.repository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.spring.master.entity.JournalEntry;
/**
 * @author NaveenWodeyar
 * @date 30-Aug-2024
 */
@Repository
public interface JournalEntryRepository extends MongoRepository<JournalEntry, String> {

}
