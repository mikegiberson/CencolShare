package com.cencolshare.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.cencolshare.model.Document;
import com.cencolshare.model.Upload;
import com.cencolshare.service.DocumentService;
import com.cencolshare.service.GroupService;
import com.cencolshare.service.UploadService;
import com.cencolshare.service.UserService;

@Controller
@RequestMapping("/upload")
@Slf4j
public class UploadController extends BaseController {

	@Autowired
	UploadService uploadService;

	@Autowired
	DocumentService documentService;

	@Autowired
	UserService userService;

	@Autowired
	HttpServletRequest request;

	@Value("${uploadPath}")
	private String UPLOAD_PATH;

	@RequestMapping(value = "/do", method = RequestMethod.POST)
	@ResponseBody
	public Upload upload(
			@RequestParam("file") final MultipartFile multipartFile,
			ModelMap model) throws IOException {

		if (getLoggedInUser() == null) {
			return null;
		}

		String contentType = multipartFile.getContentType();
		String fileName = multipartFile.getOriginalFilename().trim();
		String ext = fileName.substring(fileName.lastIndexOf("."));
		fileName = fileName.substring(0, fileName.lastIndexOf("."));

		fileName = System.currentTimeMillis() + ext;

		if (!fileName.equals("")) {
			File fileToCreate = new File(UPLOAD_PATH, fileName);

			if (!fileToCreate.exists()) {
				FileOutputStream fileOutStream = null;

				fileOutStream = new FileOutputStream(fileToCreate);
				fileOutStream.write(multipartFile.getBytes());
				fileOutStream.flush();
				fileOutStream.close();

				final Upload upload = new Upload();
				upload.setContentType(contentType);
				upload.setFileName(fileName);
				upload.setFileType(ext);
				upload.setFileSize(fileToCreate.length() / 1024 + " kb");
				upload.setOriginalFileName(multipartFile.getOriginalFilename()
						.trim());
				upload.setUploadDate(new Date(new Date().getTime()));
				upload.setFilePath(UPLOAD_PATH + fileName);

				uploadService.saveUpload(upload);
				return upload;

			}
		}
		return null;
	}

	@RequestMapping(value = "/fetch/{fileId}", method = RequestMethod.GET)
	public String displayFile(@PathVariable Long fileId,
			HttpServletResponse response) throws IOException {
		/*
		if (getLoggedInUser() == null) {
			return "access_denied.jsp?error=LOGIN_FAILURE";
		}
		*/
		final Upload upload = uploadService.getUploadById(fileId);
		final Document document = documentService.getDocumentByUpload(upload);
		/*
		if(document != null) {
			// if the request is not for a document, there is no need for a authenticity check
			// for eg: request for a profile picture
			
			if (document.getUser().getUserId() == getLoggedInUser().getUserId()) {
				// loggedin user is the owner of the document. allow to download
				System.out.println("loggedin user is the owner of the document. allow to download");

			} else if (document.getGroup() != null
					&& userService.isUserMemberOfGroup(getLoggedInUser(),
							document.getGroup())) {
				// this document is shared in a group, so allow all its memebers to
				// download
				System.out.println("this document is shared in a group, so allow all its memebers to download");

			} else {
				System.out.println("No access to download the requested file");
				//return "access_denied.jsp?error=NO_ACCESS";
			}
		}
		*/

		if (upload == null) {
			return null;
		}
		response.setContentType(upload.getContentType());
		response.setHeader("Content-disposition", "attachment; filename="
				+ upload.getOriginalFileName());
		File my_file = new File(upload.getFilePath());

		OutputStream out = response.getOutputStream();
		FileInputStream in = new FileInputStream(my_file);
		byte[] buffer = new byte[4096];
		int length;
		while ((length = in.read(buffer)) > 0) {
			out.write(buffer, 0, length);
		}
		in.close();
		out.flush();

		return null;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
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

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
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
