package com.fcynnek.Assignment_14.domain;

import java.util.ArrayList;
import java.util.List;

public class Channel {

	private Integer channelId;
	private String channelName;
	private List<Message> messages;
	private List<User> users;


	public Channel() {
		this.setUsers(new ArrayList<>());
		this.messages = new ArrayList<>();
	}
	public void addUser(User user) {
		users.add(user);
	}
	public Integer getChannelId() {
		return channelId;
	}
	public void setChannelId(Integer channelId) {
		this.channelId = channelId;
	}
	
	public String getChannelName() {
		return channelName;
	}
	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}
	public List<Message> getMessages() {
		return messages;
	}
	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
	public void addMessage(Message message) {
		this.messages.add(message);
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	
}
