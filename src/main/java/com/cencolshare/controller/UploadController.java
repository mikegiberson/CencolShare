package com.cencolshare.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.cencolshare.model.Upload;
import com.cencolshare.service.UploadService;
import com.cencolshare.util.S3UploadUtil;

@Controller
@RequestMapping("/upload")
@Slf4j
public class UploadController {
	
  @Autowired
  UploadService uploadService;

  @RequestMapping(value="/do", method = RequestMethod.POST)
  @ResponseBody
  public Upload upload(@RequestParam ("file") final MultipartFile multipartFile, ModelMap model) throws IOException {
    
    String contentType = multipartFile.getContentType();
    String fileName = multipartFile.getOriginalFilename().trim();
    String ext=fileName.substring(fileName.lastIndexOf("."));
    fileName=fileName.substring(0,fileName.lastIndexOf("."));
    byte[] fileData = null;

    int len = fileName.length();
    fileName = System.currentTimeMillis() + ext;
    try {
     fileData  = multipartFile.getBytes();
     ByteArrayInputStream input = new ByteArrayInputStream(multipartFile.getBytes());
     S3UploadUtil.getInstance().uploadFile(input,fileName);

    } catch (IOException e) {
      e.printStackTrace();
    }
    
    Upload upload = new Upload();
    upload.setFileName(fileName);
    upload.setOriginalFileName(multipartFile.getOriginalFilename().trim());
    upload.setFileType(ext);
    upload.setFilePath("https://s3.amazonaws.com/cencolshare/" + fileName);
    upload.setUploadDate(new Date());
    
    upload = uploadService.saveUpload(upload);
    
    
    return upload;
  }

  @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
  @ResponseBody
  public HashMap<String, Boolean> deleteUpload(@PathVariable Long id) {
	  HashMap<String, Boolean> result = new HashMap<String, Boolean>();
	  try {
		uploadService.deleteUpload(id);
		result.put("result", true);
	} catch (Exception e) {
		result.put("result", false);
	}
    return result;
  }
  
  @RequestMapping(value="/{id}", method = RequestMethod.GET)
  @ResponseBody
  public Upload getUpload(@PathVariable Long id) {
	  Upload upload = null;
	  try {
		upload = uploadService.getUploadById(id);		
	} catch (Exception e) {
		log.debug(e.getMessage());
	}
    return upload;
  }
  
}
