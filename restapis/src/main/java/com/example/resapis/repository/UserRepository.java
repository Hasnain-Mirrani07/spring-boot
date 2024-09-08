package com.example.resapis.repository;

import com.example.resapis.entities.UserEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<UserEntity, ObjectId> {
}
