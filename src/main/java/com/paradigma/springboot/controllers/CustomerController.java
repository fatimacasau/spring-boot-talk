package com.paradigma.springboot.controllers;

import com.paradigma.springboot.domain.Customer;
import com.paradigma.springboot.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by fcasau on 1/28/15.
 */
@RestController
public class CustomerController {
    
    @Autowired
    CustomerRepository customerRepository;
    
    @RequestMapping("/mycustomers/{id}")
    public
    @ResponseBody
    Customer reverse(@PathVariable Long id) {
        return customerRepository.findOne(id);
    }
}
