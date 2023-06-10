package com.fcynnek.Assignment_14.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.fcynnek.Assignment_14.domain.User;

@Controller
public class WelcomeController {

	@GetMapping("/welcome")
	public String getUsername (ModelMap model) {
		User user = new User();
		model.put("user", user);
		return "channels";
	}
}
