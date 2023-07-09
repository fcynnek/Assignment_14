package com.fcynnek.Assignment_14.domain;

import java.util.ArrayList;
import java.util.List;

public class User {

	private Integer userId;
	private String username;
	private List<String> messages = new ArrayList<>();
	private Integer  channelId;
	private List<Channel> channels = new ArrayList<>();
	
	
	
//	public User(Integer userId, String username) {
//		super();
//		this.userId = userId;
//		this.username = username;
//	}
//	public User(String username) {
//		this.username = username;
//	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}
	public String setUsername(String username) {
		return this.username = username;
	}
	public List<String> getMessages() {
		return messages;
	}
	public void setMessages(List<String> messages) {
		this.messages = messages;
	}
	public List<Channel> getChannels() {
		return channels;
	}
	public void setChannels(List<Channel> channels) {
		this.channels = channels;
	}
	public Integer getChannelId() {
		return channelId;
	}
	public void setChannelId(Integer channelId) {
		this.channelId = channelId;
	}
	
}
