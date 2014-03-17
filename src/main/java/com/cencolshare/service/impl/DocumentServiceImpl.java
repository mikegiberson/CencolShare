package com.cencolshare.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cencolshare.exception.ShopNotFound;
import com.cencolshare.model.Document;
import com.cencolshare.model.Group;
import com.cencolshare.model.User;
import com.cencolshare.repository.DocumentRepository;
import com.cencolshare.service.DocumentService;


@Service
public class DocumentServiceImpl implements DocumentService {
	
	@Resource
	private DocumentRepository documentRepository;
	
	@Override
	@Transactional
	public List<Document> findAllDocumentByUser(final User user){
		return (List<Document>) documentRepository.findByUser(user);
	
	}
	
	public Document saveDocument (Document doc){
		doc = documentRepository.save(doc);
		return doc;
	}


}
