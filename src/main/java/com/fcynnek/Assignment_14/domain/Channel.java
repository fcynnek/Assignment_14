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

@Entity
@Table(name = "channel")
public class Channel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer channelId;
	private String channelName;
	@OneToMany(mappedBy = "channel", cascade = CascadeType.ALL)
	private List<Message> messages;
	@ManyToMany(mappedBy = "channels")
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
