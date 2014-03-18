package com.cencolshare.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.cencolshare.model.Document;
import com.cencolshare.model.Upload;
import com.cencolshare.model.User;
import com.cencolshare.service.DocumentService;
import com.cencolshare.util.GroupUtil;

@Controller
@RequestMapping("/docs")
public class DocumentController extends BaseController {
	
	@Autowired
	DocumentService documentService;
	
	@Autowired
	HttpServletRequest request;
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public ModelAndView listDocument() {
		ModelAndView mav = new ModelAndView("docs/document-list");
		User user=getLoggedInUser();
		List<Document> documents = documentService.findAllDocumentByUser(user);
		mav.addObject("documents",documents);
		return mav;
	}
			
	@RequestMapping(value="/upload", method=RequestMethod.GET)
	public ModelAndView uploadDocs() {
		ModelAndView mav = new ModelAndView("docs/document-upload");
		return mav;
	}
	
		
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public ModelAndView saveDoc() {
		User user = getLoggedInUser();
		Upload upload = new Upload();
		upload.setFileName("java");
		upload.setFilePath("path");
		upload.setFileSize("123");
		upload.setFileType(".pdf");
		upload.setOriginalFileName("Java for beginner");
		upload.setUploadDate(new Date());
		
		Document doc= new Document();
		doc.setDocumentTitle(request.getParameter("documentTitle"));
		doc.setDocumentDescription(request.getParameter("documentDescription"));
		doc.setTag(request.getParameter("tag"));
		doc.setUser(user);
		doc.setDateUploaded(new Date());
		doc.setFileUrl("htttp://www.");
		doc.setUpload(upload);
	
		
		if(!request.getParameter("documentId").equals("")) {
			doc.setDocumentId(Integer.parseInt(request.getParameter("documentId")));
		}
		
		doc = documentService.saveDocument(doc);
		if(doc.getDocumentId() > 0) {
			return new ModelAndView(new RedirectView("list"));
		}
		return null;
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public ModelAndView deleteDocument(@PathVariable Integer id) {
		documentService.deleteDocumentbyID(id);
		return new ModelAndView(new RedirectView("/cencolshare/docs/list"));
	}

}
