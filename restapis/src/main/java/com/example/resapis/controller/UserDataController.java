package com.example.resapis.controller;

import com.example.resapis.entities.UserDataEntitiy;
import com.example.resapis.services.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/userData")
public class UserDataController {


   @Autowired
   private UserDataService userDataService;


    @PostMapping
    public ResponseEntity<UserDataEntitiy> createUser(@RequestBody UserDataEntitiy userDataEntitiy) {
        try {
System.out.println(userDataEntitiy);
            userDataService.saveUser(userDataEntitiy);
            return new ResponseEntity<>(userDataEntitiy, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }


    @GetMapping
    public ResponseEntity<?> getAllUsers() {
        List<UserDataEntitiy> allUserDataList = userDataService.getAllUsers();
        if (allUserDataList != null && !allUserDataList.isEmpty()) {
            return new ResponseEntity<>(allUserDataList, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }


    @PutMapping("/{username}")
    public ResponseEntity<?> editUserById(@RequestBody UserDataEntitiy userDataEntitiy, @PathVariable String username) {

        UserDataEntitiy userInDb = userDataService.findUserByName(username);
        if (userInDb != null) {
            userInDb.setUserName(userDataEntitiy.getUserName());
            userInDb.setPassword(userDataEntitiy.getPassword());
            userDataService.saveUser(userInDb);
            return new ResponseEntity<>(userInDb, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



}
