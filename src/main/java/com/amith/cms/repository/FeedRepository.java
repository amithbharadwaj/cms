package com.amith.cms.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.amith.cms.models.Feed;

@Repository
public interface FeedRepository extends PagingAndSortingRepository<Feed, Integer> {
	
	@Override
	List<Feed> findAll();
	
	List<Feed> findByChannelId(int channelId, Pageable sortingAndPagination);

}
