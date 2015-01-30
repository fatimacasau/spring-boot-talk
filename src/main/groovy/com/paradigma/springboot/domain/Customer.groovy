package com.paradigma.springboot.domain


import grails.persistence.*

/**
 * Created by fcasau on 1/29/15.
 */
@Entity
public class Customer {

    String firstName;
    String lastName;

    static constraints = {
        firstName blank:false
        lastName blank:false
    }
    
    @Override
    String toString() {
        "Customer[id=$id, firstName=$firstName, lastName=$lastName"
    }

    
}
