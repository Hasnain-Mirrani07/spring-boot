package com.example.resapis.entities;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;

@Document()
@Data
public class UserEntity {
    @Id
    private ObjectId id;
    private String name;
    private int age;
    private LocalDateTime date;





}
