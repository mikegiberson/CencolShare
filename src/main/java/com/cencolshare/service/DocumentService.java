package com.cencolshare.service;

import java.util.List;

import com.cencolshare.model.Document;
import com.cencolshare.model.Group;
import com.cencolshare.model.User;

public interface DocumentService {

	public List<Document> findAllDocumentByUser(final User user);
	
	public Document saveDocument( Document doc);
	
	

	public List<Document> searchDocumentByNameDescription(String search);
}
