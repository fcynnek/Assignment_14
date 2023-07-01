package com.fcynnek.Assignment_14.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fcynnek.Assignment_14.domain.Channel;
import com.fcynnek.Assignment_14.domain.Message;
import com.fcynnek.Assignment_14.service.ChannelService;
import com.fcynnek.Assignment_14.service.MessageService;
import com.google.gson.Gson;

@Controller
public class MessageController {

	@Autowired
	private MessageService messageService;
	
	@Autowired
	private ChannelService channelService;

	
	@GetMapping("/channels/{channelId}")
	public String getMessages(@PathVariable Integer channelId, ModelMap model, HttpSession session) {
	
		Channel channel = channelService.findChannelById(channelId);
		List<Message> channelMessages = messageService.getMessages(channelId);
		session.setAttribute("channel", channel);
		session.setAttribute("channelMessages", channelMessages);
		
		model.put("channel", channel);
		model.put("channelMessages", channelMessages);
		
		return "chats";
	}
	
	
	@PostMapping("/channels/{channelId}")
	@ResponseBody
	public ResponseEntity<String> createMessage(@RequestBody String message, @PathVariable Integer channelId, HttpSession session) {
		Message newMessage = new Message();
		newMessage.setMessage(message);
		messageService.createMessage(newMessage, channelId);
		
		Channel channel = (Channel) session.getAttribute("channel");
		List<Message> channelMessages = (List<Message>) session.getAttribute("channelMessages");
		
		Gson gson = new Gson();
		String jsonMessage = gson.toJson(newMessage);
		
		return ResponseEntity.status(HttpStatus.CREATED)
	            .contentType(MediaType.APPLICATION_JSON)
	            .body(jsonMessage);
    }
}
