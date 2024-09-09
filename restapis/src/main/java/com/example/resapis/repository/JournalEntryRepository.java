package com.example.resapis.repository;

import com.example.resapis.entities.JournalEntriesEntity;
import com.example.resapis.entities.UserEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JournalEntryRepository extends MongoRepository<JournalEntriesEntity, ObjectId> {
}
