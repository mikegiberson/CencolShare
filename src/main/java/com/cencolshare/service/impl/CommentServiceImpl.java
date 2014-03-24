package com.cencolshare.service.impl;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cencolshare.model.Comment;
import com.cencolshare.model.DiscussionComments;
import com.cencolshare.model.Document;
import com.cencolshare.repository.CommentRepository;
import com.cencolshare.service.CommentService;

@Service
@Slf4j
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

	@Override
	public List<DiscussionComments> getCommentsByDiscussionId(int discussionId) {
		final String query = "SELECT tc.*, u.first_name, u.last_name FROM tbl_comment tc, discussion_to_comment dc, tbl_user u WHERE " +
				"tc.comment_id = dc.comment_id AND dc.discussion_id =" + discussionId + " AND u.user_id = tc.user_id " +
				"ORDER BY tc.comment_id DESC";
		  final Query q = em.createNativeQuery(query);
		  List<Object> result = q.getResultList();
		  log.debug("result {}", result.size());
		  return convertResultToList(result);
	}
	
	private List<DiscussionComments> convertResultToList(final List<Object> result) {
		final List<DiscussionComments> results = new ArrayList<DiscussionComments>();
		for (int i = 0; i < result.size(); i++) {
			final DiscussionComments dc = new DiscussionComments();
			Object[] r = (Object[]) result.get(0);
			dc.setCommentId((Integer)r[0]);
			dc.setComment((String)r[1]);
			dc.setCommentDate((Date)r[2]);
			dc.setUserId((Integer)r[3]);
			dc.setFirstName((String)r[4]);
			dc.setLastName((String)r[4]);
			
			results.add(dc);
			
			System.out.println(r[0]);
		}
		return results;
	}

}
