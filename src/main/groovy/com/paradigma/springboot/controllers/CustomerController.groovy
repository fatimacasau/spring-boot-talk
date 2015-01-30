package com.paradigma.springboot.controllers;

import com.paradigma.springboot.domain.Customer;
import org.springframework.web.bind.annotation.*
import org.springframework.http.*
import static org.springframework.web.bind.annotation.RequestMethod.*

/**
 * Created by fcasau on 1/28/15.
 */
@RestController
public class CustomerController {

    @RequestMapping("/customer/{id}")
    @ResponseBody
    public Customer reverse(@PathVariable Long id) {
        return Customer.get(id)
    }
    
    @RequestMapping(value="/customerByName", method = GET)
    String greet(String firstName) {
        def p = Customer.findByFirstName(firstName)
        return p ? "Hello ${p.firstName}!" : "Person not found"
    }

    @RequestMapping(value = '/customer/add', method = POST)
    ResponseEntity addPerson(String firstName, String lastName) {
        Customer.withTransaction {
            def p = new Customer(firstName: firstName, lastName: lastName).save()
            if(p) {
                return new ResponseEntity(HttpStatus.CREATED)
            }
            else {
                return new ResponseEntity(HttpStatus.BAD_REQUEST)
            }
        }
    }
}
