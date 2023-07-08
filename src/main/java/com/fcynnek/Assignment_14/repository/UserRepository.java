package com.fcynnek.Assignment_14.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Component;

import com.fcynnek.Assignment_14.domain.User;

@Component
public class UserRepository {

	Integer userId = 0;
	private List<User> users = new ArrayList<>();
//	HashMap<Integer, String> users = new HashMap<Integer, String>();
	
//	public User saveUser (String username) {
//		if (users.containsValue(username)) {
////			return saveUser(userId, user);
//			return saveUser(username);
//		} else {
//			User newUser = new User(userId, username);
//			newUser.setUserId(userId++);
//			newUser.setUsername(username);
//			users.put(userId, username);
//			return newUser;
//		}
//	}
	
	public void saveUser(User username) {
		users.add(username);
	}
	
	public User findUserByUsername(String username) {
		User userFound = null;
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                userFound = user;
                break;
            }
        }
        return userFound;
	}

	public User findUserById(Integer userId) {
		User userFound = null;
		for (User user : users) {
			if (user.getUserId().equals(userId)) {
                userFound = user;
                break;
            }
		}
		return userFound;
	}

	public List<User> getAllUsers() {
		
		return users;
	}
}
