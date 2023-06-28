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
	
//	public HashMap<Integer,Channel> findAll() {
//		return channelRepo.findAll();
//	}
	public List<Channel> findAll() {
		return channelRepo.findAll();
	}
	
	public Channel createNewChannel(Integer channelId, String channelName) {
		Channel channel = new Channel();
		channel.setChannelId(channelId);
		channel.setChannelName(channelName);
		channelRepo.saveChannel(channelId, channelName);
		return channel;
	}
	
	public Channel findChannelById(Channel channelId) {
		return channelRepo.findChannelById(channelId);
	}

	
}
