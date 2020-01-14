package com.amith.cms.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloworld  {

    @RequestMapping(value="/hello")
    public String sayhello(){

        return "Hello World";
    }
}
