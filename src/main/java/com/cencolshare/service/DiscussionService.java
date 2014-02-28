package com.cencolshare.service;

import java.util.List;

import com.cencolshare.model.Discussion;

public interface DiscussionService {

	public List<Discussion> getAllDiscussions();
	
	public Discussion saveDiscussion(Discussion discussion);
}
