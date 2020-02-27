package com.amith.cms.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amith.cms.models.Channel;
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
			@RequestParam("pageNo") int pageNo,
			@RequestParam("pageSize") int pageSize) {
		return channelService.getChannelFeeds(request, channelId, pageNo, pageSize);
	}
	
	@GetMapping("")
	public User getUser(HttpServletRequest request) {
		return jwtUtil.getUserByRequest(request);
	}
	
	@GetMapping("/channels")
	public List<Channel> getUserChannels(HttpServletRequest request,
			@RequestParam("pageNo") int pageNo,
			@RequestParam("pageSize") int pageSize) {
		User user = jwtUtil.getUserByRequest(request);
		return channelService.getChannelByUser(user, pageNo, pageSize);
	}
	
}
