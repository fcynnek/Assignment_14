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
	public String getWelcome(ModelMap model) {
		 if (session.getAttribute("username") != null) {
			 String username = (String) session.getAttribute("username");
			 User user = userService.createUser(username);
			 model.put("user", user);
	            return "redirect:/channels";
	        }
	        return "welcome";
	}
	
//	@PostMapping(value = "/welcome", consumes = MediaType.APPLICATION_JSON_VALUE)
	@PostMapping("/welcome")
	@ResponseBody
//	public String postUsername (@RequestParam("username") String username, @RequestBody User sessionUser, ModelMap model) {
//	public String postUsername (@RequestBody User sessionUser, ModelMap model) {
	public String postUsername (@RequestParam("username") String username, ModelMap model) {
		User user = userService.createUser(username);
	    user.setUsername(username); // Set the username field
//	    userService.createUser(user);
	    session.setAttribute("user", user.getUsername());
	    model.addAttribute("user", user); // Add the user object to the model
        return "redirect:/channels";
	}
}
