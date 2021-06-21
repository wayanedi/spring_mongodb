package com.example.mongodb;

import com.example.mongodb.models.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepo extends MongoRepository<Customer, String> {
}
