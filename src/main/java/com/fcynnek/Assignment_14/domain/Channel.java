package com.fcynnek.Assignment_14.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fcynnek.Assignment_14.repository.MessageRepository;

//@Entity
public class Channel {
	
	private Integer channelId;
	private String channelName;
	private MessageRepository messageRepo = new MessageRepository();
//	private List<Message> messages;
//	private List<User> users;

	
//	@Override
//	public String toString() {
//		return "Channel [channelId=" + channelId + ", channelName=" + channelName + ", messages=" + "]";
//	}
//	public Channel() {
//		this.setUsers(new ArrayList<>());
//		this.messages = new ArrayList<>();
//	}
//	public void addUser(User user) {
//		users.add(user);
//	}
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
//	public List<Message> getMessages() {
//		return messages;
//	}
//	public void setMessages(List<Message> messages) {
//		this.messages = messages;
//	}
//	public void addMessage(Message message) {
//		this.messages.add(message);
//	}
//	public List<User> getUsers() {
//		return users;
//	}
//	public void setUsers(List<User> users) {
//		this.users = users;
//	}
	public MessageRepository getMessageRepo() {
		return messageRepo;
	}
//	public void setMessageRepo(MessageRepository messageRepo) {
//		this.messageRepo = messageRepo;
//	}
	
	
}
