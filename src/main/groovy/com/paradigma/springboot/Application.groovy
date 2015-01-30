package com.paradigma.springboot

import com.paradigma.springboot.domain.Customer
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration


/**
 * Created by fcasau on 1/29/15.
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class Application {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(Application.class)

        // save a couple of customers
        [[firstName:"Jack", lastName:"Bauer"],
         [firstName:"Chloe", lastName:"O'Brian"],
         [firstName:"Kim", lastName:"Bauer"],
         [firstName:"David", lastName:"Palmer"],
         [firstName:"Michelle", lastName:"Dessler"]].each {
            new Customer(it).save()
        }
        // fetch all customers
        def customers = Customer.findAll()
        println "Customers found with findAll(): \n-------------------------------"
        customers.each {
            println it
        }
        // fetch an individual customer by ID
        def customer = Customer.get(1L)
        println "Customer found with findOne(1L): $customer \n"

        // fetch customers by last name
        customers = Customer.findByLastName("Bauer");
        println "Customer found with findByLastName('Bauer'): \n--------------------------------------------"
        customers.each {println it}

    }

}
