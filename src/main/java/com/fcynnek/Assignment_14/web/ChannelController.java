package com.fcynnek.Assignment_14.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpSession;

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
import org.springframework.web.servlet.ModelAndView;

import com.fcynnek.Assignment_14.domain.Channel;
import com.fcynnek.Assignment_14.domain.Message;
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
	public String getChannels (HttpSession session, ModelMap model) {
		String storedName = (String) session.getAttribute("name");
		if (storedName != null) {
			System.out.println("username: " + storedName);
			List<Channel> channels = channelService.findAll();
			Channel channel = new Channel();
			
			model.put("username", storedName);
			model.put("channels", channels);
			model.put("channel", channel);
			
			return "/channels";
		} else {
			System.out.println("no username");
			
			return "redirect:/welcome";
		}
	}
	
	@GetMapping("/channel/{channelId}")
	public String getChannel (HttpSession session, ModelMap model, @PathVariable Integer channelId) {
		Channel channel = channelService.findChannelById(channelId);
		
		model.addAttribute("channel", channel);
		model.addAttribute("channelId", channel.getChannelId());
		model.addAttribute("newMessage", new Message());
		
		return "chats";
	}
	
	
}
