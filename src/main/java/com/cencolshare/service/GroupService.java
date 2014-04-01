package com.cencolshare.service;

import java.math.BigInteger;
import java.util.List;

import com.cencolshare.model.Group;
import com.cencolshare.model.User;
import com.cencolshare.model.response.GroupFeed;


public interface GroupService {

	List<Group> getAllGroupsByUser(final User user);
	
	List<Group> searchGroupsByNameDescription(String groupName);
	
	Group saveGroup(Group grp);
	
	Group getGroupById(Long groupId);
	
	boolean deleteGroupbyID(Long groupId);
	
	boolean removeUserFromGroup(long userId , long groupId);
	
	public Boolean addUserToGroup(long userId, long groupId);
	
	public BigInteger getMemberCountbyGroupId(long groupId);
	
	public List<User> getAllMembersOfGroup(long groupId);
	
	public List<GroupFeed> getFeedsByGroup(Group group, User user);
	
	public Boolean isAdminOfGroup(Group group, User user);
	
	public List<Group> getjoinedGroups(int userId);
	
}
