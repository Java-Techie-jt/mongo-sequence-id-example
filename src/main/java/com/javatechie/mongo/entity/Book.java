package com.javatechie.mongo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "books")
public class Book {

    @Transient
    public static final String SEQUENCE_NAME = "";

   @Transient
    public static final String ID_VAL = "user_sequence";
    @Transient
    public static final String GENERATED_ID = "userId"; //IdSequence.formId
    @Transient
    public static final String ID_KEY = "id"; //IdSequence.formId
    
    @Id
    private int id;
    private String name;
    private double price;
}
