package com.cencolshare.service;

import java.util.List;

import com.cencolshare.model.Document;
import com.cencolshare.model.Group;

public interface DocumentService {

	public List<Document> findAll();
	
	public Document saveDocument( Document doc);

	public List<Document> searchDocumentByNameDescription(String search);
}
