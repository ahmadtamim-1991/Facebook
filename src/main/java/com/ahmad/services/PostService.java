package com.ahmad.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahmad.dto.PostDto;
import com.ahmad.dto.UserDto;
import com.ahmad.entities.PostEntity;
import com.ahmad.entities.UserEntity;
import com.ahmad.repositories.PostRepository;
import com.ahmad.repositories.UserRepository;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public void createPost(Long id,PostDto dto ) {
		
		UserEntity userentity = getUserById(id);
		
		PostEntity entity=convert(dto);
		
		entity.setUser(userentity);
		
		postRepository.save(entity);
		
		
	}
	
public UserEntity getUserById(Long id) {
		
		UserDto dto=new UserDto();
		UserEntity entity =new UserEntity();
		Optional<UserEntity> optEntity=userRepository.findById(id);
				if(optEntity != null) {
					entity = optEntity.get();
					BeanUtils.copyProperties(dto, entity);
				}
		
		
		return entity;
		
	}

	
	public PostEntity convert(PostDto dto) {
		PostEntity en = null;
		if(dto != null) {
			en=new PostEntity();
			en.setType(dto.getTypee());
			en.setPostDate(dto.getPostDate());
		}
		return en;
	}

}
