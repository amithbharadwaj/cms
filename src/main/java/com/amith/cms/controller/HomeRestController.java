package com.amith.cms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.amith.cms.models.Request;
import com.amith.cms.service.NewApiService;

@Controller
public class HomeRestController {
	
	@Autowired
	private NewApiService newApiService;

    @GetMapping("/")
    public String home(Request request) {
        return "home";
    }
    
    @PostMapping("/channelDetails")
    public String channelDetails(Model model, @ModelAttribute Request request) {
    	model.addAttribute("response", 
    			newApiService.getFeeds(request.getChannelId(), request.getPageSize()));
        return "channelDetails";
    }
    
}
