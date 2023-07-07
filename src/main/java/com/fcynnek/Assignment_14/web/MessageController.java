package com.fcynnek.Assignment_14.web;

import java.util.Collection;
import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import com.fcynnek.Assignment_14.domain.Channel;
import com.fcynnek.Assignment_14.domain.Message;
import com.fcynnek.Assignment_14.domain.User;
import com.fcynnek.Assignment_14.service.ChannelService;
import com.fcynnek.Assignment_14.service.MessageService;

@Controller
public class MessageController {

	@Autowired
    private MessageService messageService;
	
	@Autowired
	private ChannelService channelService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/channels/{channelId}")
    public String getChannelMessages(@PathVariable Integer channelId, ModelMap model, HttpSession session, @RequestParam("username") String username,
    		@RequestParam(value="message") String message) {
    	User user = new User();
		user.setUsername(username);
		session.setAttribute("user", user);
		session.setAttribute("username", username);

		Channel channel = channelService.findChannelById(channelId);
		channel.addUser(user);
		session.setAttribute("channel", channel);

		if (message != null && !message.isEmpty()) {
			Message chatMessage = new Message();
			chatMessage.setMessage(message);
			chatMessage.setUser(user);
			chatMessage.setUsername(username);
			chatMessage.setChannelId(channel.getChannelId());
			channel.addMessageOfTypeString(message);
		}
		
		model.addAttribute("user", user);
		model.addAttribute("channel", channel);
		model.addAttribute("messages", channel.getMessages());
        return "channels";
    }

    @PostMapping("/channels/{channelId}/sendMessage")
    @ResponseBody
    public ResponseEntity<String> sendMessage(@PathVariable Integer channelId, @RequestBody Message message) {
        message.setChannelId(channelId);
        messageService.save(message);
        return ResponseEntity.ok().build();
    }
}
