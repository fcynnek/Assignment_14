package com.fcynnek.Assignment_14.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fcynnek.Assignment_14.domain.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer>{

	
}
