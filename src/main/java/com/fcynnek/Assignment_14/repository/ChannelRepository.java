package com.fcynnek.Assignment_14.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.fcynnek.Assignment_14.domain.Channel;

@Component
public class ChannelRepository {

	private Integer channelId = 0;
	private List<Channel> allChannels = new ArrayList<>();
	
	
	public Channel save(Channel channel) {
		Integer currentChannelId = channelId++;
		channel.setChannelId(currentChannelId);
		allChannels.add(channel);
		return channel;
	}


	public List<Channel> findAll() {
		return allChannels;
	}


	public Channel findById(Integer channelId) {
		for (Channel currentChannel : allChannels) {
			if (currentChannel.getChannelId() == channelId) {
				return currentChannel;
			}
		}
		return null;
	}
	
	
	
	
	
}
