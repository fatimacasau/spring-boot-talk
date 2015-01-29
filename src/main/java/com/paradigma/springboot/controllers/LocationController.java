package com.paradigma.springboot.controllers;

import groovy.json.JsonSlurper;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by fcasau on 1/29/15.
 */

@RestController
@ConfigurationProperties(prefix = "api")
public class LocationController {
    
    String url;
    
    String uri;
    
    String param;
    
    String defaultValue;
    
    @RequestMapping(value="/location", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Map> findCityLocalization(
            @RequestParam(value = "city", required = false) String city
    ){
        if(city==null || "".equals(city)) city = defaultValue;
        Map result = new RestTemplate().getForObject(url+uri+"?"+param+"="+city, Map.class);
        return new ResponseEntity<Map>(result, HttpStatus.OK);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }
}
