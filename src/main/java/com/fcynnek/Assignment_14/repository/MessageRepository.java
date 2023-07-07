package com.fcynnek.Assignment_14.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Component;

import com.fcynnek.Assignment_14.domain.Channel;
import com.fcynnek.Assignment_14.domain.Message;
import com.fcynnek.Assignment_14.domain.User;

@Component
public class MessageRepository {

	private List<Message> messages = new ArrayList<>();
	
	public List<Message> findAllMessages () {
//		List<Message> messagesByChannel = messages.get(channelId);
		return messages;
	}
	
	public String saveMessages () {
		Message message = new Message();
		User user = new User();
		
		String username = user.getUsername();
		List<String> newMessages = user.getMessages();
		
//		messages.add(newMessages.indexOf(1), message);
		return messages.add(new)
	}
}
