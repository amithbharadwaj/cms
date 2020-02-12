package com.amith.cms.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.amith.cms.models.Channel;

@Repository
public interface ChannelRepository extends CrudRepository<Channel, Integer> {
	
	@Override
	List<Channel> findAll();

}
