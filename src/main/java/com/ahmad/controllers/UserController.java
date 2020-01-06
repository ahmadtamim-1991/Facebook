package com.ahmad.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ahmad.dto.UserDto;
import com.ahmad.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "",method = RequestMethod.POST)
	public UserDto AddUser(@RequestBody UserDto dto) {
		
		userService.createUser(dto);
		return dto;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public UserDto getUserById(@PathVariable("id")Long id) {
		return userService.getUserById(id);
	}

}
