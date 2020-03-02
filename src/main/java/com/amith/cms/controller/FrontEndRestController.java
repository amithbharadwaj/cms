package com.amith.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FrontEndRestController {

    @GetMapping("/")
    public String index() {
        return "index";
    }
    
	@GetMapping("/registration")
	public String registration() {
	    return "registration";
	}
	
}
