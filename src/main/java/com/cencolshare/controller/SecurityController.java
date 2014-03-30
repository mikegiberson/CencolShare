package com.cencolshare.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.cencolshare.enums.Role;
import com.cencolshare.model.User;
import com.cencolshare.service.UserService;

@Controller
@Slf4j
public class SecurityController extends BaseController {

	@Autowired(required = true)
	UserService userService;

	@Autowired
	HttpServletRequest request;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login() {
		log.debug("inside login");
		return new ModelAndView("login");
	}

	@RequestMapping(value = "/accessdenied", method = RequestMethod.GET)
	public ModelAndView accessdenied() {
		log.debug("inside accessdenied");
		return new ModelAndView("common/accessdenied");
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(ModelMap model, HttpServletRequest request,
			HttpServletResponse response) {
		SecurityContextHolder.clearContext();
		return "redirect:/login";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView createAccount() {
		String firstName = request.getParameter("first_name");
		String lastName = request.getParameter("last_name");
		String occupation = request.getParameter("occupation");
		String organization = request.getParameter("organization");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("password_confirmation");
		log.debug("creating user with email {} ", email);

		final User userExists = userService.loadUserByEmail(email);
		if (userExists != null) {
			ModelAndView mav = new ModelAndView("register");
			mav.addObject("errors",
					"User exists with the same email. Please login");
			return mav;
		}

		if (firstName.equals("") || lastName.equals("") || email.equals("")
				|| password.equals("") || organization.equals("")
				|| occupation.equals("")) {
			ModelAndView mav = new ModelAndView("register");
			mav.addObject("errors", "All fields are mandatory");
			return mav;
		} else if (!password.equals(confirmPassword)) {
			ModelAndView mav = new ModelAndView("register");
			mav.addObject("errors", "Confirm password didnt match");
			return mav;
		} else {
			final User user = new User();
			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setOccupation(occupation);
			user.setOrganization(organization);
			user.setEmail(email);
			user.setPassword(password);
			userService.insertUser(user);
			return new ModelAndView("register_success");
		}

	}

	@RequestMapping(value = "/verify/{token}", method = RequestMethod.GET)
	public ModelAndView verifyEmail(ModelMap model, @PathVariable String token) {

		ModelAndView mav = new ModelAndView("verify_email");
		final User verifiedUser = userService.verifyEmail(token);

		if (verifiedUser == null) {
			mav.addObject("message", "Oops! Invalid token. Failed to verify");
		} else {
			mav.addObject("message",
					"Successfully verified your email address. Please procced to login");
		}

		return mav;
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView showRegisterPage() {
		log.debug("Register page");
		return new ModelAndView("register");
	}

	@RequestMapping(value = "/userprofile/save", method = RequestMethod.POST)
    public ModelAndView saveProfile(final @ModelAttribute User user) {
		log.debug("updating user: {}", user.getUserId());
		log.debug("from admin: {}", user.getFromAdmin());

		if(!(user.getPhoto() != null && !user.getPhoto().equals(""))) {
			user.setPhoto("https://s3.amazonaws.com/crime-alert/1394710047317.png");
			log.debug("setting default pic");
		}

		if(user.getFromAdmin() != null && user.getFromAdmin()) {
			User userToUpdate = userService.loadUserById(user.getUserId());
			user.setPassword(userToUpdate.getPassword());
			user.setUserId(userToUpdate.getUserId());

			if(request.getParameter("userenabled") != null && request.getParameter("userenabled").equals("Y")) {
				user.setEnabled(true);
			} else {
				user.setEnabled(false);
			}

			if(!userToUpdate.getRole().equals(Role.ADMIN)) {
				if(request.getParameter("userrole") != null && request.getParameter("userrole").equals("0")) {
					user.setRole(Role.USER);
				} else if(request.getParameter("userrole") != null && request.getParameter("userrole").equals("2")) {
					user.setRole(Role.MANAGER);
				} else {
					user.setRole(Role.USER);
				}				
			}
			
			else{
				user.setRole(Role.ADMIN);
			}
			userService.insertUser(user);			
			return new ModelAndView(new RedirectView("/cencolshare/user"));
		}

		user.setEnabled(getLoggedInUser().getEnabled());
		user.setPassword(getLoggedInUser().getPassword());
		user.setUserId(getLoggedInUser().getUserId());
		user.setRole(getLoggedInUser().getRole());
		userService.insertUser(user);

		return new ModelAndView(new RedirectView("/cencolshare/profile"));
    }
	
	@RequestMapping(value="/resetpassword", method=RequestMethod.POST)
	@ResponseBody
	public String resetPassword(){
		String email = request.getParameter("email");
		if(email == null || email.equals("")){
			return "Please enter an email";
		}
		User user = userService.loadUserByEmail(email);
		if(user == null){
			return "User does not exist";
		}
		if(userService.resetPassword(user)) {
			return "Password reset successful";
		}
		return "Unable to send email";
	}
}
