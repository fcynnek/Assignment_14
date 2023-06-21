package com.fcynnek.Assignment_14.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Component;

import com.fcynnek.Assignment_14.domain.Channel;

@Component
public class ChannelRepository {

//	List<Channel> channels = new ArrayList<>();
	HashMap<Integer, String> channels = new HashMap<>();
	
	public HashMap<Integer, String> findAll() {
		return channels;
	}
	
	public String saveChannel(Integer channelId, String channelName) {
		String newChannel = channels.put(channelId, channelName);
		return newChannel;
	}
	
	public String findChannelById (Integer channelId) {
		return channels.get(channelId);
	}
}
