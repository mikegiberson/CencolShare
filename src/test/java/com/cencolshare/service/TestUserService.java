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
	
	@Test
	public void testEditUserProfile() {
		
		final User user = userService.insertUser(mockData.createUser());
		String actualUserOccupation = user.getOccupation();
		String actualOrganization = user.getOrganization();
		
		String newFirstName = "Sonny";
		String newLastName = "Raju";
		String newOccupation = "Developer";
		String newOrganization = "CencolShare";
		
		user.setFirstName(newFirstName);
		user.setLastName(newLastName);
		user.setOccupation(newOccupation);
		user.setOrganization(newOrganization);
		final User updatedUser = userService.insertUser(user);
		
		assertNotNull("Failed to update user", user);
		assertFalse("Failed to update Occupation", updatedUser.getOccupation().equals(actualUserOccupation));
		assertFalse("Failed to update Organization", updatedUser.getOrganization().equals(actualOrganization));
	}

}
