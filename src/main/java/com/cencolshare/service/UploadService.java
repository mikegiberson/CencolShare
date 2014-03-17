package com.cencolshare.service;

import com.cencolshare.model.Upload;

public interface UploadService {

	Upload saveUpload(Upload upload);
	void deleteUpload(Long id);
	Upload getUploadById(Long id);
	Upload insertUpload(Upload upload);

}
