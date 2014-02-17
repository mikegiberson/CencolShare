package com.cencolshare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cencolshare.model.Group;
import com.cencolshare.model.Shop;
import com.cencolshare.service.GroupService;

@Controller
@RequestMapping(value="/group")
public class GroupController {

	@Autowired
	GroupService groupService;
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public ModelAndView listGroup() {
		List<Group> groups=groupService.getAllGroups();
		ModelAndView mav = new ModelAndView("group/list-group");
		mav.addObject("groups", groups);
		return mav;
	}
	
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public ModelAndView createGroup() {
		//List<Group> groups=groupService.createGroups();
		ModelAndView mav = new ModelAndView("group/create-group");
		//mav.addObject("groups", groups);
		return mav;
	}
	
}


