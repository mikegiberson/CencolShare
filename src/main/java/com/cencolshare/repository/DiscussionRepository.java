package com.cencolshare.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cencolshare.model.Discussion;
import com.cencolshare.model.Group;
import com.cencolshare.model.User;

public interface DiscussionRepository extends CrudRepository<Discussion, Integer>{
	
	List<Discussion> findByGroup(Group group);
	
	List<Discussion> findByUser(User user);

}
