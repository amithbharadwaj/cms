package com.amith.cms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amith.cms.models.Channel;
import com.amith.cms.models.User;
import com.amith.cms.service.ChannelService;
import com.amith.cms.service.MyUserDetailsService;

@RestController
@RequestMapping("/admin")
public class AdminRestController {

	@Autowired
	private ChannelService channelService;
	
	@Autowired
	private MyUserDetailsService userDetailsService;
	
	@PostMapping("/channels")
	public Channel addChannel(@RequestBody Channel channel) {
		return channelService.addChannel(channel);
	}
	
	@PutMapping("/channels/{channelId}")
	public Channel updateChannel(@PathVariable("channelId") int channelId, @RequestBody Channel channel) {
		return channelService.updateChannel(channelId, channel);
	}
	
	@GetMapping("/channels/{channelId}")
	public Channel getChannelById(@PathVariable("channelId") int channelId) {
		return channelService.getChannelById(channelId);
	}
	
	@DeleteMapping("/channels/{channelId}")
	public void deleteChannel(@PathVariable("channelId") int channelId) {
		channelService.deleteChannel(channelId);
	}
	
	@PutMapping("/channels/{channelId}/user/{userId}")
	public Channel updateChannelsUser(@PathVariable("channelId") int channelId, 
			@PathVariable("userId") int userId) {
		return channelService.updateChannelsUser(channelId, userId);
	}
	
	@GetMapping("/user/{userId}")
	public User getUserById(@PathVariable("userId") int userId) {
		return userDetailsService.getUserByUserId(userId);
	}
}
