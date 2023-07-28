package com.fcynnek.Assignment_14.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fcynnek.Assignment_14.domain.Channel;
import com.fcynnek.Assignment_14.domain.Message;
import com.fcynnek.Assignment_14.domain.User;

public class MessageRequest {

//	@JsonProperty("channel")
//	private Channel channel;
//	private Channel channelId;
//	private Message message;
//	private User user;
	
	@JsonProperty("channelId")
	private Integer channelId;
	@JsonProperty("message")
	private String message;
	@JsonProperty("user")
	private String user;
	
	@Override
	public String toString() {
		return "MessageRequest [channelId=" + channelId + ", message=" + message + ", user=" + user + "]";
	}


	public Integer getChannelId() {
		return channelId;
	}

	public void setChannel(Integer channelId) {
		this.channelId = channelId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

}
