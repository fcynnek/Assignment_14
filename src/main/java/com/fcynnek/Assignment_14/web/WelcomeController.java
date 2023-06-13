package com.fcynnek.Assignment_14.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.fcynnek.Assignment_14.domain.User;
import com.fcynnek.Assignment_14.service.UserService;

@Controller
public class WelcomeController {

	private UserService userService;
	private User userDomain;
	
	@GetMapping("/welcome")
	public String getUsername (ModelMap model) {
		User user = new User(userDomain.getUserId(), userDomain.getUsername());
//		userService.createUser(user);
		model.put("user", user);
		return "channels";
	}
}
