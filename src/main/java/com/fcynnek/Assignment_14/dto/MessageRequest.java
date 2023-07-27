package com.fcynnek.Assignment_14.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fcynnek.Assignment_14.domain.Channel;
import com.fcynnek.Assignment_14.domain.Message;
import com.fcynnek.Assignment_14.domain.User;

public class MessageRequest {

//	@JsonProperty("channel")
//	private Channel channel;
	@JsonProperty("channelId")
	private Channel channelId;
	@JsonProperty("message")
	private Message message;
	@JsonProperty("user")
	private User user;
	
	
	@Override
	public String toString() {
		return "MessageRequest [channelId=" + channelId + ", message=" + message + ", user=" + user + "]";
	}


	public Channel getChannelId() {
		return channelId;
	}

	public void setChannel(Channel channelId) {
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
