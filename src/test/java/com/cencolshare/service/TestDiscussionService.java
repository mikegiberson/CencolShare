package com.cencolshare.service;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cencolshare.init.BaseTestCase;
import com.cencolshare.model.Comment;
import com.cencolshare.model.Discussion;
import com.cencolshare.model.Group;
import com.cencolshare.model.User;

@Slf4j
public class TestDiscussionService extends BaseTestCase {

	@Autowired
	private UserService userService;
	
	@Autowired
	private DiscussionService discussionService;
	
	@Test
	public void testCreateDiscussion() {
		log.info("Inside test create discussion function");
		
		final User user = userService.insertUser(mockData.createUser());
		final List<Comment> comments = new ArrayList<Comment>();
		comments.add(mockData.createComment(user));		
		final Discussion discussion = discussionService.saveDiscussion(mockData.createDiscussion(user, comments));
		
		assertNotNull("Create Discussion failed", discussion);
	}
	
	@Test
	public void testsearchGroupsByNameDescription()
	{
		final User user = userService.insertUser(mockData.createUser());
		final List<Comment> comments = new ArrayList<Comment>();
		comments.add(mockData.createComment(user));
		final Discussion discussion = discussionService.saveDiscussion(mockData.createDiscussion(user,comments));
		assertNotNull("Create Discussion failed", discussion);
		final List<Discussion> discTest=discussionService.searchDiscussionByNameDescription("a");
		assertNotNull(discTest);
		assertEquals(discTest.size()>0, true);
		assertEquals(discussion.getDiscussionContent(),discTest.get(0).getDiscussionContent());
		assertEquals(discussion.getDiscussionTopic(),discTest.get(0).getDiscussionTopic());
		assertEquals(discussion.getUser().getUserId(), discTest.get(0).getUser().getUserId());
		
	}
	
}
