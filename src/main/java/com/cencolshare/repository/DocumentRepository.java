package com.cencolshare.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cencolshare.model.Document;
import com.cencolshare.model.User;


public interface DocumentRepository extends CrudRepository<Document, Integer>{

	List<Document> findByUser (User user);
}