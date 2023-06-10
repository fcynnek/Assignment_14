package com.fcynnek.Assignment_14.service;

import com.fcynnek.Assignment_14.domain.User;

public class UserService {
	
	Integer userId = 0;
	
	public User createUser(String name) {
		User user = new User();
		user.setUserId(userId++);
		user.setName(name);
		return user;
	}
}
