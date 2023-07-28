package com.fcynnek.Assignment_14.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

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
	
	private List<Message> messages = new ArrayList<>();
	
//	public List<Message> getMessages(Integer channelId) {
//		Channel channel = channelRepo.findById(channelId).get();
//	    if (channel != null) {
//	        List<Message> existingMessages = channel.getMessages();
//	        return existingMessages;
//	    }
//		return messages;
//	}
	
	public List<Message> getMessages(Integer channelId) {
	    Optional<Channel> channelOptional = channelRepo.findById(channelId);
	    if (channelOptional.isPresent()) {
	        Channel channel = channelOptional.get();
	        return channel.getMessages();
	    } else {
	        // Handle the case when the channel is not found
	        // For example, you can throw an exception or return an empty list
	        throw new NoSuchElementException("Channel not found");
	        // Or return an empty list
	        // return Collections.emptyList();
	    }
	}


	public void createMessage(Message message, Integer channelId) {
	    Channel channel = channelRepo.findById(channelId).get();
	    if (channel != null) {
	        List<Message> existingMessages = channel.getMessages();
	        existingMessages.add(message);
	        channel.setMessages(existingMessages);
	    }
	}

	public List<Message> findAll() {
		return messageRepo.findAll();
	}

//	public Message save(String message) {
////		String savedMessage = messages.add(message);
//		
//		return messageRepo.save(message);
//	}

	public List<Message> save(List<Message> Messages) {
		List<Message> savedMessages = new ArrayList<>();
		for (Message message : Messages) {
			
//			savedMessage.setMessages(message);
			savedMessages.add(message);
		}
		return savedMessages;
	}
	
	
	
}
