package com.example.mongodb.services;
import com.example.mongodb.models.Customer;
import com.example.mongodb.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepo repo;

    public CustomerService(CustomerRepo repo) {
        this.repo = repo;
    }

    public Customer Register(Customer customer){
        return repo.save(customer);
    }

    public void save(Customer customer){
        repo.save(customer);
    }

    public String getAllUser()
    {
        return repo.findAll().stream().findFirst().toString();
    }

    public void delete(String id)
    {
        repo.deleteById(id);
    }

    public Optional<Customer> updateCustomer(Customer newcustomer, String id)
    {
        return repo.findById(id)
                .map(customer -> {
                    customer.setFirstName(newcustomer.getFirstName());
                    customer.setLastName(newcustomer.getLastName());
                    return  repo.save(customer);
                });
    }
}
