package com.cencolshare.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.cencolshare.enums.Role;
import com.cencolshare.model.Comment;
import com.cencolshare.model.Discussion;
import com.cencolshare.model.DiscussionComments;
import com.cencolshare.service.CommentService;
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
	CommentService commentService;

	@Autowired
	HttpServletRequest request;
	
	@RequestMapping(value="/view/{id}", method = RequestMethod.GET)
	public ModelAndView viewDiscussion(@PathVariable int id){
		ModelAndView mav = new ModelAndView("discussion/view");
		final Discussion discussion = discussionService.getDiscussionById(id);
		mav.addObject("discussion", discussion);
		List<DiscussionComments> comments = commentService.getCommentsByDiscussionId(id);
		mav.addObject("comments", comments);
		return setSelectedMenu(mav);
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView discussionListPage() {
		ModelAndView mav = new ModelAndView("discussion/list");
		List<Discussion> discussions = discussionService.getAllDiscussions();
		mav.addObject("discussions", discussions);
		return setSelectedMenu(mav);
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView createNewDiscussion() {

		log.info("Indide create discsussion");

		ModelAndView mav = new ModelAndView("discussion/create");
		return setSelectedMenu(mav);
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
	
	@RequestMapping(value="/comment", method=RequestMethod.POST)
	@ResponseBody
	public Map<String, String> saveComment(){
		Map<String, String> result = new HashMap<String, String>();
		int discussionId = Integer.parseInt(request.getParameter("discussionId"));
		String comment = request.getParameter("comment");
		
		Discussion discussion = discussionService.getDiscussionById(discussionId);
		if(discussion == null){
			result.put("result", "fail");
			result.put("message", "Discussion not found");
			return result;
		}
		
		List<Comment> comments = discussion.getComments();
		if(comments==null){
			comments = new ArrayList<Comment>();
		}
		final Comment cmt = new Comment();
		cmt.setComment(comment);
		cmt.setCommentDate(new java.sql.Date(new Date().getTime()));
		cmt.setUser(getLoggedInUser());
		comments.add(cmt);
		
		discussion.setComments(comments);
		discussionService.saveDiscussion(discussion);
		result.put("result", "success");
		return result;
	}
	
	@RequestMapping(value="/deleteComment/{id}", method=RequestMethod.GET)
	public ModelAndView deleteComment(@PathVariable int id) {
		final Comment comment = commentService.getCommentById(id);
		int discussionId = commentService.getDiscussionIdByCommentId(id);
		
		if(!(getLoggedInUser().getRole().equals(Role.ADMIN) || (getLoggedInUser().getRole().equals(Role.MANAGER))) && comment.getUser().getUserId()!=getLoggedInUser().getUserId()){
			ModelAndView mav = new ModelAndView("discussion/view");
			mav.addObject("error", "You cannot delete this comment");
			return new ModelAndView(new RedirectView("/cencolshare/discussion/view/" + discussionId));
		}
		
		discussionService.deleteCommentById(id);	
		log.debug("getting discussion id from comment: {}", discussionId);
		return new ModelAndView(new RedirectView("/cencolshare/discussion/view/" + discussionId));
	}

}
