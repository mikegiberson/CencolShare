package com.cencolshare.service;

import java.math.BigInteger;
import java.util.List;

import com.cencolshare.model.Group;
import com.cencolshare.model.User;


public interface GroupService {

	List<Group> getAllGroupsByUser(final User user);
	
	List<Group> searchGroupsByNameDescription(String groupName);
	
	Group saveGroup(Group grp);
	
	Group getGroupById(Long groupId);
	
	boolean deleteGroupbyID(Long groupId);
	
	boolean removeUserFromGroup(long userId , long groupId);
	
	public Boolean addUserToGroup(long userId, long groupId);
	
	public BigInteger getMemberCountbyGroupId(long groupId);
}
