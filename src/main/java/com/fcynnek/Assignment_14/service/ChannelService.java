package com.fcynnek.Assignment_14.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fcynnek.Assignment_14.domain.Channel;
import com.fcynnek.Assignment_14.repository.ChannelRepository;

@Service
public class ChannelService {

	@Autowired
	private ChannelRepository channelRepo;
	
	public HashMap<Integer, String> findAll() {
		return channelRepo.findAll();
	}
	
	public Channel createNewChannel(Integer channelId, String channelName) {
		channelRepo.saveChannel(channelId, channelName);
		return new Channel();
	}
	
	public String findChannelById(Integer channelId) {
		return channelRepo.findChannelById(channelId);
	}
}
