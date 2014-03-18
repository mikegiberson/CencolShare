package com.cencolshare.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cencolshare.model.Upload;
import com.cencolshare.model.User;
import com.cencolshare.repository.UploadRepository;
import com.cencolshare.service.UploadService;

@Service
public class UploadServiceImpl implements UploadService {

	@Autowired
	UploadRepository uploadRepository;
	
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

}


