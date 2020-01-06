package com.ahmad.services;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ahmad.dto.CommentDto;
import com.ahmad.dto.PostDto;
import com.ahmad.dto.UserDto;
import com.ahmad.entities.CommentEntity;
import com.ahmad.entities.PostEntity;
import com.ahmad.entities.UserEntity;
import com.ahmad.repositories.CommentRepository;
import com.ahmad.repositories.PostRepository;
import com.ahmad.repositories.UserRepository;

@Service
public class CommentService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private CommentRepository commentRepository;
	@Autowired
	private PostRepository postRespository;
	
	public void addComment(Long id,CommentDto dto) throws Exception {
		
		PostDto postdto= new PostDto();
		PostEntity entity =new PostEntity();	
		Optional<PostEntity> postEntity= postRespository.findById(id);
		if(postEntity.isPresent()) {
			entity=postEntity.get();
			BeanUtils.copyProperties(postdto, postEntity);
		}else {
			throw new Exception("wrong post id : " +id);
		}
		
		
		CommentEntity commententity = new CommentEntity();
		commententity.setCommentType(dto.getCommentType());
		commententity.setCommentDate(dto.getCommentDate());
		commententity.setPost(entity);
		commententity.setUser1(postEntity.get().getUser());
		commentRepository.save(commententity);
	}
	
//	UserEntity userentity = getUserById(id);
//	
//	PostEntity entity=convert(dto);
//	
//	entity.setUser(userentity);
//	
//	postRepository.save(entity);
//	
//	
//}
//
//public UserEntity getUserById(Long id) {
//	
//	UserDto dto=new UserDto();
//	UserEntity entity =new UserEntity();
//	Optional<UserEntity> optEntity=userRepository.findById(id);
//			if(optEntity != null) {
//				entity = optEntity.get();
//				BeanUtils.copyProperties(dto, entity);
//			}
//	
//	
//	return entity;
//	
//}

}
