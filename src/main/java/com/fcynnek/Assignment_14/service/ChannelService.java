package com.fcynnek.Assignment_14.service;

import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;

import javax.servlet.http.HttpSession;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fcynnek.Assignment_14.domain.Channel;
import com.fcynnek.Assignment_14.repository.ChannelRepository;
import com.fcynnek.Assignment_14.repository.MessageRepository;

@Service
public class ChannelService {

	@Autowired
	private ChannelRepository channelRepo;
	
	@Autowired
    private MessageRepository messageRepo;
	
	
	
//	public HashMap<Integer,Channel> findAll() {
//		return channelRepo.findAll();
//	}
	public List<Channel> findAll() {
		return channelRepo.findAll();
	}
	
	public Channel createNewChannel(Channel channelName) throws JsonProcessingException {
		Channel channel = new Channel();
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(channelName);
		channel.setChannelName(json);

		return channelRepo.save(channel);
	}
	
	public Channel findChannelById(Integer channelId) {
		System.out.println("Channel ID: " + channelId);
		return channelRepo.findById(channelId).get();
//				.orElseThrow(() -> new NoSuchElementException("Channel not found"));
	}

	public Channel saveChannel(Channel channel) {
		return channelRepo.save(channel);
	}
	
	
}
