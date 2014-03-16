package com.cencolshare.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.cencolshare.model.Group;
import com.cencolshare.model.User;


public interface GroupRepository extends CrudRepository<Group, Long> {

	List<Group> findAll();
	
	List<Group> findByUser(User userID);
	
	List<Group> findByGroupName(String groupName);	
	

}
