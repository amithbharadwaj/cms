package com.amith.cms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.amith.cms.exception.ChannelNotFoundException;
import com.amith.cms.models.Channel;
import com.amith.cms.models.Feed;
import com.amith.cms.models.Response;
import com.amith.cms.repository.ChannelRepository;
import com.amith.cms.repository.FeedRepository;

@Service
public class ChannelService {
	
	@Autowired
	private ChannelRepository channelRepository;
	
	@Autowired
	private FeedRepository feedRepository;

	public Channel getChannelById(int channelId) {
		Optional<Channel> optionalChannel = channelRepository.findById(channelId);
		if (!optionalChannel.isPresent())
			throw new ChannelNotFoundException("Channel not found..");
		return optionalChannel.get();
	}
	
	public Channel addChannel(Channel channel) {
		return channelRepository.save(channel);
	}
	
	public void deleteChannel(int channelId) {
		channelRepository.deleteById(channelId);
	}

	public Feed addChannelFeeds(Feed feed) {
		Channel channel = getChannelById(feed.getChannelId());
		return feedRepository.save(feed);
	}

	public Response getChannelFeeds(int channelId, int pageSize) {
		Channel channel = getChannelById(channelId);
		Pageable sortingAndPagination = 
				  PageRequest.of(0, pageSize == 0 ? 10 : pageSize , Sort.by("createdAt").descending());
		List<Feed> feeds = feedRepository.findByChannelId(channelId, sortingAndPagination);
		Response response = new Response();
		response.setChannel(channel);
		response.setFeeds(feeds);
		return response;
	}

}
