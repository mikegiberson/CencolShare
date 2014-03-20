package com.cencolshare.controller;

import javax.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import com.cencolshare.model.User;
import com.cencolshare.service.UserService;

@Controller
@Slf4j
public class BaseController {

	@Autowired
	HttpServletRequest request;
	
	@Autowired
	UserService userService;

	public ModelAndView setSelectedMenu(final ModelAndView mav) {
		log.debug(request.getRequestURI());

		mav.addObject("dashboardActive", "");
		mav.addObject("groupActive", "");
		mav.addObject("discussionActive", "");
		mav.addObject("docsActive", "");
		mav.addObject("profileActive", "");
		

		if(request.getRequestURI().contains("dashboard")) {
			mav.addObject("dashboardActive", "active");
		} else if(request.getRequestURI().contains("group")) {
			mav.addObject("groupActive", "active");
		} else if(request.getRequestURI().contains("discussion"))  {
			mav.addObject("discussionActive", "active");
		} else if(request.getRequestURI().contains("docs"))  {
			mav.addObject("docsActive", "active");
		} else if(request.getRequestURI().contains("profile")) {
			mav.addObject("profileActive", "active");
		}		
		mav.addObject("loggedInUser", getLoggedInUser());
		return mav;
	}

	
	public User getLoggedInUser() {
		User loggedinUser = null;
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		if (!auth.getPrincipal().equals("anonymousUser")) {
			org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User) auth
					.getPrincipal();
			loggedinUser = userService.loadUserByEmail(user.getUsername());

		}
		return loggedinUser;
	}

}
