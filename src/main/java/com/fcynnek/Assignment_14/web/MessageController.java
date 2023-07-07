package com.fcynnek.Assignment_14.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fcynnek.Assignment_14.domain.Message;
import com.fcynnek.Assignment_14.domain.MessageResponse;
import com.fcynnek.Assignment_14.service.ChannelService;
import com.fcynnek.Assignment_14.service.MessageService;

@Controller
//@RestController
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
    public String getChannelMessages(@PathVariable Integer channelId, ModelMap model) {
        List<Message> messages = messageService.getMessages(channelId);
        model.addAttribute("messages", messages);
        model.addAttribute("channelId", channelId);
        return "chats";
//    	return messageService.getMessages(channelId);
        // try rest controller take obj and parse
    }
    
//    @GetMapping(value = "/channels/{channelId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @GetMapping("/channels/{channelId}/getMessages")
    @ResponseBody
    public List<Message> getChannelMessagesJson(@PathVariable Integer channelId) {
        return messageService.getMessages(channelId);
    }





    @PostMapping("/channels/{channelId}/sendMessage")
    @ResponseBody
    public ResponseEntity<String> sendMessage(@PathVariable Integer channelId, @RequestBody Message message) {
        message.setChannelId(channelId);
        messageService.save(message);
        return ResponseEntity.ok().build();
    }
}
