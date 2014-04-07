package com.cencolshare.controller;

import java.math.BigInteger;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.cencolshare.model.Discussion;
import com.cencolshare.model.Document;
import com.cencolshare.model.Group;
import com.cencolshare.model.User;
import com.cencolshare.model.response.StatResponse;
import com.cencolshare.service.DiscussionService;
import com.cencolshare.service.DocumentService;
import com.cencolshare.service.GroupService;
import com.cencolshare.service.StatService;
import com.cencolshare.util.GroupUtil;

@Controller
@Slf4j
public class NavigationController extends BaseController {

	@Autowired
	GroupService groupService;
	
	@Autowired
	DocumentService documentService;

	@Autowired
	DiscussionService discussionService;
	
	@Autowired
	GroupUtil groupUtil;
	
	@Autowired
	StatService statService;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView index() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		if(getLoggedInUser() != null) {
			// user is already logged in
			return new ModelAndView(new RedirectView("dashboard"));
		}
		ModelAndView mav = new ModelAndView("index");
		return setSelectedMenu(mav);
	}
	
	@RequestMapping(value="/search", method=RequestMethod.GET)
	public ModelAndView searchGroup() {
		final String searchInput = request.getParameter("searchInput");
		final String searchType = request.getParameter("searchType");
		log.debug("value to search: {}", searchInput);
		log.debug("type to search: {}", searchType);
		
		ModelAndView mav = null;
		if(searchType.toLowerCase().equals("group")) {     		
			List<Group> searchedGroups=groupService.searchGroupsByNameDescription(searchInput);
			User user = getLoggedInUser();
			
			if(user != null && searchedGroups.size() > 0) {
				
				for (Group group : searchedGroups) {
					BigInteger members=groupService.getMemberCountbyGroupId(group.getGroupId());
					final Boolean isJoined = groupUtil.checkUserInGroup(user.getGroups(), group);
					
					if(isJoined)
					{
						group.setIsJoined("1");
					}
					group.setMember(members);
					log.debug("group {} id joined {}", group.getGroupName(), isJoined);
				}
			}

			log.debug("search count: {}", searchedGroups.size());
			mav = new ModelAndView("group/search-group");
			mav.addObject("groups", searchedGroups);	
			//mav.addObject("loggedInUser", getLoggedInUser());
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
		
		
		return setSelectedMenu(mav);
	}

	
}
