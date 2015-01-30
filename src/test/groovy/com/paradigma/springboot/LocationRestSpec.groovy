package com.paradigma.springboot

import org.springframework.boot.test.SpringApplicationContextLoader
import org.springframework.http.HttpStatus
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification
import  groovyx.net.http.RESTClient

/**
 * Created by fcasau on 1/29/15.
 */
@ContextConfiguration(loader = SpringApplicationContextLoader,classes = [Application.class])
class LocationRestSpec extends Specification{
    
    void "test call rest location services"(){
        setup: 
            def rest = new RESTClient("https://maps.googleapis.com")
            def uri = "/maps/api/geocode/json"
        when:
            def result = rest.get(path: uri, query: [address:'talarrubias'])
        then:
            result
            result.status == HttpStatus.OK.value()
            result.data.toString().contains('Talarrubias')
        
    }
}
