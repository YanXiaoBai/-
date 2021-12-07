package com.smw.ConsumerDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class Controller {
    @Autowired
    private RestTemplate restTemplate;
    @GetMapping("/callHello")
    public String callHello() {
        return "I called sayHello and the result is: " + restTemplate.getForObject("http://service-client/sayHello", String.class);
    }
}