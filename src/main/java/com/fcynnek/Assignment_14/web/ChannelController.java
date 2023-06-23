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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
	

	@PostMapping("/createChannel")
	public String createChannel(@RequestBody String channelName) {
//	public String createChannel(@RequestParam("channelName") String channelName) {
		Integer channelId = channelIdCounter++;
		
		channelService.createNewChannel(channelId, channelName);
		return "redirect:/channels";
	}
}
