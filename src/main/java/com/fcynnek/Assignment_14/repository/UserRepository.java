package com.fcynnek.Assignment_14.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fcynnek.Assignment_14.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	User findByUsername(String username);

	
}
