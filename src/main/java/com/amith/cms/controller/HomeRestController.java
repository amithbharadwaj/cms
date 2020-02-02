package com.amith.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeRestController {

    @GetMapping("/")
    public String home() {
        return "home";
    }
    
}
