package com.fcynnek.Assignment_14.domain;

import java.util.ArrayList;
import java.util.List;

public class User {

	private Integer userId;
	private String username;
	private List<Message> messages = new ArrayList<>();
	private List<Channel> channels = new ArrayList<>();
	
	
	
	public User(Integer userId, String username) {
		super();
		this.userId = userId;
		this.username = username;
	}
	public User(String username) {
		this.username = username;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public List<Message> getMessages() {
		return messages;
	}
	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
	public List<Channel> getChannels() {
		return channels;
	}
	public void setChannels(List<Channel> channels) {
		this.channels = channels;
	}
	
}
