package com.cencolshare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cencolshare.service.DocumentService;

@Controller
@RequestMapping("/docs")
public class DocumentController {
	
	@Autowired
	DocumentService documentService;
	
	@RequestMapping(value={"/list"}, method=RequestMethod.GET)
	public ModelAndView showDashboard() {
		ModelAndView mav = new ModelAndView("docs/list");
		
		mav.addObject("documentList",documentService.findAll());
		return mav;
	}
		
	@RequestMapping(value="/upload", method=RequestMethod.GET)
	public ModelAndView uploadDocs() {
		ModelAndView mav = new ModelAndView("docs/document-upload");
		return mav;
	}

}
