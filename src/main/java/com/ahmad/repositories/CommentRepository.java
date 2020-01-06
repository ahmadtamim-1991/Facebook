package com.ahmad.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.ahmad.entities.CommentEntity;

@Repository
public interface CommentRepository extends CrudRepository<CommentEntity, Long> {

}
