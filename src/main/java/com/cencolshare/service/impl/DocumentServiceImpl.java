package com.cencolshare.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cencolshare.model.Document;
import com.cencolshare.repository.DocumentRepository;
import com.cencolshare.service.DocumentService;


@Service
public class DocumentServiceImpl implements DocumentService {
	
	@Resource
	private DocumentRepository documentRepository;

	@PersistenceContext
	EntityManager em;
	
	@Override
	@Transactional
	public List<Document> findAll(){
		return (List<Document>) documentRepository.findAll();
	
	}

	@Override
	public List<Document> searchDocumentByNameDescription(String search) {
		
		final String query = "SELECT * FROM tbl_document WHERE document_description LIKE '%"+search+"%' OR document_title LIKE '%"+search+"%'";
		final Query q = em.createNativeQuery(query, Document.class);
		return q.getResultList();

	}


}
