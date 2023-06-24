package com.fcynnek.Assignment_14.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Component;

import com.fcynnek.Assignment_14.domain.Channel;

@Component
public class ChannelRepository {

	private HashMap<Integer, Channel> channels = new HashMap<>();
	
//	public HashMap<Integer, Channel> findAll() {
//		return channels;
//	}
	public List<Channel> findAll() {
		return new ArrayList<>(channels.values());
	}
	
	public Channel saveChannel(Integer channelId, String channelName) {
		Channel channel = new Channel();
		channel.setChannelId(channelId);
		channel.setChannelName(channelName);
		channels.put(channelId, channel);
		return channel;
	}
	
	public Channel findChannelById (Integer channelId) {
		return channels.get(channelId);
	}
}
