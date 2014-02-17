package com.cencolshare.service.impl;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cencolshare.model.Group;
import com.cencolshare.repository.GroupRepository;
import com.cencolshare.service.GroupService;

@Service
@Slf4j
public class GroupServiceImpl implements GroupService {

	@Autowired
	GroupRepository groupRepository;
	
	public List<Group> getAllGroups() {
		final List<Group> groups= (List<Group>) groupRepository.findAll();
		log.debug("groups count: {}", groups.size());
		return groups;
	}

}
