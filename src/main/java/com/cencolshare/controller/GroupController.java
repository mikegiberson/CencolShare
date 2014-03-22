package com.cencolshare.controller;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.Join;
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
import com.cencolshare.util.GroupUtil;


@Controller
@RequestMapping(value = "/group")
@Slf4j
public class GroupController extends BaseController {

	@Autowired
	GroupUtil groupUtil;
	
	
	@Autowired
	GroupService groupService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView listGroup() {
		User user = getLoggedInUser();
		List<Group> groups = groupService.getAllGroupsByUser(user);
		ModelAndView mav = new ModelAndView("group/list-group");
		mav.addObject("groups", groups);

		return setSelectedMenu(mav);
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView createGroup() {
		ModelAndView mav = new ModelAndView("group/create-group");
		return  setSelectedMenu(mav);
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveGroup() {
		log.debug("Inside save group:");
		User user = getLoggedInUser();
		Group grp = new Group();
		grp.setGroupName(request.getParameter("groupName"));
		grp.setGroupDescription(request.getParameter("groupDescription"));
		grp.setGroupImage(request.getParameter("photo"));
		grp.setUser(user);

		if (!request.getParameter("groupId").equals("")) {
			grp.setGroupId(Long.parseLong(request.getParameter("groupId")));
		}

		grp = groupService.saveGroup(grp);
		if (grp.getGroupId() > 0) {
			return new ModelAndView(new RedirectView("list"));
		}
		return null;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editGroup(@PathVariable Long id) {
		final Group grp = groupService.getGroupById(id);
		ModelAndView mav = new ModelAndView("group/create-group");
		mav.addObject("group", grp);
		return setSelectedMenu(mav);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteGroup(@PathVariable Long id) {
		log.info("Delete group id: " + id);
		final User loggedUser = getLoggedInUser();
		int loggedUserId = loggedUser.getUserId();
		Group thisGroup = groupService.getGroupById(id);
		int groupUserId = thisGroup.getUser().getUserId();
		if (groupUserId == loggedUserId) {
			log.info("User is authenticated to delete grp");
			groupService.deleteGroupbyID(id);
		}
		return new ModelAndView(new RedirectView("/cencolshare/group/list"));
	}

	@RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
	public ModelAndView viewGroup(@PathVariable Long id) {
		int a=0;
		
		final Group grp = groupService.getGroupById(id);
		BigInteger members=groupService.getMemberCountbyGroupId(id);
		ModelAndView mav = new ModelAndView("group/group-view");
		if(getLoggedInUser()!=null)
		{
		boolean check= groupUtil.checkUserInGroup(getLoggedInUser().getGroups(), grp);
		
		
		mav.addObject("loggedInUser", getLoggedInUser());
		if(check)
		{
		mav.addObject("check", 0);
		}else
		{
			mav.addObject("check", 1);	
		}}
		mav.addObject("group", grp);
		mav.addObject("members", members);
		// mav.addObject("joined",joinedgroups );
		return  mav;
	}
	
	@RequestMapping(value = "/remove/{id}", method = RequestMethod.GET)
	public ModelAndView removeUserFromGroup(@PathVariable Long id) {
		
		final User loggedUser = getLoggedInUser();
		int loggedUserId = loggedUser.getUserId();
		groupService.removeUserFromGroup(loggedUserId, id);
		if(request.getParameter("fromSearch") != null) {
			return new ModelAndView(new RedirectView("/cencolshare/search?searchType=group&searchInput="));
		} else {
			return new ModelAndView(new RedirectView("/cencolshare/group/view/"+id));
		}
	}
	
	@RequestMapping(value = "/add/{id}", method = RequestMethod.GET)
	public ModelAndView addUserFromGroup(@PathVariable Long id) {
		
		final User loggedUser = getLoggedInUser();
		int loggedUserId = loggedUser.getUserId();
		groupService.addUserToGroup(loggedUserId, id);
		
		if(request.getParameter("fromSearch") != null) {
			return new ModelAndView(new RedirectView("/cencolshare/search?searchType=group&searchInput="));
		} else {
			return new ModelAndView(new RedirectView("/cencolshare/group/view/"+id));
		}
		
	}
	
}
