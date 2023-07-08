package com.fcynnek.Assignment_14.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<String> sendMessage(@PathVariable Integer channelId, @RequestBody String message) {
//        message.setChannelId(channelId);
        messageService.save(message);
        return ResponseEntity.ok().build();
    }
}
