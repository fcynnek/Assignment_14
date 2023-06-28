package com.fcynnek.Assignment_14.repository;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Component;

import com.fcynnek.Assignment_14.domain.Channel;
import com.fcynnek.Assignment_14.domain.Message;

@Component
public class MessageRepository {

	private HashMap<Integer, List<Message>> messages = new HashMap<>();
	
	public List<Message> findAllMessages (Channel channelId) {
		List<Message> messagesByChannel = messages.get(channelId);
		return messagesByChannel;
	}
	
	public void saveMessages (Integer channelId, List<Message> messagesByChannel) {
		messages.put(channelId, messagesByChannel);
	}
}
