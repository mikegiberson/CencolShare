package com.cencolshare.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cencolshare.enums.Role;
import com.cencolshare.init.BaseTestCase;
import com.cencolshare.model.Document;
import com.cencolshare.model.Upload;
import com.cencolshare.model.User;


public class TestDocumentService extends BaseTestCase {
	//@Test
		
	@Autowired
	private DocumentService documentService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UploadService uploadService;
	
	@Test
	public void testSaveDocument()
	{
		final User user = userService.insertUser(mockData.createUser());
		final Upload upload =  uploadService.insertUpload(mockData.createUpload());
		Document document = mockData.createDocument();
		document.setUser(user);
		document.setUpload(upload);
		final Document doc = documentService.saveDocument(document);
		assertNotNull(doc);
		
		
		
	}
	
	@Test
	public void testFindAllDocumentByUSer()
	{
		final User user = userService.insertUser(mockData.createUser());
		int userId = user.getUserId();
		final Upload upload =  uploadService.insertUpload(mockData.createUpload());
		Document document = mockData.createDocument();
		document.setUser(user);
		document.setUpload(upload);
		final Document doc = documentService.saveDocument(document);
		assertNotNull(doc);
		
		final List<Document> docs = documentService.findAllDocumentByUser(userId);
		
		assertNotNull(docs);
		assertEquals(docs.size() > 0, true);
		assertEquals(doc.getDocumentId(), docs.get(0).getDocumentId());
		assertEquals(doc.getDocumentTitle(), docs.get(0).getDocumentTitle());
		assertEquals(doc.getDateUploaded(), docs.get(0).getDateUploaded());
		assertEquals(doc.getDocumentDescription(), docs.get(0).getDocumentDescription());
		assertEquals(doc.getTag(), docs.get(0).getTag());
		
		
	}
	
	
	
	
	
	
	

}
