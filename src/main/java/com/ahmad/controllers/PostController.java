package com.ahmad.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ahmad.dto.PostDto;
import com.ahmad.services.PostService;

@RestController
@RequestMapping("post")
public class PostController {
	
	@Autowired
	private PostService postService;
	
	@RequestMapping(value = "/{id}",method = RequestMethod.POST)
	public void addPost(@PathVariable("id") Long userId, @RequestBody PostDto dto) {
		
		 postService.createPost(userId, dto);
	}

}
