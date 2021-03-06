package com.ahmad.dto;

import java.util.List;

public class UserDto {
	
	private String name;
	private String email;
	private String gender;
	private String dob;
	
    private List<PostDto> post;

	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public List<PostDto> getPost() {
		return post;
	}
	public void setPost(List<PostDto> post) {
		this.post = post;
	}
	

}
