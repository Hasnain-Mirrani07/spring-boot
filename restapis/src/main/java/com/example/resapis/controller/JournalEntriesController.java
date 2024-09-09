package com.example.resapis.controller;

import com.example.resapis.entities.JournalEntriesEntity;
import com.example.resapis.entities.UserEntity;
import com.example.resapis.services.JournalEntriesService;
import com.example.resapis.services.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;






@RestController
@RequestMapping("/journalEntries")
public class JournalEntriesController {

    @Autowired
    private JournalEntriesService journalEntriesService;

    @PostMapping("/createUser")
    public ResponseEntity<JournalEntriesEntity> createUser(@RequestBody JournalEntriesEntity journalEntriesEntity) {
        try {
            journalEntriesEntity.setDate(LocalDateTime.now());
            journalEntriesService.saveUser(journalEntriesEntity);
            return new ResponseEntity<>(journalEntriesEntity, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }


    @GetMapping("/getAllUsers")
    public ResponseEntity<?> getAllUsers() {
        List<JournalEntriesEntity> allJournalEntitesList=journalEntriesService.getAllUser();
        if(allJournalEntitesList != null && !allJournalEntitesList.isEmpty()){
            return new ResponseEntity<>(allJournalEntitesList,HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/getUserById/{userId}")
    public ResponseEntity<JournalEntriesEntity> getUserById(@PathVariable ObjectId userId) {
        Optional<JournalEntriesEntity> journalEntries = journalEntriesService.getUserById(userId);
        return journalEntries.map(entity -> new ResponseEntity<>(entity, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }


    @PutMapping("/editUserById/{userId}")
    public ResponseEntity<?> editUserById(@PathVariable ObjectId userId, @RequestBody JournalEntriesEntity newJournalEntries) {

        JournalEntriesEntity old = journalEntriesService.getUserById(userId).orElse(null);

        if (old != null) {
            old.setName(newJournalEntries.getName() != null && !newJournalEntries.getName().isEmpty() ? newJournalEntries.getName() : old.getName());
            old.setAge(newJournalEntries.getAge() == 0 ? newJournalEntries.getAge() : old.getAge());
            journalEntriesService.saveUser(old);
            return new ResponseEntity<>(old,HttpStatus.OK);
        }else{
            return new ResponseEntity<>("User Not Found",HttpStatus.NOT_FOUND);
        }



    }


    @DeleteMapping("/deleteUserById/{userId}")
    public ResponseEntity<?> deleteUserById(@PathVariable("userId") ObjectId userId) {
        journalEntriesService.deleteById(userId);
        return new  ResponseEntity<>("successfully Deleted User",HttpStatus.OK);



    }


}
