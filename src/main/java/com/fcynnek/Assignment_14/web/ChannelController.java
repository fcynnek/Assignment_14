package com.fcynnek.Assignment_14.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.fcynnek.Assignment_14.domain.Channel;
import com.fcynnek.Assignment_14.service.ChannelService;

@Controller
public class ChannelController {

	@Autowired
	private ChannelService channelService;
	
	@GetMapping("/channels")
	public String getChannels (ModelMap model) {
		List<Channel> channels = channelService.findAll();
		model.put("channels", channels);
		return "channels";
	}
}
