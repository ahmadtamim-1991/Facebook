package com.ahmad.services;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahmad.dto.UserDto;
import com.ahmad.entities.UserEntity;
import com.ahmad.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	public void createUser(UserDto dto) {
		
		UserEntity entity = convertDto2entity(dto);
		
		userRepository.save(entity);
	}
	
	
	public UserDto getUserById(Long id) {
		
		UserDto dto=new UserDto();
		UserEntity entity =new UserEntity();
		Optional<UserEntity> optEntity=userRepository.findById(id);
				if(optEntity != null) {
					entity = optEntity.get();
					BeanUtils.copyProperties(entity, dto);
				}
		
		
		return dto;
		
	}
	
	
	
	// converter for create user
	public UserEntity convertDto2entity(UserDto dto) {
		UserEntity entity = null;
		if(dto != null) {
			entity=new UserEntity();
			entity.setName(dto.getName());
			entity.setEmail(dto.getEmail());
			entity.setGender(dto.getGender());
			entity.setDob(dto.getDob());
			
		}
		return entity;
	}
	
	
//	// converting for getUserById
//	public UserDto convertEntity2Dto(UserEntity entity) {
//		UserDto dto=null;
//		if(entity != null) {
//			dto=new UserDto();
//			dto.setName(entity.getName());
//			dto.setEmail(entity.getEmail());
//			dto.setDob(entity.getDob());
//			dto.setGender(dto.getGender());
//		}
//		
//		return dto;
//	}
}
