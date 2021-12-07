package com.smw.ProducerDemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping(value = "/sayHello")
    public String getString(){
        return "Hello-World";
    }

}