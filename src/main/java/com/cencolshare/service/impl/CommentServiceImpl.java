package com.cencolshare.service.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cencolshare.model.Comment;
import com.cencolshare.model.Document;
import com.cencolshare.repository.CommentRepository;
import com.cencolshare.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	CommentRepository commentRepository;
	
	@PersistenceContext
	 EntityManager em;
	
	public Comment getCommentById(int commentId){
		return commentRepository.findOne(commentId);
	}

	@Override
	public int getDiscussionIdByCommentId(int commentId) {
		final String query = "SELECT discussion_id FROM discussion_to_comment WHERE comment_id=" + commentId;
		  final Query q = em.createNativeQuery(query);
		 
		  int res = (Integer) q.getSingleResult();
		  return res;
		  
	}

}
