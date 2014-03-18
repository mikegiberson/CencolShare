package com.cencolshare.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.cencolshare.model.Document;

import com.cencolshare.model.User;
import com.cencolshare.service.DocumentService;

@Controller
@RequestMapping("/docs")
public class DocumentController extends BaseController {
	
	@Autowired
	DocumentService documentService;
	
	@Autowired
	HttpServletRequest request;
	
	@RequestMapping(value={"/list"}, method=RequestMethod.GET)
	public ModelAndView listDocument() {
		ModelAndView mav = new ModelAndView("document/index");
		
		mav.addObject("documentList",documentService.findAll());
		return mav;
	}
	
	@RequestMapping(value = "/preview", method = RequestMethod.GET)
	public ModelAndView discussionListPage() {
		ModelAndView mav = new ModelAndView("document/document-preview");
		mav.addObject("title", "hello");
		return mav;
	}
		
	@RequestMapping(value="/upload", method=RequestMethod.GET)
	public ModelAndView uploadDocs() {
		ModelAndView mav = new ModelAndView("document/document-upload");
		return mav;
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public ModelAndView saveDoc() {
		
		User user = getLoggedInUser();
		Document doc= new Document();
		doc.setDocumentTitle(request.getParameter("documentTitle"));
		doc.setDocumentDescription(request.getParameter("documentDescription"));
		doc.setTag(request.getParameter("tag"));
		doc.setUser(user);
		
		if(!request.getParameter("documentId").equals("")) {
			doc.setDocumentId(Integer.parseInt(request.getParameter("documentId")));
		}
		
		doc = documentService.saveDocument(doc);
		if(doc.getDocumentId() > 0) {
			return new ModelAndView(new RedirectView("list"));
		}
		return null;
	}

}
