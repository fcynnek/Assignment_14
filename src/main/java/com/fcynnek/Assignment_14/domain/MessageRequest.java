package com.fcynnek.Assignment_14.domain;

public class MessageRequest {

	private Channel channelId;
	private Message message;
	private User user;
	
	
	@Override
	public String toString() {
		return "MessageRequest [channelId=" + channelId + ", message=" + message + ", user=" + user + "]";
	}


	public Channel getChannelId() {
		return channelId;
	}


	public void setChannelId(Channel channelId) {
		this.channelId = channelId;
	}


	public Message getMessage() {
		return message;
	}


	public void setMessage(Message message) {
		this.message = message;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	
	
}
