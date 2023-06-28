package com.fcynnek.Assignment_14.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fcynnek.Assignment_14.domain.Channel;
import com.fcynnek.Assignment_14.domain.Message;
import com.fcynnek.Assignment_14.repository.ChannelRepository;
import com.fcynnek.Assignment_14.repository.MessageRepository;

@Service
public class MessageService {

	@Autowired
	private MessageRepository messageRepo;
	
	@Autowired
	private ChannelRepository channelRepo;
	
	public List<Message> getMessages(Channel channelId) {
		return messageRepo.findAllMessages(channelId);
	}

	public void createMessage(Message message, Channel channelId) {
		List<Message> existingMessages = getMessages(channelId);
		existingMessages.add(message);
	}
	
}
