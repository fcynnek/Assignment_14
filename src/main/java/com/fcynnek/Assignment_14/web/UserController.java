package com.fcynnek.Assignment_14.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
	@ResponseBody
//	public User findUsername(@RequestParam("username") String username) {
	public User findUsername(@RequestBody String username) {
		User user = userService.findUserByUsername(username);
		if (user == null) {
			user = new User();
			user.setUsername(username);
			userService.createUser(username);
			return user;
		}
		
		return user;
	}
}
