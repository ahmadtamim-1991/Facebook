package com.ahmad.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ahmad.entities.PostEntity;

@Repository
public interface PostRepository extends CrudRepository<PostEntity, Long>{

}
