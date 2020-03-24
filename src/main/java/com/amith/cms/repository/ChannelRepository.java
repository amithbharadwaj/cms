package com.amith.cms.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.amith.cms.models.Channel;
import com.amith.cms.models.User;

@Repository
public interface ChannelRepository extends PagingAndSortingRepository<Channel, Integer> {
	
	@Override
	List<Channel> findAll();
	
	List<Channel> findByUser(User user, Pageable sortingAndPagination);
	
	Optional<Channel> findByApiKey(String apiKey);

}
