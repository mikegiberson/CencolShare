package com.cencolshare.controller;

import lombok.extern.slf4j.Slf4j;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Slf4j
public class NavigationController {

	@RequestMapping(value={"/", "index"}, method=RequestMethod.GET)
	public ModelAndView index() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		log.debug(auth.toString());
		return new ModelAndView("index");
	}
	
}
