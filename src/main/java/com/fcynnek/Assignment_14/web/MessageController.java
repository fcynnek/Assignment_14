package com.fcynnek.Assignment_14.web;

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
	
//    @Autowired
//    public MessageController(MessageService messageService) {
//        this.messageService = messageService;
//    }

    @GetMapping("/channels/{channelId}")
    public String getChannelMessages(@PathVariable Integer channelId, ModelMap model) {
    	List<User> users = userService.getAllUsers();
        List<Message> messages = messageService.getMessages(channelId);
        model.addAttribute("messages", messages);
        model.addAttribute("channelId", channelId);
        model.addAttribute("users", users);
        return "chats";
    }

    @PostMapping("/channels/{channelId}/sendMessage")
    @ResponseBody
    public Message sendMessage(@PathVariable Integer channelId, @RequestBody String message) {
    	ServletContext session = request.getServletContext();
        Channel currentChannelName = channelService.findChannelById(channelId);
        String username = session.getAttribute("username").toString();
        Integer userId = userService.getUserId(username);
        
        Message chatMessages = new Message();
        chatMessages.setMessage(message);
        chatMessages.setChannelId(channelId);
        chatMessages.setUsername(username);
        chatMessages.setChannel(currentChannelName);
        
        messageService.save(chatMessages);
        return chatMessages;
    }
}
