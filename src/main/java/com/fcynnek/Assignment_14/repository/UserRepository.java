package com.fcynnek.Assignment_14.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.fcynnek.Assignment_14.domain.User;

public class UserRepository {

//	private List<User> users = new ArrayList<>();
	Integer userId = 0;
	HashMap<Integer, String> users = new HashMap<Integer, String>();
	
	public int saveUser (Integer userId, String user) {
		if (users.containsValue(user)) {
//			return saveUser(userId, user);
			return user.indexOf(userId);
		} else {
			User newUser = new User(userId, user);
			newUser.setUserId(userId++);
			newUser.setUsername(user);
			return users.add(newUser);
		}
	}
}
