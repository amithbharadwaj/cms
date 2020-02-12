package com.amith.cms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amith.cms.exception.ChannelNotFoundException;
import com.amith.cms.models.Channel;
import com.amith.cms.models.Feed;
import com.amith.cms.models.Response;
import com.amith.cms.repository.ChannelRepository;

@Service
public class ChannelService {
	
	@Autowired
	private ChannelRepository channelRepository;

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

	public void addChannelFeeds(Feed feed) {
	}

	public Response getChannelFeeds(int channelId, String pageSize) {
		return null;
	}

}
