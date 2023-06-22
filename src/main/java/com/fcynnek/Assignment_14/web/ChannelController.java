package com.fcynnek.Assignment_14.web;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.fcynnek.Assignment_14.domain.Channel;
import com.fcynnek.Assignment_14.service.ChannelService;

@Controller
public class ChannelController {

	@Autowired
	private ChannelService channelService;
	
	private Integer channelIdCounter = 1;

	@GetMapping("/channels")
	public String getChannels (ModelMap model) {
		HashMap<Integer, String> channels = channelService.findAll();
		model.put("channels", channels);
		return "channels";
	}
	
//	@PostMapping("/createChannel")
//	public String createChannel(ModelMap model) {
////		channelService.createNewChannel(null, null);
//		return "redirect:/channels";
//	}
	
	
	@PostMapping("/createChannel")
	public ResponseEntity<Channel> createChannel(@RequestBody String channelName) {
		Integer channelId = channelIdCounter++;
		
		Channel channel = channelService.createNewChannel(channelId, channelName);
		
		return ResponseEntity.ok(channel);
	}
}
