package com.cencolshare.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cencolshare.model.Group;

@Controller
@RequestMapping("/docs")
public class DocumentController extends BaseController {
	
	@RequestMapping(value={"", "index"}, method=RequestMethod.GET)
	public ModelAndView showDashboard() {
		ModelAndView mav = new ModelAndView("docs/index");
		return mav;
	}
	
//	@RequestMapping(value="/search", method=RequestMethod.GET)
//	public ModelAndView searchDocument() {
//		System.out.println("value to search:"+request.getParameter("searchInput"));
//		List<Group> groups=documentService.searchGroupsByNameDescription(request.getParameter("searchInput"));
//		ModelAndView mav = new ModelAndView("group/search-document");
//		mav.addObject("groups", groups);	
//		return mav;
//	}

}
