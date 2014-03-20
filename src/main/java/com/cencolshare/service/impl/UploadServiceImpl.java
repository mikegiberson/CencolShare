package com.cencolshare.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cencolshare.model.Group;
import com.cencolshare.model.Upload;
import com.cencolshare.model.User;
import com.cencolshare.repository.UploadRepository;
import com.cencolshare.service.UploadService;

@Service
public class UploadServiceImpl implements UploadService {

	@Autowired
	UploadRepository uploadRepository;
	
	@PersistenceContext
	EntityManager em;
	
	@Override
	public Upload saveUpload(Upload upload) {
		return uploadRepository.save(upload);
	}

	@Override
	public void deleteUpload(Long id) {
		uploadRepository.delete(id);
	}

	@Override
	public Upload getUploadById(Long id) {
		return uploadRepository.findOne(id);
	}
	
	@Override
	public Upload insertUpload(Upload upload) {

		final Upload u = uploadRepository.save(upload);
		return u;
	}
	
	@Override
	public Long getTheMostRecentUploadId(){
		final String query = "SELECT upload_id FROM tbl_upload ORDER BY upload_id DESC LIMIT 1";
		final Query q = em.createNativeQuery(query, Upload.class);
		return Long.parseLong(q.getResultList().get(0).toString());
		
	}

}


