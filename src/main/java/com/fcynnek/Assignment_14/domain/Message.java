package com.fcynnek.Assignment_14.domain;

public class Message {

	private Integer messageId;
	private String message;
	private User user;
	private Channel channel;
	private Channel channelId;
	
	
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
	public Channel getChannelId() {
		return channelId;
	}
	public void setChannelId(Channel channelId) {
		this.channelId = channelId;
	}
	
	
}
