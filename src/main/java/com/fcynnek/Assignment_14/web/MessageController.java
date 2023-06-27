package com.fcynnek.Assignment_14.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.fcynnek.Assignment_14.domain.Message;
import com.fcynnek.Assignment_14.service.MessageService;

@Controller
public class MessageController {

	@Autowired
	private MessageService messageService;
	
	@GetMapping("/messages/{channelId}")
	public List<Message> getMessages(@PathVariable Integer channelId) {
		List<Message> channelMessages = messageService.getMessages(channelId);
        return channelMessages;
    }
	
	@PostMapping("/messages")
	public Message createMessage(@RequestBody Message message) {
        messageService.createMessage(message);
        return message;
    }
}
