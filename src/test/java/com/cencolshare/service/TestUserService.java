package com.cencolshare.service;

import static org.junit.Assert.*;

import java.util.List;

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
	
	@Test
	public void testgetUserById()
	{
		final User user = userService.insertUser(mockData.createUser());
		assertNotNull("Create User failed", user);

		final User userById = userService.loadUserById(user.getUserId());
		assertNotNull(userById);
		
		assertEquals(userById.getFirstName(),user.getFirstName());
		assertEquals(userById.getLastName(),user.getLastName());
		assertEquals(userById.getEmail(),user.getEmail());
		assertEquals(userById.getEnabled(),user.getEnabled());
		assertEquals(userById.getPassword(),user.getPassword());
		assertEquals(userById.getPhoto(),user.getPhoto());
		assertEquals(userById.getVerifyToken(),user.getVerifyToken());
	}
	
	@Test
	public void testGetAllUsers(){
		final User user = userService.insertUser(mockData.createUser());
		assertNotNull("Create User failed", user);
		
		List<User> allUsers = userService.getAllUsers();
		assertNotNull(allUsers);
		
		assertEquals(allUsers.get(0).getEmail(), user.getEmail());
		assertEquals(allUsers.get(0).getUserId(), user.getUserId());
	}

}
