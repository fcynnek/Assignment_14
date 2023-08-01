package com.fcynnek.Assignment_14.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//@Entity
public class User {

	private Integer userId;
	private String username;
//	private List<Message> messages = new ArrayList<>();
//	private List<Channel> channels = new ArrayList<>();
	
	
//	@Override
//	public String toString() {
//		return "User [userId=" + userId + ", username=" + username + "]";
//	}
	
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
//	public List<Message> getMessages() {
//		return messages;
//	}
//	public void setMessages(List<Message> messages) {
//		this.messages = messages;
//	}
//	public List<Channel> getChannels() {
//		return channels;
//	}
//	public void setChannels(List<Channel> channels) {
//		this.channels = channels;
//	}
//	public Integer getChannelId() {
//		return channelId;
//	}
//	public void setChannelId(Integer channelId) {
//		this.channelId = channelId;
//	}
	
}
