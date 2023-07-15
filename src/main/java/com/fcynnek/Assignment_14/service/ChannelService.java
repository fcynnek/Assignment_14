package com.fcynnek.Assignment_14.service;

import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fcynnek.Assignment_14.domain.Channel;
import com.fcynnek.Assignment_14.repository.ChannelRepository;
import com.fcynnek.Assignment_14.repository.MessageRepository;

@Service
public class ChannelService {

	@Autowired
	private ChannelRepository channelRepo;
	
	@Autowired
    private MessageRepository messageRepo;
	
	private Integer channelIdCounter = 0;
	
//	public HashMap<Integer,Channel> findAll() {
//		return channelRepo.findAll();
//	}
	public List<Channel> findAll() {
		return channelRepo.findAll();
	}
	
	public Channel createNewChannel(String channelName) {
		Channel channel = new Channel();
//		Integer channelId = channelIdCounter++;
//		channel.setChannelId(channelId);
		channel.setChannelName(channelName);
//		channelRepo.save(channelId, channelName);
		return channelRepo.save(channel);
	}
	
	public Channel findChannelById(Integer channelId) {
		System.out.println("Channel ID: " + channelId);
		return channelRepo.findById(channelId)
				.orElseThrow(() -> new NoSuchElementException("Channel not found"));
	}

	public Channel saveChannel(Channel channel) {
		return channelRepo.save(channel);
	}
	
	
}
