package com.paradigma.springboot

import com.paradigma.springboot.domain.Customer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.SpringApplicationContextLoader
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created by fcasau on 1/29/15.
 */
@ContextConfiguration(loader = SpringApplicationContextLoader,classes = [Application.class])
class CustomerSpec extends Specification {


    @Unroll
    void "add new Customer with params #params"(){
        expect: "result when save new object with diferent params"
            result == !new Customer(params).save(flush: true)
        where: "params are...result is..."
            result || params
            false   || [firstName:'first', lastName:'last']
            true    || [:]
    }

}