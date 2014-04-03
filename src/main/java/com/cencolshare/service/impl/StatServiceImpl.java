package com.cencolshare.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cencolshare.model.User;
import com.cencolshare.model.response.StatResponse;
import com.cencolshare.service.DiscussionService;
import com.cencolshare.service.DocumentService;
import com.cencolshare.service.GroupService;
import com.cencolshare.service.StatService;
import com.cencolshare.service.UserService;

@Component
public class StatServiceImpl implements StatService {

	@Autowired
	GroupService groupService;
	
	@Autowired
	DiscussionService discussionService;
	
	@Autowired
	DocumentService documentService;
	
	@Autowired
	UserService userService;
	
	@Override
	public StatResponse getStatistics(User user) {
		
		final StatResponse statResponse = new StatResponse();
		
		int groupsCount = groupService.getAllGroupsByUser(user).size();
		int documentsCount = documentService.findAllDocumentByUser(user.getUserId()).size();
		int discussionsCount = discussionService.getAllDiscussions(user).size();
		int ownedGroupsCount = groupService.getAllGroupsByUser(user).size();
		String usedSpace = documentService.getUsedSpaceByUser(user);
		
		statResponse.setGroupsCount(groupsCount);
		statResponse.setDocumentsCount(documentsCount);
		statResponse.setDiscussionsCount(discussionsCount);
		statResponse.setOwnedGroupsCount(ownedGroupsCount);
		statResponse.setUsedSpace(usedSpace);
		
		return statResponse;
	}

}
