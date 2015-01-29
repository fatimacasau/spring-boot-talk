package com.paradigma.springboot.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

/**
 * Created by fcasau on 1/29/15.
 */
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    long id;
    String firstName;
    String lastName;

    @Override
    String toString() {
        "Customer[id=$id, firstName=$firstName, lastName=$lastName"
    }

}
