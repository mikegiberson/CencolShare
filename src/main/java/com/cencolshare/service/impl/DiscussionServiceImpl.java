package com.cencolshare.service.impl;
import java.util.Date;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cencolshare.model.Discussion;
import com.cencolshare.repository.DiscussionRepository;
import com.cencolshare.service.DiscussionService;

@Service
@Slf4j
public class DiscussionServiceImpl implements DiscussionService {

	@Autowired
	DiscussionRepository discussionRepository;

	@Override
	public List<Discussion> getAllDiscussions(){
		List<Discussion> discussions = (List<Discussion>) discussionRepository.findAll();
		log.debug("Discussions List Count: {}", discussions.size());	
		return discussions;
	}

	@Override
	public Discussion saveDiscussion(Discussion discussion) {

		discussion.setDiscussionDate(new Date());
		
		return discussionRepository.save(discussion);
	}
}
