package com.paradigma.springboot.controllers

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.web.bind.annotation.*
import org.springframework.web.client.RestTemplate

/**
 * Created by fcasau on 1/29/15.
 */
@RestController
@ConfigurationProperties(prefix = "api")
public class LocationController {

    String url

    String uri

    String param

    String defaultValue

    @RequestMapping(value = "/location", method = RequestMethod.GET)
    @ResponseBody
    def findCityLocalization(
            @RequestParam(value = "city", required = false) String city
    ) {
        city = city ?: defaultValue
        new RestTemplate().getForObject("$url$uri?$param=$city", Map.class)
    }

    public String getUrl() {
        url
    }

    public void setUrl(String url) {
        this.url = url
    }

    public String getUri() {
        uri
    }

    public void setUri(String uri) {
        this.uri = uri
    }

    public String getParam() {
        param
    }

    public void setParam(String param) {
        this.param = param
    }

    public String getDefaultValue() {
        defaultValue
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue
    }

}