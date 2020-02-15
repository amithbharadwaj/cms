package com.amith.cms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amith.cms.models.Channel;
import com.amith.cms.models.Feed;
import com.amith.cms.models.Response;
import com.amith.cms.service.ChannelService;

@RestController
@RequestMapping("/channels")
public class ChannelRestController {

	@Autowired
	private ChannelService channelService;
	
	@PostMapping("/")
	public Channel addChannel(@RequestBody Channel channel) {
		return channelService.addChannel(channel);
	}
	
	@PutMapping("/{channelId}")
	public Channel updateChannel(@PathVariable("channelId") int channelId, @RequestBody Channel channel) {
		return channelService.updateChannel(channelId, channel);
	}
	
	@GetMapping("/{channelId}")
	public Channel getChannelById(@PathVariable("channelId") int channelId) {
		return channelService.getChannelById(channelId);
	}
	
	@DeleteMapping("/{channelId}")
	public void deleteChannel(@PathVariable("channelId") int channelId) {
		channelService.deleteChannel(channelId);
	}
	
	
	
	@PostMapping("/{channelId}/feeds")
	public Feed addChannelFeeds(@PathVariable("channelId") int channelId, @RequestBody Feed feed) {
		return channelService.addChannelFeeds(channelId, feed);
	}
	
	@GetMapping("/{channelId}/feeds")
	public Response getChannelFeeds(@PathVariable("channelId") int channelId, 
			@RequestParam("pageSize") int pageSize) {
		return channelService.getChannelFeeds(channelId, pageSize);
	}
	
	
}
