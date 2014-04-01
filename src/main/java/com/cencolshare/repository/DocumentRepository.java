package com.cencolshare.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cencolshare.model.Document;
import com.cencolshare.model.Group;
import com.cencolshare.model.User;


public interface DocumentRepository extends CrudRepository<Document, Long>{

	List<Document> findByUser (User user);
	
	List<Document> findByGroup(Group group);
}