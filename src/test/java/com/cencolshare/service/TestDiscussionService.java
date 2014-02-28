package com.cencolshare.service;

import lombok.extern.slf4j.Slf4j;

import static org.junit.Assert.*;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cencolshare.init.BaseTestCase;
import com.cencolshare.model.Discussion;
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
		final Discussion discussion = discussionService.saveDiscussion(mockData.createDiscussion(user));
		
		assertNotNull("Create Discussion failed", discussion);
	}

}
