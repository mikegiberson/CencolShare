package com.cencolshare.service;

import java.util.List;

import com.cencolshare.model.Discussion;
import com.cencolshare.model.Group;
import com.cencolshare.model.User;

public interface DiscussionService {

	public List<Discussion> getAllDiscussions(User user);
	
	public List<Discussion> getDiscussionsByGroup(Group group);
	
	public Discussion saveDiscussion(Discussion discussion);
	
	public Discussion getDiscussionById(int discussionId);
	
	public List<Discussion> searchDiscussionByNameDescription(String search);
	
	boolean deleteCommentById(int commentId);
	
	Discussion deleteDiscussionById(Discussion discussion);
}
