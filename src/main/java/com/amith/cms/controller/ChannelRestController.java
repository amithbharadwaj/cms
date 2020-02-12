package com.amith.cms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	public Channel addChannel(@RequestBody Channel Channel) {
		return channelService.addChannel(Channel);
	}
	
	@GetMapping("/{ChannelId}")
	public Channel getChannelById(@PathVariable("ChannelId") int ChannelId) {
		return channelService.getChannelById(ChannelId);
	}
	
	@PostMapping("/{ChannelId}/feeds")
	public void addChannelFeeds(@RequestBody Feed feed) {
		channelService.addChannelFeeds(feed);
	}
	
	@GetMapping("/{ChannelId}/feeds")
	public Response getChannelFeeds(@PathVariable("ChannelId") int ChannelId, 
			@RequestParam("pageSize") String pageSize) {
		return channelService.getChannelFeeds(ChannelId, pageSize);
	}
	
	@DeleteMapping("/{ChannelId}")
	public void deleteChannel(@PathVariable("ChannelId") int ChannelId) {
		channelService.deleteChannel(ChannelId);
	}
}
