package com.fcynnek.Assignment_14.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.fcynnek.Assignment_14.domain.User;
import com.fcynnek.Assignment_14.repository.UserRepository;

@Service
public class UserService {
	
//	Integer userId = 0;
	
	@Autowired
	private UserRepository userRepo;
	
	public User createUser(String username) {
//		User user = new User();
//		user.setUserId(userId++);
//		user.setName(name);
//		return user;
		return userRepo.saveUser(username);
	}
}
