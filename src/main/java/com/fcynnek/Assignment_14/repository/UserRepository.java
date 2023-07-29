package com.fcynnek.Assignment_14.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.fcynnek.Assignment_14.domain.User;

@Component
public class UserRepository {

	private List<User> allUsers;
	private Integer userId;
	
	public User saveUser(User user) {
		Integer currentUserId = userId++;
		
		user.setUserId(currentUserId);
		allUsers.add(user);
		return user;
	}

	public List<User> findAll() {
		return allUsers;
	}

	public User findByUsername(String username) {
		for (User currentUser : allUsers) {
			if (currentUser.getUsername().equals(username)) {
				return currentUser;
			}
		}
		return null;
	}


	
}
