package com.cencolshare.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cencolshare.model.Discussion;

@Controller
@RequestMapping("/docs")
public class DocumentController {
	
	@RequestMapping(value={"", "index"}, method=RequestMethod.GET)
	public ModelAndView showDashboard() {
		ModelAndView mav = new ModelAndView("docs/index");
		return mav;
	}
	
	@RequestMapping(value = "/preview", method = RequestMethod.GET)
	public ModelAndView discussionListPage() {
		ModelAndView mav = new ModelAndView("document/document-preview");
		mav.addObject("title", "hello");
		return mav;
	}

}
