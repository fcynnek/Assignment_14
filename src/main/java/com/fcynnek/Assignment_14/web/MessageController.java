package com.fcynnek.Assignment_14.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HttpServletBean;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fcynnek.Assignment_14.domain.Channel;
import com.fcynnek.Assignment_14.domain.Message;
import com.fcynnek.Assignment_14.domain.User;
import com.fcynnek.Assignment_14.service.ChannelService;
import com.fcynnek.Assignment_14.service.MessageService;
import com.fcynnek.Assignment_14.service.UserService;

@Controller
public class MessageController {

	@Autowired
    private MessageService messageService;
	
	@Autowired
	private ChannelService channelService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private HttpSession request;
	

    @GetMapping("/channels/{channelId}")
    public String getChannelMessages(@PathVariable Integer channelId, ModelMap model) {
    	List<User> users = userService.getAllUsers();
        List<Message> messages = messageService.getMessages(channelId);
        model.addAttribute("messages", messages);
        model.addAttribute("channelId", channelId);
        model.addAttribute("users", users);
        return "chats";
    }
    
    /*
     * 	message request object from js to java
		You can try to send an object with a username and messages [array of strings]

		Try not to expect string in java
     */

    @PostMapping("/channels/{channelId}/sendMessage")
    @ResponseBody
    public Message sendMessage(@PathVariable Integer channelId, @RequestBody String[] messages) {
        ServletContext session = request.getServletContext();
        Channel currentChannelName = channelService.findChannelById(channelId);
        String username = session.getAttribute("username").toString();
        Integer userId = userService.getUserId(username);

        List<Message> savedMessages = new ArrayList<>();

        for (String message : messages) {
            Message chatMessage = new Message();
            chatMessage.setMessage(message);
            chatMessage.setChannelId(channelId);
            chatMessage.setUsername(username);
            chatMessage.setChannel(currentChannelName);

            messageService.save(chatMessage);
            savedMessages.add(chatMessage);
        }

        return (Message) savedMessages;
    }
}
