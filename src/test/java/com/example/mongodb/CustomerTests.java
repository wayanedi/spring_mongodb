package com.example.mongodb;

import com.example.mongodb.models.Customer;
import com.example.mongodb.services.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;


public class CustomerTests  extends  MongodbApplicationTests{

    @Mock
    private CustomerRepo repo;
    @InjectMocks
    private CustomerService customerService;

    @Test
    void insertCustomers() throws Exception{
        Customer customer = new Customer("malaikat", "maut");
        customerService.save(customer);
        Mockito.verify(repo).save(customer);
    }

    @Test
    void insertCustomersReturn() throws Exception{
        Customer customer = new Customer("malaikat", "maut");
        Mockito.when(customerService.Register(customer)).thenReturn(customer);
    }

    @Test
    void delete()
    {
        customerService.delete("60ce19d1c6c196411382c78e");
        Mockito.verify(repo).deleteById("60ce19d1c6c196411382c78e");
    }
}
