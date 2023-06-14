package com.fcynnek.Assignment_14.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fcynnek.Assignment_14.domain.Channel;
import com.fcynnek.Assignment_14.repository.ChannelRepository;

@Service
public class ChannelService {

	@Autowired
	private ChannelRepository channelRepo;
	
	public List<Channel> findAll() {
		return channelRepo.findAll();
	}
	
}
