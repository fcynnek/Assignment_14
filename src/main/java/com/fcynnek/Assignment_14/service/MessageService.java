package com.fcynnek.Assignment_14.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fcynnek.Assignment_14.domain.Channel;
import com.fcynnek.Assignment_14.domain.Message;
import com.fcynnek.Assignment_14.domain.User;
import com.fcynnek.Assignment_14.repository.ChannelRepository;
import com.fcynnek.Assignment_14.repository.MessageRepository;

@Service
public class MessageService {

	@Autowired
	private MessageRepository messageRepo;
	
	@Autowired
	private ChannelRepository channelRepo;
	
	@Autowired
	private UserService userService;
	
	public List<Message> getMessages(Integer channelId) {
		return messageRepo.findAllMessages(channelId);
	}

	public void createMessage(Message message, Integer channelId) {
	    Channel channel = channelRepo.findChannelById(channelId);
	    if (channel != null) {
	        List<Message> existingMessages = channel.getMessages();
	        
//	        User user = new User(userId, displayName);
//	        user.setUsername(displayName);
	        
//	        message.setUser(user); 
	        existingMessages.add(message);
	        channel.setMessages(existingMessages);
	    }
	}

	
}
