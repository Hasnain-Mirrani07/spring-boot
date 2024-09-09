package com.example.resapis.services;

import com.example.resapis.entities.JournalEntriesEntity;
import com.example.resapis.entities.UserEntity;
import com.example.resapis.repository.JournalEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class JournalEntriesService {

    @Autowired
   private JournalEntryRepository journalEntryRepository;

    public void saveUser(JournalEntriesEntity journalEntriesEntity){
        journalEntryRepository.save(journalEntriesEntity);
    }

    public List<JournalEntriesEntity> getAllUser() {
        return journalEntryRepository.findAll();
    }

    public Optional<JournalEntriesEntity> getUserById(ObjectId id) {
        return journalEntryRepository.findById(id);
    }



    public void deleteById(ObjectId id){
        journalEntryRepository.deleteById(id);
    }
}
