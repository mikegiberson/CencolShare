package com.cencolshare.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import com.cencolshare.model.Discussion;
import com.cencolshare.service.DocumentService;
>>>>>>> 3c0f5a019fdd8cd3a3ac9640f9d63dd4a7f25b0b

@Controller
@RequestMapping("/docs")
public class DocumentController extends BaseController {
	
	@Autowired
	DocumentService documentService;
	
	@RequestMapping(value={"/list"}, method=RequestMethod.GET)
	public ModelAndView showDashboard() {
		ModelAndView mav = new ModelAndView("docs/list");
		
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
		ModelAndView mav = new ModelAndView("docs/document-upload");
		return mav;
	}
	
}
