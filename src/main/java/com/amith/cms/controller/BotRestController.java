package com.amith.cms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amith.cms.models.Feed;
import com.amith.cms.service.ChannelService;

@RestController
@RequestMapping("")
public class BotRestController {
	
	@Autowired
	private ChannelService channelService;
	
	@PostMapping("/update")
	public Feed addChannelFeeds(@RequestParam("apiKey") String apiKey, @RequestParam String field1,
			@RequestParam(required = false) String field2, @RequestParam(required = false) String field3, 
			@RequestParam(required = false) String field4, @RequestParam(required = false) String field5, 
			@RequestParam(required = false) String field6, @RequestParam(required = false) String field7,
			@RequestParam(required = false) String field8) {
		
		Feed feed = new Feed();
		feed.setField1(field1);
		feed.setField2(field2);
		feed.setField3(field3);
		feed.setField4(field4);
		feed.setField5(field5);
		feed.setField6(field6);
		feed.setField7(field7);
		feed.setField8(field8);
		return channelService.addChannelFeeds(apiKey, feed);
	}

}
