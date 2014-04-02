package com.cencolshare.service;

import java.util.List;

import com.cencolshare.model.Document;
import com.cencolshare.model.Group;
import com.cencolshare.model.User;

public interface DocumentService {

	//public List<Document> findAllDocumentByUser(final User user);
	public List<Document> findAllDocumentByUser( int userId);
	
	public List<Document> findAllDocumentInGroup(long groupId);
	
	public Document saveDocument( Document doc);

	public List<Document> searchDocumentByNameDescription(String search);

	boolean deleteDocumentbyID(Long id);
	
	public Document getDocumentById(long Id);
	
	public List<Document> getDocumentByGroup(Group group);
	
	public String getUsedSpaceByUser(User user);
}
