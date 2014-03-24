package com.cencolshare.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cencolshare.init.BaseTestCase;
import com.cencolshare.model.User;

public class TestUserService extends BaseTestCase {

	@Autowired
	private UserService userService;
	
	@Test
	public void testCreateNewUser() {
		
		final User user = userService.insertUser(mockData.createUser());
		
		assertNotNull("Failed to create user", user);
		assertNotNull("Token not created", user.getVerifyToken());
		assertTrue("Failed to set access permission", user.getEnabled().equals(Boolean.FALSE));
		
		
	}

}
