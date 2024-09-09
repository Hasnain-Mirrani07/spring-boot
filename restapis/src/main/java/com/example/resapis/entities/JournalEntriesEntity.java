package com.example.resapis.entities;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document()
@Data
public class JournalEntriesEntity {
    @Id
    private ObjectId id;
    private String name;
    private int age;
    private LocalDateTime date;





}
