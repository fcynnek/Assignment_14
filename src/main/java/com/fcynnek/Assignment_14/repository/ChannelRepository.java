package com.fcynnek.Assignment_14.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fcynnek.Assignment_14.domain.Channel;

@Repository
public interface ChannelRepository extends JpaRepository<Channel, Integer>{

	
}
