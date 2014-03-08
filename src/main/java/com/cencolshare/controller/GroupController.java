package com.cencolshare.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.cencolshare.model.Group;
import com.cencolshare.model.User;
import com.cencolshare.service.GroupService;

@Controller
@RequestMapping(value="/group")
@Slf4j
public class GroupController extends BaseController {

	@Autowired
	GroupService groupService;
	
	@Autowired
	HttpServletRequest request;
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public ModelAndView listGroup() {
		User user=getLoggedInUser();
		int userId=user.getUserId();
		List<Group> groups=groupService.getAllGroupsByUser(user);
		ModelAndView mav = new ModelAndView("group/list-group");
		mav.addObject("groups", groups);
	
		return mav;
	}
	
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public ModelAndView createGroup() {
		ModelAndView mav = new ModelAndView("group/create-group");
		return mav;
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public ModelAndView saveGroup() {
		log.debug("Inside save group:");
		User user=getLoggedInUser();
		Group grp = new Group();
		grp.setGroupName(request.getParameter("groupName"));
		grp.setGroupDescription(request.getParameter("groupDescription"));
		grp.setUser(user);
		
		if(!request.getParameter("groupId").equals("")) {
			grp.setGroupId(Long.parseLong(request.getParameter("groupId")));
		}
		
		grp = groupService.saveGroup(grp);
		if(grp.getGroupId() > 0) {
			return new ModelAndView(new RedirectView("list"));
		}
		return null;
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public ModelAndView editGroup(@PathVariable Long id) {
		final Group grp = groupService.getGroupById(id);
		ModelAndView mav = new ModelAndView("group/create-group");
		mav.addObject("group", grp);
		return mav;
	}
	
	
	
}


