package com.fcynnek.Assignment_14.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Component;

import com.fcynnek.Assignment_14.domain.User;

@Component
public class UserRepository {

//	private List<User> users = new ArrayList<>();
	Integer userId = 0;
	HashMap<Integer, String> users = new HashMap<Integer, String>();
	
	public User saveUser (String username) {
		if (users.containsValue(username)) {
//			return saveUser(userId, user);
			return saveUser(username);
		} else {
			User newUser = new User(userId, username);
			newUser.setUserId(userId++);
			newUser.setUsername(username);
			users.put(userId, username);
//			return ((Object) users).add(newUser);
			return newUser;
		}
	}
}
