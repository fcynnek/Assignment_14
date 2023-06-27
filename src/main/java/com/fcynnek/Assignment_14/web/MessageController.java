package com.fcynnek.Assignment_14.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.fcynnek.Assignment_14.service.MessageService;

@Controller
public class MessageController {

	@Autowired
	private MessageService messageService;
	
	
}
