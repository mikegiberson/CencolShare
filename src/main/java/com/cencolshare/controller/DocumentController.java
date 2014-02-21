package com.cencolshare.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cencolshare.exception.ShopNotFound;
import com.cencolshare.model.Document;
import com.cencolshare.model.Shop;
import com.cencolshare.service.DocumentService;
import com.cencolshare.service.ShopService;
import com.cencolshare.validation.ShopValidator;

@Controller
@RequestMapping(value="/document")
public class DocumentController {
	
	@Autowired
	private DocumentService documentService;

	@RequestMapping(value="/list", method=RequestMethod.GET)
	public ModelAndView documentListPage() {
		ModelAndView mav = new ModelAndView("document/document-list");
		List<Document> documentList =  documentService.findAll();
		mav.addObject("documentList", documentList);
		return mav;
	}
	
	@RequestMapping(value="/upload", method=RequestMethod.GET)
	public ModelAndView documentUploadPage() {
		ModelAndView mav = new ModelAndView("document/document-upload");
		//List<Document> documentList =  documentService.findAll();
		//mav.addObject("documentList", documentList);
		return mav;
	}

}
