package com.fcynnek.Assignment_14.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.fcynnek.Assignment_14.domain.User;
import com.fcynnek.Assignment_14.service.ChannelService;
import com.fcynnek.Assignment_14.service.UserService;

@Controller
public class WelcomeController {

	@Autowired
	private ChannelService channelService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/welcome")
	public String getUsername (ModelMap model, String username) {
		User user = userService.createUser(username);
		model.put("user", user);
		return "welcome";
//		return "redirect:/channels";
	}
	
	
}
