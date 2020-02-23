package com.amith.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.amith.cms.models.AuthenticationRequest;

@Controller
public class FrontEndRestController {

    @GetMapping("/")
    public String index(AuthenticationRequest authenticationRequest) {
        return "index";
    }
}
