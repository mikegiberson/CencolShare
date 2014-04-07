package com.cencolshare.service.impl;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cencolshare.model.Document;
import com.cencolshare.model.Group;
import com.cencolshare.model.Upload;
import com.cencolshare.model.User;
import com.cencolshare.repository.DocumentRepository;
import com.cencolshare.service.DocumentService;


@Service
@Transactional
public class DocumentServiceImpl implements DocumentService {
	
	@PersistenceContext
	 EntityManager em;
	
	@Resource
	private DocumentRepository documentRepository;
	
	@Override
	@Transactional
	public List<Document> findAllDocumentByUser(final int userId){
	  
	  final String query = "SELECT * FROM tbl_document WHERE user_id =" +userId+" AND group_id IS NULL" ;
	  final Query q = em.createNativeQuery(query, Document.class);
	  return q.getResultList();
	
	}
	
	public List<Document> findAllDocumentInGroup(long groupId){
		  
		  final String query = "SELECT * FROM tbl_document WHERE group_id = " + groupId ;
		  final Query q = em.createNativeQuery(query, Document.class);
		  return q.getResultList();
		
		}
	
	public Document saveDocument (Document doc){
		doc.setDateUploaded(new Date());
		doc = documentRepository.save(doc);
		return doc;
	}

	
	@Override 
	 public List<Document> searchDocumentByNameDescription(String search) {
	  
	  final String query = "SELECT * FROM tbl_document WHERE document_description LIKE '%"+search+"%' OR document_title LIKE '%"+search+"%'";
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

	@Override
	public boolean deleteCommentById(int commentId) {
		final String query = "DELETE FROM document_to_comment WHERE comment_id = " + commentId;
		final Query q = em.createNativeQuery(query);
		q.executeUpdate();
		
		final String query2 = "DELETE FROM tbl_comment WHERE comment_id = " + commentId;
		final Query q2 = em.createNativeQuery(query2);		
		q2.executeUpdate();
		return true;
	}
	public String getUsedSpaceByUser(User user) {
			
		DecimalFormat df = new DecimalFormat("###.##");
		
		double usedSpaceinKb = documentRepository.getUsedSpaceByUser(user.getUserId());
		System.out.println("Used " + usedSpaceinKb + " kb");
		if(usedSpaceinKb < 1024) {
			return df.format(usedSpaceinKb) + " KB";
		}
		else if (usedSpaceinKb >= 1024 && usedSpaceinKb < 1048576) {
			return df.format(usedSpaceinKb / 1024) + " MB";
		} else {
			return df.format(usedSpaceinKb / 131072) + " GB";
		}
		
	}

	@Override
	public Document getDocumentByUpload(Upload upload) {
		// TODO Auto-generated method stub
		return documentRepository.findByUpload(upload);
	}

}
