package com.cencolshare.controller;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.cencolshare.model.Document;
import com.cencolshare.model.Group;
import com.cencolshare.model.Upload;
import com.cencolshare.model.User;
import com.cencolshare.model.response.GroupFeed;
import com.cencolshare.service.DiscussionService;
import com.cencolshare.service.DocumentService;
import com.cencolshare.service.GroupService;
import com.cencolshare.service.UploadService;
import com.cencolshare.util.GroupUtil;

@Controller
@RequestMapping(value = "/group")
@Slf4j
public class GroupController extends BaseController {

	@Autowired
	GroupUtil groupUtil;

	@Autowired
	GroupService groupService;

	@Autowired
	UploadService uploadService;

	@Autowired
	DocumentService documentService;

	@Autowired
	DiscussionService discussionService;
	
	@Value("${domainPath}")
	private String DOMAIN_PATH;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView listGroup() {
		User user = getLoggedInUser();
		List<Group> groups = groupService.getAllGroupsByUser(user);
		for (int i = 0; i < groups.size(); i++) {
			BigInteger members = groupService.getMemberCountbyGroupId(groups
					.get(i).getGroupId());
			groups.get(i).setMember(members);
		}

		ModelAndView mav = new ModelAndView("group/list-group");
		mav.addObject("groups", groups);

		return setSelectedMenu(mav);
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView createGroup() {
		ModelAndView mav = new ModelAndView("group/create-group");
		return setSelectedMenu(mav);
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveGroup() {
		log.debug("Inside save group:");
		User user = getLoggedInUser();
		Group grp = new Group();
		grp.setGroupName(request.getParameter("groupName"));
		grp.setGroupDescription(request.getParameter("groupDescription"));
		if (request.getParameter("photo") == null
				|| request.getParameter("photo").equals("")) {
			grp.setGroupImage(DOMAIN_PATH +"/resources/images/groupDefault.png");
		} else {
			grp.setGroupImage(request.getParameter("photo"));
		}

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
		BigInteger members = groupService.getMemberCountbyGroupId(id);

		// get discussions in a group
		List<GroupFeed> groupFeeds = groupService.getFeedsByGroup(grp, getLoggedInUser());
		System.out.println("Total number of feeds: " + groupFeeds.size());
		
		ModelAndView mav = new ModelAndView("group/group-view");
		if (getLoggedInUser() != null) {
			boolean check = groupUtil.checkUserInGroup(getLoggedInUser()
					.getGroups(), grp);

			mav.addObject("loggedInUser", getLoggedInUser());
			if (check) {
				mav.addObject("check", 0);
			} else {
				mav.addObject("check", 1);
			}
		}
		
		Boolean hasAccess = userService.isUserMemberOfGroup(getLoggedInUser(), grp);
		
		mav.addObject("group", grp);
		mav.addObject("members", members);
		mav.addObject("hasAccess", hasAccess); // if the current user has access to the group
		mav.addObject("groupFeeds", groupFeeds);
		// mav.addObject("joined",joinedgroups );
		return mav;
	}

	@RequestMapping(value = "/view/{id}/upload", method = RequestMethod.GET)
	public ModelAndView uploadDocs(@PathVariable Long id) {
		ModelAndView mav = new ModelAndView("docs/document-upload-group");
		
		final Group thisGroup = groupService.getGroupById(id);
		Boolean hasAccess = userService.isUserMemberOfGroup(getLoggedInUser(), thisGroup);
		
		mav.addObject("groupId", id);
		mav.addObject("hasAccess", hasAccess);
		return setSelectedMenu(mav);
	}

	
	@RequestMapping(value = "/view/{id}/list", method = RequestMethod.GET)
	public ModelAndView listDocs(@PathVariable Long id) {
		ModelAndView mav = new ModelAndView("docs/document-list-group");
		List<Document> documents = documentService.findAllDocumentInGroup(id);
		
		final Group thisGroup = groupService.getGroupById(id);
		
		Boolean hasAccess = userService.isUserMemberOfGroup(getLoggedInUser(), thisGroup);
		
		mav.addObject("groupId", id);
		mav.addObject("documents", documents);
		mav.addObject("hasAccess", hasAccess);
		return  setSelectedMenu(mav);
	}

	@RequestMapping(value = "/view/{id}/upload/save", method = RequestMethod.POST)
	public ModelAndView saveDoc(@PathVariable Long id) {
		User user = getLoggedInUser();
		Upload upload = uploadService.getUploadById(Long.parseLong(request
				.getParameter("uploadId")));

		Group group = groupService.getGroupById(id);

		Document doc = new Document();
		doc.setDocumentTitle(request.getParameter("documentTitle"));
		doc.setDocumentDescription(request.getParameter("documentDescription"));
		doc.setTag(request.getParameter("tag"));
		doc.setDateUploaded(new Date());
		doc.setFileUrl(request.getParameter("fileUrl"));

		doc.setUser(user);
		doc.setUpload(upload);
		doc.setGroup(group);

		if (!request.getParameter("documentId").equals("")) {
			doc.setDocumentId(Long.parseLong(request.getParameter("documentId")));
		}

		doc = documentService.saveDocument(doc);
		if (doc.getDocumentId() > 0) {

			return new ModelAndView(new RedirectView("/cencolshare/group/view/" + id + "/list"));
		}
		return null;
	}

	@RequestMapping(value = "/remove/{id}", method = RequestMethod.GET)
	public ModelAndView removeUserFromGroup(@PathVariable Long id) {

		final User loggedUser = getLoggedInUser();
		int loggedUserId = loggedUser.getUserId();
		groupService.removeUserFromGroup(loggedUserId, id);
		if(request.getParameter("fromSearch") != null) {
			return new ModelAndView(new RedirectView("/cencolshare/search?searchType=group&searchInput="));
		} else if(request.getParameter("fromJoined").equals("true"))
			return new ModelAndView(new RedirectView("/cencolshare/group/joined"));
		else {
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

	@RequestMapping(value = "/members/{id}", method = RequestMethod.GET)
	public ModelAndView viewGroupMembers(@PathVariable Long id) {
		ModelAndView mav = new ModelAndView("group/view-members");
		List<User> groupMembers = groupService.getAllMembersOfGroup(id);
		Group group = groupService.getGroupById(id);
		BigInteger members = groupService.getMemberCountbyGroupId(id);
		if (getLoggedInUser() != null) {
			boolean check = groupUtil.checkUserInGroup(getLoggedInUser()
					.getGroups(), group);

			mav.addObject("loggedInUser", getLoggedInUser());
			if (check) {
				mav.addObject("check", 0);
			} else {
				mav.addObject("check", 1);
			}
		}
		mav.addObject("members", members);
		mav.addObject("allMembers", groupMembers);
		mav.addObject("group", group);
		return mav;
	}

	@RequestMapping(value = "/member/group/{id}", method = RequestMethod.GET)
	public ModelAndView memberListOfGroups(@PathVariable long id) {

		List<Group> groups = groupService.getAllGroupsByUser(userService
				.loadUserById(id));
		for (int i = 0; i < groups.size(); i++) {
			BigInteger members = groupService.getMemberCountbyGroupId(groups
					.get(i).getGroupId());
			groups.get(i).setMember(members);
		}

		ModelAndView mav = new ModelAndView("group/member-ownedgroup");
		mav.addObject("groups", groups);

		return setSelectedMenu(mav);
	}
	
	@RequestMapping(value = "/joined", method = RequestMethod.GET)
	public ModelAndView listJoinedGroup() {
		User user = getLoggedInUser();
		List<Group> groups = groupService.getjoinedGroups(user.getUserId());
		ModelAndView mav = new ModelAndView("group/joined-groups");
		for (int i = 0; i < groups.size(); i++) {
			BigInteger members = groupService.getMemberCountbyGroupId(groups
					.get(i).getGroupId());
			groups.get(i).setMember(members);
		}
		
		mav.addObject("joinedgroups", groups);
		return mav;
	}


}
