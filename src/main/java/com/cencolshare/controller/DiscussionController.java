package com.cencolshare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cencolshare.model.Discussion;
import com.cencolshare.service.DiscussionService;


@Controller
@RequestMapping(value="discussion")
public class DiscussionController {
	
	@Autowired
	DiscussionService discussionService;

	@RequestMapping(value="/list", method=RequestMethod.GET)
	public ModelAndView discussionListPage() {
		ModelAndView mav = new ModelAndView("discussion/list");
		List<Discussion> discussions = discussionService.getAllDiscussions();
		mav.addObject("title", discussions);
		return mav;
	}
}
