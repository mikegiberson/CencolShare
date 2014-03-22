package com.cencolshare.service;

import com.cencolshare.model.Comment;

public interface CommentService {

	Comment getCommentById(int commentId);
	
	int getDiscussionIdByCommentId(int commentId);
}
