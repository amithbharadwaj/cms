package com.amith.cms.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amith.cms.models.Response;
import com.amith.cms.models.User;
import com.amith.cms.service.ChannelService;
import com.amith.cms.service.JwtUtil;

@RestController
@RequestMapping("/user")
public class UserRestController {
	
	@Autowired
	private ChannelService channelService;
	
	@Autowired
    private JwtUtil jwtUtil;
	
	@GetMapping("/channels/{channelId}/feeds")
	public Response getChannelFeeds(HttpServletRequest request,
			@PathVariable("channelId") int channelId, 
			@RequestParam("pageSize") int pageSize) {
		return channelService.getChannelFeeds(request, channelId, pageSize);
	}
	
	@GetMapping("/")
	public User getUser(HttpServletRequest request) {
		return jwtUtil.getUserByRequest(request);
	}
	
}
