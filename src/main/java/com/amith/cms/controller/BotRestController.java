package com.amith.cms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amith.cms.models.Feed;
import com.amith.cms.service.ChannelService;

@RestController
@RequestMapping("/bot")
public class BotRestController {
	
	@Autowired
	private ChannelService channelService;
	
	@PostMapping("/channels/{channelId}/feeds")
	public Feed addChannelFeeds(@PathVariable("channelId") int channelId, @RequestBody Feed feed) {
		return channelService.addChannelFeeds(channelId, feed);
	}

}
