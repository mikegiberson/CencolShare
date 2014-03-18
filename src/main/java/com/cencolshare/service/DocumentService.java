package com.cencolshare.service;

import java.util.List;

import com.cencolshare.model.Document;
import com.cencolshare.model.User;

public interface DocumentService {

	public List<Document> findAllDocumentByUser(final User user);
	
	public Document saveDocument( Document doc);
	
	public Document getDocumentById(int documentId);

	public List<Document> searchDocumentByNameDescription(String search);

	boolean deleteDocumentbyID(Integer id);
}
