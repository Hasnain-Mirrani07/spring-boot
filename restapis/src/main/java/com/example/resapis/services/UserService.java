package com.example.resapis.services;

import com.example.resapis.entities.UserEntity;
import com.example.resapis.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserService {

    @Autowired
   private UserRepository userRepository;

    public void saveUser(UserEntity userEntity){
        userRepository.save(userEntity);
    }

    public List<UserEntity> getAllUser() {
        return userRepository.findAll();
    }

    public Optional<UserEntity> getUserById(ObjectId id) {
        return userRepository.findById(id);
    }



    public void deleteById(ObjectId id){
        userRepository.deleteById(id);
    }
}
