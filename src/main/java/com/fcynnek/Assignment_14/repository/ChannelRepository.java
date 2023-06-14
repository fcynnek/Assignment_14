package com.fcynnek.Assignment_14.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.fcynnek.Assignment_14.domain.Channel;

@Component
public class ChannelRepository {

	List<Channel> channels = new ArrayList<>();
	
	public List<Channel> findAll() {
		return channels;
	}
}
