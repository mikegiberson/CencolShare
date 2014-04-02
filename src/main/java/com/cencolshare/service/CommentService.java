package com.cencolshare.service;

import java.util.List;

import com.cencolshare.model.Comment;
import com.cencolshare.model.DiscussionComments;
import com.cencolshare.model.DocumentComments;

public interface CommentService {

	Comment getCommentById(int commentId);
	
	int getDiscussionIdByCommentId(int commentId);
	
	List<DiscussionComments> getCommentsByDiscussionId(int discussionId);
	
	int getDocumentIdByCommentId(int commentId);
	
	List<DocumentComments> getCommentsByDocumentId(Long documentId);
}
