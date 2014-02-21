package com.cencolshare.service;

import java.util.List;

import com.cencolshare.model.Group;


public interface GroupService {

	List<Group> getAllGroups();
	
	Group saveGroup(Group grp);
	
	Group getGroupById(Long groupId);
}
