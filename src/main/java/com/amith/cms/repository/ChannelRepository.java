package com.amith.cms.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.amith.cms.models.Channel;

@Repository
public interface ChannelRepository extends PagingAndSortingRepository<Channel, Integer> {
	
	@Override
	List<Channel> findAll();
	
	List<Channel> findByUser(int userId, Pageable sortingAndPagination);

}
