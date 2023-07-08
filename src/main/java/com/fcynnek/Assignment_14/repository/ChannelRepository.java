package com.fcynnek.Assignment_14.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Component;

import com.fcynnek.Assignment_14.domain.Channel;
import com.fcynnek.Assignment_14.domain.User;

@Component
public class ChannelRepository {

	private List<Channel> channels = new ArrayList<>();
	private List<User> users = new ArrayList<>();
	
//	public HashMap<Integer, Channel> findAll() {
//		return channels;
//	}
	public List<Channel> findAll() {
		return channels;
	}
	
	public Channel saveChannel(Integer channelId, String channelName) {
		Channel channel = new Channel();
		channel.setChannelId(channelId);
		channel.setChannelName(channelName);
		channels.add(channelId, channel);
		return channel;
	}
	
	public Channel findChannelById (Integer channelId) {
		return channels.get(channelId);
	}

//	public Channel save(Channel channel) {
//		return ((Object) channels).put(channel);
//	}
}
