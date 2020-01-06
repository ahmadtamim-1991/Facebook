package com.ahmad.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ahmad.dto.UserDto;
import com.ahmad.entities.UserEntity;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long>{
	
	
	
//	public UserEntity findOne(Long id);
//	
//	public UserEntity findByName(String name);
//	
	

}
