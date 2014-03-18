package com.cencolshare.service;

import static org.junit.Assert.*;

import java.util.List;

import javax.swing.text.EditorKit;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cencolshare.init.BaseTestCase;
import com.cencolshare.model.Discussion;
import com.cencolshare.model.Group;
import com.cencolshare.model.User;
import com.github.javafaker.Faker;

public class TestGroupService extends BaseTestCase {

	@Autowired
	private UserService userService;
	
	@Autowired 
	private GroupService groupService;
	
	@Test
	public void testCreateGroup() {
		final User user = userService.insertUser(mockData.createUser());
		Group grp = mockData.createGroup();
		grp.setUser(user);
		final Group group = groupService.saveGroup(grp);
		
		assertNotNull("Create Group failed", group);
		
		
	}

	@Test
	public void testgetAllGroupsByUser()
	{
		final User user = userService.insertUser(mockData.createUser());
		Group grp = mockData.createGroup();
		grp.setUser(user);	
		final Group group = groupService.saveGroup(grp);
		assertNotNull("Create Group failed", group);
		
		final List<Group> groups= groupService.getAllGroupsByUser(user);
		assertNotNull(groups);
		assertEquals(groups.size()>0, true);
		assertEquals(group.getGroupName(),groups.get(0).getGroupName());
		assertEquals(group.getGroupDescription(),groups.get(0).getGroupDescription());
		assertEquals(group.getUser().getUserId(), groups.get(0).getUser().getUserId());
		
	}
	
	@Test
	public void testsearchGroupsByNameDescription()
	{
		final User user = userService.insertUser(mockData.createUser());
		Group grp = mockData.createGroup();
		grp.setUser(user);	
		final Group group = groupService.saveGroup(grp);
		assertNotNull("Create Group failed", group);
		
		final List<Group> groups= groupService.searchGroupsByNameDescription(group.getGroupDescription());
		assertNotNull(groups);
		assertEquals(groups.size()>0, true);
		assertEquals(group.getGroupName(),groups.get(0).getGroupName());
		assertEquals(group.getGroupDescription(),groups.get(0).getGroupDescription());
		assertEquals(group.getUser().getUserId(), groups.get(0).getUser().getUserId());
		
	}
	
	@Test
	public void testgetGroupById()
	{
		final User user = userService.insertUser(mockData.createUser());
		Group grp = mockData.createGroup();
		grp.setUser(user);	
		final Group group = groupService.saveGroup(grp);
		assertNotNull("Create Group failed", group);
		
		final Group grpById = groupService.getGroupById(group.getGroupId());
		assertNotNull(grpById);
		
		assertEquals(grpById.getGroupName(),group.getGroupName());
		assertEquals(grpById.getGroupDescription(),group.getGroupDescription());
		assertEquals(grpById.getGroupId(),group.getGroupId());
		
	}
	
	@Test
	public void testdeleteGroupbyID()
	{
		final User user = userService.insertUser(mockData.createUser());
		Group grp = mockData.createGroup();
		grp.setUser(user);	
		final Group group = groupService.saveGroup(grp);
		assertNotNull("Create Group failed", group);
		
		groupService.deleteGroupbyID(group.getGroupId());
		assertNull(groupService.getGroupById(group.getGroupId()));
		
	}
	
	@Test
	public void testEditGroup() {

		final User user = userService.insertUser(mockData.createUser());
		Group grp = mockData.createGroup();
		grp.setUser(user);	
		final Group group = groupService.saveGroup(grp);
		assertNotNull("Create Group failed", group);
		
		final Group grpById = groupService.getGroupById(group.getGroupId());
		assertNotNull(grpById);
		
		assertEquals(grpById.getGroupName(),group.getGroupName());
		assertEquals(grpById.getGroupDescription(),group.getGroupDescription());
		assertEquals(grpById.getGroupId(),group.getGroupId());
		
		final Group editGroup = grpById;
		editGroup.setGroupDescription("description");
		editGroup.setGroupName("group");
		editGroup.setGroupImage("");
		
		final Group updatedGroup=groupService.saveGroup(editGroup);
		assertNotNull(updatedGroup);
		assertEquals(editGroup.getGroupName(), updatedGroup.getGroupName());
		assertEquals(editGroup.getGroupDescription(), updatedGroup.getGroupDescription());
		assertEquals(editGroup.getGroupImage(),updatedGroup.getGroupImage());
		assertEquals(editGroup.getGroupId(), updatedGroup.getGroupId());
		
		
		
	}

}
