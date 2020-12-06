package com.javatechie.mongo.repository;

import com.javatechie.mongo.entity.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book,Integer> {
}
