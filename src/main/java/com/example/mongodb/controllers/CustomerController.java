package com.example.mongodb.controllers;

import com.example.mongodb.models.Customer;
import com.example.mongodb.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/customer")

public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping()
    public String getAllUser()
    {
		return customerService.getAllUser();
    }

    @PostMapping()
    public Customer register(@RequestBody Customer newCustomer)
    {
        return customerService.Register(newCustomer);
    }

    @PutMapping("/{id}")
    public Optional<Customer> updateCustomer(@RequestBody Customer newcustomer, @PathVariable String id)
    {
        return customerService.updateCustomer(newcustomer, id);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable String id){
        customerService.delete(id);
    }
}
