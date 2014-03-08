package com.cencolshare.service;

import java.util.List;

import com.cencolshare.model.Group;
import com.cencolshare.model.User;


public interface GroupService {

	List<Group> getAllGroupsByUser(final User user);
	
	Group saveGroup(Group grp);
	
	Group getGroupById(Long groupId);
	
}
