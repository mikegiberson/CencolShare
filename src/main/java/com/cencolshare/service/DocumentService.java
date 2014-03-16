package com.cencolshare.service;

import java.util.List;

import com.cencolshare.model.Discussion;
import com.cencolshare.model.Document;

public interface DocumentService {

	public List<Document> findAll();
	
	public List<Document> searchDocumentByNameDescription(String search);

}
