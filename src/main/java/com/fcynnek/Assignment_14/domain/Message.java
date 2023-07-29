package com.fcynnek.Assignment_14.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

//@Entity
public class Message {

//	private Integer messageId;
	private String message;
	private String username;
//	@JsonIgnore
//	private Channel channel;
//	private List<String> messages = new ArrayList<>(); // arrange array after receiving

	@Override
	public String toString() {
		return "Message [user=" + username + ", message=" + message + "]";
	}

//	public void addMessage(String message) {
//		this.messages.add(message);
//	}

//	public Integer getMessageId() {
//		return messageId;
//	}
//
//	public void setMessageId(Integer messageId) {
//		this.messageId = messageId;
//	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUser() {
		return username;
	}

	public void setUser(String user) {
		this.username = user;
	}

//	public Channel getChannel() {
//		return channel;
//	}
//
//	public void setChannel(Channel channel) {
//		this.channel = channel;
//	}
//
//	public List<String> getMessages() {
//		return messages;
//	}
//
//	public void setMessages(List<String> messages) {
//		this.messages = messages;
//	}

}
