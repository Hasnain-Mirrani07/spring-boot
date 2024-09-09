package com.example.resapis.services;

import com.example.resapis.entities.UserDataEntitiy;
import com.example.resapis.repository.UserDataRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class UserDataService {

    @Autowired
   private UserDataRepository userDataRepository;

    public void saveUser(UserDataEntitiy userDataEntitiy){
        userDataRepository.save(userDataEntitiy);
    }

public List<UserDataEntitiy> getAllUsers(){
        return userDataRepository.findAll();
}

    public UserDataEntitiy findUserByName(String useName){
       return userDataRepository.findByuserName(useName);
    }

}
