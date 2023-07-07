package com.fcynnek.Assignment_14.domain;

import java.util.ArrayList;
import java.util.List;

public class Message {

	private Integer messageId;
	private String message;
	private User user;
	private Channel channel;
	private Integer channelId;
	private String username;
	private List<String[]> messages = new ArrayList<>();
	
	
	public Integer getMessageId() {
		return messageId;
	}
	public void setMessageId(Integer messageId) {
		this.messageId = messageId;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public Channel getChannel() {
		return channel;
	}
	public void setChannel(Channel channel) {
		this.channel = channel;
	}
	public Integer getChannelId() {
		return channelId;
	}
	public void setChannelId(Integer channelId) {
		this.channelId = channelId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public List<String[]> getMessages() {
		return messages;
	}
	public void setMessages(List<String[]> messages) {
		this.messages = messages;
	}
	
	
}
