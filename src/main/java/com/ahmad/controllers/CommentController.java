package com.ahmad.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ahmad.dto.CommentDto;
import com.ahmad.services.CommentService;

@RestController
@RequestMapping("comment")
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	@RequestMapping(value = "/{id}",method = RequestMethod.POST)
	public void addComment(@PathVariable("id")Long postid,@RequestBody CommentDto dto) throws Exception {
		
		commentService.addComment(postid, dto);
		
	}

}
