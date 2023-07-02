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

import com.fcynnek.Assignment_14.domain.Message;
import com.fcynnek.Assignment_14.service.MessageService;

@Controller
public class MessageController {

    private MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/channels/{channelId}")
    public String getChannelMessages(@PathVariable Integer channelId, ModelMap model) {
        List<Message> messages = messageService.getMessages(channelId);
        model.put("messages", messages);
        return "chats";
    }

    @PostMapping("/channels/{channelId}/sendMessage")
    @ResponseBody
    public ResponseEntity<String> sendMessage(@PathVariable Integer channelId, @RequestBody Message message) {
        message.setChannelId(channelId);
        messageService.save(message);
        return ResponseEntity.ok().build();
    }
}
