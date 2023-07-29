package com.fcynnek.Assignment_14.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.fcynnek.Assignment_14.domain.Message;

@Component
public class MessageRepository {

	private List<Message> allMessages;
	
	public Message saveMessage (String messageText, String username) {
		Message message = new Message();
		message.setMessage(messageText);
		message.setUser(username);
		allMessages.add(message);
		return message;
	}
	
	public List<Message> allMessages() {
		return allMessages;
	}
}
