package com.fcynnek.Assignment_14.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fcynnek.Assignment_14.domain.User;
import com.fcynnek.Assignment_14.service.ChannelService;
import com.fcynnek.Assignment_14.service.UserService;

@Controller
public class UserController {

	@Autowired
	private ChannelService channelService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private HttpSession session;
	
	@GetMapping("/")
	public String getWelcome() {
		return "redirect:/welcome";
	}
	
	@GetMapping("/welcome")
	public String getUsername (ModelMap model, String username) {
		User user = userService.createUser(username);
		model.put("user", user);
		return "welcome";
	}
	
	@PostMapping("/welcome")
	public String postUsername (@RequestParam("username") String username) {
//        User user = userService.createUser(username);
        session.setAttribute("user", username);
        return "redirect:/channels";
	}
}