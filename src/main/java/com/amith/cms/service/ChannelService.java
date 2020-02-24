package com.amith.cms.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.amith.cms.exception.ChannelNotFoundException;
import com.amith.cms.models.Channel;
import com.amith.cms.models.Feed;
import com.amith.cms.models.Response;
import com.amith.cms.models.User;
import com.amith.cms.repository.ChannelRepository;
import com.amith.cms.repository.FeedRepository;

@Service
public class ChannelService {
	
	@Autowired
	private ChannelRepository channelRepository;
	
	@Autowired
	private FeedRepository feedRepository;
	
	@Autowired
	private MyUserDetailsService userDetailsService;
	
	@Autowired
	private JwtUtil jwtUtil;

	public Channel getChannelById(int channelId) {
		Optional<Channel> optionalChannel = channelRepository.findById(channelId);
		if (!optionalChannel.isPresent())
			throw new ChannelNotFoundException("Channel not found..");
		return optionalChannel.get();
	}
	
	public Channel addChannel(Channel channel) {
		channel.setCreatedAt(new Date());
		channel.setUpdatedAt(new Date());
		channel.setLastEntryId(0);
		return channelRepository.save(channel);
	}
	
	public Channel updateChannel(int channelId, Channel channel) {
		channel.setId(channelId);
		return channelRepository.save(channel);
	}
	
	public void deleteChannel(int channelId) {
		channelRepository.deleteById(channelId);
	}

	public Feed addChannelFeeds(int channelId, Feed feed) {
		Channel channel = getChannelById(channelId);
		
		feed.setChannelId(channelId);
		feed.setCreatedAt(new Date());
		Feed feed1 = feedRepository.save(feed);
		
		channel.setUpdatedAt(new Date());
		channel.setLastEntryId(feed1.getId());
		channelRepository.save(channel);
		
		return feed1;
	}

	public Response getChannelFeeds(HttpServletRequest request, int channelId, int pageSize) {
		Channel channel = getChannelById(channelId);
		if (channel.getUser().getId() != jwtUtil.getUserByRequest(request).getId()) {
			throw new ChannelNotFoundException("Not found");
		}
		Pageable sortingAndPagination = 
				  PageRequest.of(0, pageSize == 0 ? 10 : pageSize , Sort.by("createdAt").descending());
		List<Feed> feeds = feedRepository.findByChannelId(channelId, sortingAndPagination);
		Response response = new Response();
		response.setChannel(channel);
		response.setFeeds(feeds);
		return response;
	}
	
	public List<Channel> getChannelByUser(int userId, int pageSize) {
		Pageable sortingAndPagination = 
				  PageRequest.of(0, pageSize == 0 ? 10 : pageSize , Sort.by("createdAt").descending());
		return channelRepository.findByUser(userId, sortingAndPagination);
	}

	public Channel updateChannelsUser(int channelId, int userId) {
		Channel channel = getChannelById(channelId);
		User user = null;
		if (userId > 0) {
			user = userDetailsService.getUserByUserId(userId);
		}
		channel.setUser(user);
		return channelRepository.save(channel);
	}

}
