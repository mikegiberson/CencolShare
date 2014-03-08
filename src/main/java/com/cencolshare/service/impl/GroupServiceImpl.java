package com.cencolshare.service.impl;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cencolshare.model.Group;
import com.cencolshare.model.User;
import com.cencolshare.repository.GroupRepository;
import com.cencolshare.service.GroupService;
import com.cencolshare.service.UserService;

@Service
@Slf4j
public class GroupServiceImpl implements GroupService {

	@Autowired
	GroupRepository groupRepository;
	
	public Group saveGroup(Group grp) {
		grp = groupRepository.save(grp);
		log.debug("New Group saved by group service: {}", grp.getGroupName());
		return grp;
	}
	
	public Group getGroupById(Long groupId) {
		final Group grp = groupRepository.findOne(groupId);
		return grp;
	}


	@Override
	public List<Group> getAllGroupsByUser(final User user) {
		
		final List<Group> groups= (List<Group>) groupRepository.findByUser(user);
		log.debug("groups count: {}", groups.size());
		return groups;
	}
	
	

}
