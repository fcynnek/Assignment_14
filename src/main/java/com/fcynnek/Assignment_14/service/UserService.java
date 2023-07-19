package com.fcynnek.Assignment_14.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

import com.fcynnek.Assignment_14.domain.User;
import com.fcynnek.Assignment_14.repository.UserRepository;

@Service
public class UserService implements Converter<String, User>{
	
	Integer userId = 0;
	
	@Autowired
	private UserRepository userRepo;
	
	public User createUser(String username) {
		User user = new User();
		user.setUserId(userId++);
		user.setUsername(username);
		return user;
//		return userRepo.saveUser(username);
	}

	public User findUserById(Integer userId) {
		return userRepo.findById(userId).get();
//		return null;
	}
	
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}
	
	public User findByUsername(String username) {
		return userRepo.findByUsername(username);
	}

	@Override
	public User convert(String source) {
		User user = new User();
		user.setUsername(source);
		return user;
	}
}
