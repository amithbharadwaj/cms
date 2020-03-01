package com.amith.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.amith.cms.models.AuthenticationRequest;
import com.amith.cms.models.RegistrationRequest;

@Controller
public class FrontEndRestController {

    @GetMapping("/")
    public String index(AuthenticationRequest authenticationRequest) {
        return "index";
    }
    
	@GetMapping("/register")
	public String register(RegistrationRequest user) {
	    return "register";
	}
}
