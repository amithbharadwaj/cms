package com.amith.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import io.micrometer.core.instrument.util.StringUtils;

@Controller
public class FrontEndRestController {

    @GetMapping("/{pageName}")
    public String index(@PathVariable("pageName") String pageName) {
    	System.out.print("FrontEndRestController: pageName="+pageName);
    	if (StringUtils.isBlank(pageName)) {
    		return "index";
    	} else {
    		return pageName;
    	}
    }
    
}
