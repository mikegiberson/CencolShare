package com.cencolshare.repository;

import org.springframework.data.repository.CrudRepository;

import com.cencolshare.model.Comment;

public interface CommentRepository extends CrudRepository<Comment, Integer> {

	
}
