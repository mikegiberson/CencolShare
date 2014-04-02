package com.cencolshare.service.impl;

import java.text.SimpleDateFormat;
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
import com.cencolshare.model.DocumentComments;
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
		final String query = "SELECT tc.*, u.first_name, u.last_name, u.photo FROM tbl_comment tc, discussion_to_comment dc, tbl_user u WHERE " +
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
			SimpleDateFormat format = new SimpleDateFormat("MMM dd, yyyy hh:mm");
			
			Object[] r = (Object[]) result.get(i);
			dc.setCommentId((Integer)r[0]);
			dc.setComment((String)r[1]);
			dc.setCommentDate(format.format((Date)r[2]));
			dc.setUserId((Integer)r[3]);
			dc.setFirstName((String)r[4]);
			dc.setLastName((String)r[5]);
			dc.setPhoto((String)r[6]);
			results.add(dc);
			
			System.out.println(r[0]);
		}
		return results;
	}

	@Override
	public int getDocumentIdByCommentId(int commentId) {
		final String query = "SELECT document_id FROM document_to_comment WHERE comment_id=" + commentId;
		  final Query q = em.createNativeQuery(query);
		  int res = (Integer) q.getSingleResult();
		  return res;
	}

	@Override
	public List<DocumentComments> getCommentsByDocumentId(Long documentId) {
		final String query = "SELECT tc.*, u.first_name, u.last_name, u.photo FROM tbl_comment tc, document_to_comment dc, tbl_user u WHERE " +
				"tc.comment_id = dc.comment_id AND dc.document_id =" + documentId + " AND u.user_id = tc.user_id " +
				"ORDER BY tc.comment_id DESC";
		  final Query q = em.createNativeQuery(query);
		  List<Object> result = q.getResultList();
		  log.debug("result {}", result.size());
		  return convertDocsResultToList(result);

	}

	private List<DocumentComments> convertDocsResultToList(final List<Object> result) {
		final List<DocumentComments> results = new ArrayList<DocumentComments>();
		for (int i = 0; i < result.size(); i++) {
			final DocumentComments dc = new DocumentComments();
			SimpleDateFormat format = new SimpleDateFormat("MMM dd, yyyy hh:mm");
			
			Object[] r = (Object[]) result.get(i);
			dc.setCommentId((Integer)r[0]);
			dc.setComment((String)r[1]);
			dc.setCommentDate(format.format((Date)r[2]));
			dc.setUserId((Integer)r[3]);
			dc.setFirstName((String)r[4]);
			dc.setLastName((String)r[5]);
			dc.setPhoto((String)r[6]);
			results.add(dc);
			
			System.out.println(r[0]);
		}
		return results;
	}

}
