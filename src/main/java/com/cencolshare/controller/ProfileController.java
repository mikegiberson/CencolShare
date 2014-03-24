package com.cencolshare.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cencolshare.model.Document;
import com.cencolshare.model.User;
import com.cencolshare.service.UserService;

@Controller
@RequestMapping("/profile")
public class ProfileController extends BaseController {

	@Autowired
	UserService userService;
	
	@Autowired
	HttpServletRequest request;
	
	@RequestMapping(value={"", "index"}, method=RequestMethod.GET)
	public ModelAndView showProfile() {
		ModelAndView mav = new ModelAndView("profile/index");
		mav.addObject("user", getLoggedInUser());
		return setSelectedMenu(mav);
	}
	
	@RequestMapping(value="/edit", method=RequestMethod.GET)
	public ModelAndView editProfile() {
		ModelAndView mav = new ModelAndView("profile/edit_profile");
		mav.addObject("user", getLoggedInUser());
		return setSelectedMenu(mav);
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String updateProfile() {
		
		String firstName = request.getParameter("first_name");
		String lastName = request.getParameter("last_name");
		String occupation = request.getParameter("occupation");
		String organization = request.getParameter("organization");
		
		final User loggedInUser = getLoggedInUser();
		loggedInUser.setFirstName(firstName);
		loggedInUser.setLastName(lastName);
		loggedInUser.setOccupation(occupation);
		loggedInUser.setOrganization(organization);
		
		final User savedUser = userService.insertUser(loggedInUser);

		return "redirect:/profile";
	}
	
	
}
