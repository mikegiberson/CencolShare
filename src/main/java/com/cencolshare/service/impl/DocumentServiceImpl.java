package com.cencolshare.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cencolshare.model.Document;
import com.cencolshare.model.Group;
import com.cencolshare.model.User;
import com.cencolshare.repository.DocumentRepository;
import com.cencolshare.service.DocumentService;

@Service
public class DocumentServiceImpl implements DocumentService {
	@PersistenceContext
	EntityManager em;
	@Resource
	private DocumentRepository documentRepository;

	/*
	 * @Override
	 * 
	 * @Transactional public List<Document> findAllDocumentByUser(final int
	 * userId){
	 * 
	 * final String query =
	 * "SELECT * FROM tbl_document WHERE user_id = userId && group_id = null";
	 * final Query q = em.createNativeQuery(query, Document.class); return
	 * q.getResultList();
	 * 
	 * }
	 */
	@Override
	@Transactional
	public List<Document> findAllDocumentByUser(final User user) {
		return (List<Document>) documentRepository.findByUser(user);

	}

	public Document saveDocument(Document doc) {
		doc = documentRepository.save(doc);
		return doc;
	}

	@Override
	public List<Document> searchDocumentByNameDescription(String search) {

		final String query = "SELECT * FROM tbl_document WHERE document_description LIKE '%"
				+ search + "%' OR document_title LIKE '%" + search + "%'";
		final Query q = em.createNativeQuery(query, Document.class);
		return q.getResultList();

	}

	@Override
	public boolean deleteDocumentbyID(Long documentId) {
		documentRepository.delete(documentId);
		return true;
	}

	@Override
	public Document getDocumentById(long documentId) {

		return documentRepository.findOne(documentId);
	}

	@Override
	public List<Document> getDocumentByGroup(Group group) {
		// TODO Auto-generated method stub
		return documentRepository.findByGroup(group);
	}

}
