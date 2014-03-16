package com.cencolshare.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.cencolshare.model.Discussion;
import com.cencolshare.service.DiscussionService;
import com.cencolshare.service.UserService;

@Controller
@RequestMapping(value = "discussion")
@Slf4j
public class DiscussionController extends BaseController {

	@Autowired
	DiscussionService discussionService;

	@Autowired
	UserService userService;

	@Autowired
	HttpServletRequest request;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView discussionListPage() {
		ModelAndView mav = new ModelAndView("discussion/list");
		List<Discussion> discussions = discussionService.getAllDiscussions();
		mav.addObject("title", discussions);
		return mav;
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView createNewDiscussion() {

		log.info("Indide create discsussion");

		ModelAndView mav = new ModelAndView("discussion/create");
		return mav;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public RedirectView saveNewDiscussion(RedirectAttributes redirectAttrs) {
		log.info("Inside save discussion function");
		String returnMessage = "";

		Discussion discussion = new Discussion();
		discussion.setDiscussionTopic(request
				.getParameter("discussionHeading"));
		discussion.setDiscussionContent(request
				.getParameter("discussionContents"));
		discussion.setUser(getLoggedInUser());
		// TODO: remove the above hardcoding with session

		final Discussion createdDiscussion = discussionService
				.saveDiscussion(discussion);
		if (createdDiscussion != null) {
			returnMessage = "Discussion Saved.";
		} else {
			returnMessage = "Unable to save discussion.";
		}

		redirectAttrs.addFlashAttribute("message", returnMessage);
		return new RedirectView("create", true);
	}

}
