package com.fcynnek.Assignment_14.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fcynnek.Assignment_14.domain.Channel;
import com.fcynnek.Assignment_14.domain.Message;
import com.fcynnek.Assignment_14.service.ChannelService;
import com.fcynnek.Assignment_14.service.MessageService;
import com.google.gson.Gson;

@Controller
public class MessageController {

	@Autowired
	private MessageService messageService;
	
	@Autowired
	private ChannelService channelService;
	
//	@GetMapping("/messages")
//	public List<Message> getMessages(@PathVariable Integer channelId, ModelMap model) {
//		Channel channel = channelService.findChannelById(channelId);
//		model.put("channel", channel);
//		List<Message> channelMessages = messageService.getMessages(channelId);
//        return channelMessages;
//    }
	
	@GetMapping("/channels/{channelId}")
	public String getSingleChannel(@PathVariable Integer channelId, ModelMap model) {
		Channel channel = channelService.findChannelById(channelId);
		List<Message> channelMessages = messageService.getMessages(channelId);
		model.put("channel", channel);
		return "chats";
	}
	
	@PostMapping("/messages")
	@ResponseBody
//	public Message createMessage(@RequestBody Message message, Integer channelId) {
	public Message createMessage(@RequestBody String message, Integer channelId) {
//        messageService.createMessage(message, channelId);
//		Gson gson = new Gson();
//		String jsonMessage = gson.toJson(message);
//		System.out.println(message);
//        return jsonMessage;
		Message newMessage = new Message();
		newMessage.setMessage(message);
//		newMessage.setChannelId(channelId);
		messageService.createMessage(newMessage, channelId);
		return newMessage;
    }
}
