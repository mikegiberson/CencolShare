package com.cencolshare.service.impl;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cencolshare.model.Discussion;
import com.cencolshare.model.Group;
import com.cencolshare.repository.DiscussionRepository;
import com.cencolshare.service.DiscussionService;

@Service
@Slf4j
public class DiscussionServiceImpl implements DiscussionService {

	@Autowired
	DiscussionRepository discussionRepository;

	@PersistenceContext
	EntityManager em;

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

	@Override
	public Discussion getDiscussionById(int discussionId) {
		final Discussion discussion = discussionRepository.findOne(discussionId);
		return discussion;
	}

	@Override
	public List<Discussion> searchDiscussionByNameDescription(String search) {
		final String query = "SELECT * FROM tbl_discussion WHERE discussion_topic LIKE '%"+search+"f%' OR discussion_content LIKE '%"+search+"%'";
		final Query q = em.createNativeQuery(query, Discussion.class);
		return q.getResultList();
	}
}
