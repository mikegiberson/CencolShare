package com.cencolshare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

import com.cencolshare.model.User;
import com.cencolshare.service.UserService;

@Controller
public class BaseController {

	@Autowired
	UserService userService;

	public User getLoggedInUser() {
		User loggedinUser = null;
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		if (!auth.getPrincipal().equals("anonymousUser")) {
			org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User) auth
					.getPrincipal();
			loggedinUser = userService.loadUserByEmail(user.getUsername());

		}
		System.out.println("CURRENT LOGGED IN USER IS: "+ loggedinUser.getFirstName());
		return loggedinUser;
	}

}
