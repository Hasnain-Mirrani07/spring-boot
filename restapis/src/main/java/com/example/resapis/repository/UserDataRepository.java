package com.example.resapis.repository;

import com.example.resapis.entities.UserDataEntitiy;
import com.example.resapis.entities.UserEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserDataRepository extends MongoRepository<UserDataEntitiy, ObjectId> {
    UserDataEntitiy findByuserName(String userName);
}
