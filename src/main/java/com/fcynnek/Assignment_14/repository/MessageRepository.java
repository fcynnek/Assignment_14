package com.fcynnek.Assignment_14.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.IntFunction;

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
	
	public void saveMessages (List<String> newMessages) {
		User user = new User();
		String username = user.getUsername();
		
		for (String messageText : newMessages) {
			Message message = new Message();
			message.setUsername(username);
			message.setMessage(messageText);
			
		}

		
//		messages.add(newMessages.indexOf(1), message);
//		return messages.add((Message) newMessages);
	}
	
	public void saveMessage (String message) {
		User user = new User();
        String username = user.getUsername();

        Message newMessage = new Message();
        newMessage.setUsername(username);
        newMessage.setMessage(message);
        messages.add(newMessage);
	}
}
