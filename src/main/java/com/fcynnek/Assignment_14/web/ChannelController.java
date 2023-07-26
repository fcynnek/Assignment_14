package com.fcynnek.Assignment_14.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fcynnek.Assignment_14.domain.Channel;
import com.fcynnek.Assignment_14.domain.User;
import com.fcynnek.Assignment_14.service.ChannelService;
import com.fcynnek.Assignment_14.service.MessageService;
import com.fcynnek.Assignment_14.service.UserService;

@Controller
public class ChannelController {

	@Autowired
	private ChannelService channelService;
	
	@Autowired
	private MessageService messageService;
	
	@Autowired
    private UserService userService;
	

	@GetMapping("/channels")
	public String getChannels (ModelMap model) {
		List<Channel> channels = channelService.findAll();
		List<User> users = userService.getAllUsers();
		
		if (users.isEmpty()) {
			return "redirect:/welcome";
		}		
		if (channels.isEmpty()) {
			model.addAttribute("noChannels", true);
		}
		model.put("channels", channels);
		return "channels";
	}
	

//	@PostMapping("/createChannel")
//	public String createChannel(@RequestParam("channelName") String channelName) {
//		
//		channelService.createNewChannel(channelName);
//		return "redirect:/channels";
//	}
	
	@PostMapping("/channels")
	@ResponseBody
	public Channel createChannel(@RequestBody Channel channelName) throws JsonProcessingException {
		Channel channel = channelService.createNewChannel(channelName);
		System.out.println("POST: " + channelName);
		return channel;
	}
	
}
