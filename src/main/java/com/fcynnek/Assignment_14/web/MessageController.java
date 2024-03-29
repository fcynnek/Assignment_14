package com.fcynnek.Assignment_14.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.HttpServletBean;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fcynnek.Assignment_14.domain.Channel;
import com.fcynnek.Assignment_14.domain.Message;
import com.fcynnek.Assignment_14.domain.MessageRequest;
import com.fcynnek.Assignment_14.domain.User;
import com.fcynnek.Assignment_14.service.ChannelService;
import com.fcynnek.Assignment_14.service.MessageService;
import com.fcynnek.Assignment_14.service.UserService;

@Controller
public class MessageController {

	@Autowired
	private MessageService messageService;

	@Autowired
	private ChannelService channelService;

	@Autowired
	private UserService userService;



	@GetMapping("/channels/{channelId}")
//	@ResponseBody
	public String getChannelMessages(@PathVariable Integer channelId, ModelMap model, HttpSession session) {
		List<User> users = userService.getAllUsers();
		List<Message> messages = messageService.getMessages(channelId);
		model.addAttribute("messages", messages);
		model.addAttribute("channelId", channelId);
		model.addAttribute("users", users);
		return "chats";
	}
	
	@PostMapping("/channel/{channelId}")
	@ResponseBody
	public Message sendMessage(@PathVariable Integer channelId, @RequestBody Message message) {
//	public Message sendMessage(@PathVariable Integer channelId,
//			@RequestParam("message") Message message, @RequestParam("user") User user) {
		Channel channel = channelService.findChannelById(channelId);
		Message chat = new Message();
		
		chat.addMessage(message);
		chat.setChannel(channel);
//		chat.setUser(user);
		channel.getMessages().add(chat);
		channelService.saveChannel(channel);
		System.out.println(message);
		return chat;
	}
	

}
//	@GetMapping("/channel/{channelId}")
//	@ResponseBody
//	public List<Message> getMessages(@PathVariable Integer channelId) {
//		Channel channel = channelService.findChannelById(channelId);
//		return channel.getMessages();
//	}

//	@PostMapping("/channels/{channelId}")
//	public ResponseEntity<String> sendMessage(@PathVariable Integer channelId,
//			@RequestParam("message") String message,
//			@RequestParam("user") String username) {
//		Channel currentChannelName = channelService.findChannelById(channelId);
//		User user = userService.findByUsername(username);
//
//			Message chatMessage = new Message();
//			chatMessage.setMessage(message);
//			chatMessage.setChannel(currentChannelName);
//			chatMessage.setUser(user);
//			channelService.saveChannel(currentChannelName);
//
//		return ResponseEntity.status(HttpStatus.OK).body("{\"status\":\"success\"}");
//
//	}
	
	// Pete: make a dummy piece to be used to take data and send a system out
//	@RestController
//	public class PairController {
//		
//		@GetMapping("/play")
//		public String play() {
//			return "hi";
//		}
//	}
	
	
	
	/*
	 * message request object from js to java You can try to send an object with a
	 * username and messages [array of strings]
	 * 
	 * Try not to expect string in java
	 * 
	 * Oğulcan Kendirci: You are not sending an object You are sending a stringified
	 * array
	 * 
	 * Your Message POJO class should have exactly the same properties with the
	 * object that you send from your JS Parse not stringify
	 * 
	 * Rebecca: Message domain should have username as a string so that when you
	 * fetch everything for the first time you can check if the user already exists
	 * in the sessionStorage
	 * 
	 * look at spoonacular send quser:1 message instead of array
	 * 
	 * you should have a list for messages in your channel domain
	 */

