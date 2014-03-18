package com.cencolshare.controller;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cencolshare.model.Discussion;
import com.cencolshare.model.Document;
import com.cencolshare.model.Group;
import com.cencolshare.service.DiscussionService;
import com.cencolshare.service.DocumentService;
import com.cencolshare.service.GroupService;

@Controller
@Slf4j
public class NavigationController extends BaseController {

	@Autowired
	GroupService groupService;
	
	@Autowired
	DocumentService documentService;

	@Autowired
	DiscussionService discussionService;
	
	@RequestMapping(value={"/", "index"}, method=RequestMethod.GET)
	public ModelAndView index() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		log.debug(auth.toString());
		return new ModelAndView("index");
	}
	
	@RequestMapping(value="/search", method=RequestMethod.GET)
	public ModelAndView searchGroup() {
		final String searchInput = request.getParameter("searchInput");
		final String searchType = request.getParameter("searchType");
		log.debug("value to search: {}", searchInput);
		log.debug("type to search: {}", searchType);
		
		ModelAndView mav = null;
		if(searchType.toLowerCase().equals("group")) {
			List<Group> groups=groupService.searchGroupsByNameDescription(searchInput);
			log.debug("search count: {}", groups.size());
			mav = new ModelAndView("group/search-group");
			mav.addObject("groups", groups);	
		} else if(searchType.toLowerCase().equals("document")) {
			List<Document> documents = documentService.searchDocumentByNameDescription(searchInput);
			mav = new ModelAndView("document/search-document");
			log.debug("search count: {}", documents.size());
			mav.addObject("documents", documents);	
		} else if(searchType.toLowerCase().equals("discussion")) {
			List<Discussion> discussions =discussionService.searchDiscussionByNameDescription(searchInput);
			mav = new ModelAndView("discussion/search-discussion");
			log.debug("search count: {}", discussions.size());
			mav.addObject("discussions", discussions);			
		}
		
		
		return mav;
	}

	
}
