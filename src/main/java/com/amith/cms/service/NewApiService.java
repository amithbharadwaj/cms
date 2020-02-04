package com.amith.cms.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.amith.cms.models.Response;

@Service
public class NewApiService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	public Response getFeeds(int channelId, int pageSize) {
		Response response = new Response();
		final String uri = "https://api.thingspeak.com/channels/{channelId}/feeds.json?api_key=E65ADORJN3PVGCAQ&results={pageSize}";
	     
	    Map<String, String> params = new HashMap<String, String>();
	    params.put("channelId", Integer.toString(channelId));
	    params.put("pageSize", Integer.toString(pageSize));
	     
	    response = restTemplate.getForObject(uri, Response.class, params);
	     
	    System.out.println(response);
		return response;
	}

}
