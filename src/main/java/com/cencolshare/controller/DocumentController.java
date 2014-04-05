package com.cencolshare.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.cencolshare.enums.Role;
import com.cencolshare.model.Comment;
import com.cencolshare.model.Document;
import com.cencolshare.model.DocumentComments;
import com.cencolshare.model.Upload;
import com.cencolshare.model.User;
import com.cencolshare.service.CommentService;
import com.cencolshare.service.DocumentService;
import com.cencolshare.service.UploadService;

@Controller
@RequestMapping("/docs")
@Slf4j
public class DocumentController extends BaseController {

	@Autowired
	DocumentService documentService;

	@Autowired
	HttpServletRequest request;

	@Value("${domainPath}")
	private String DOMAIN_PATH;

	@Autowired
	UploadService uploadService;
	
	@Autowired
	CommentService commentService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView listDocument() {
		ModelAndView mav = new ModelAndView("docs/document-list");
		User user = getLoggedInUser();
		int userId = user.getUserId();
		//List<Document> documents = documentService.findAllDocumentByUser(user);
		List<Document> documents = documentService.findAllDocumentByUser(userId);
		mav.addObject("documents", documents);
		return setSelectedMenu(mav);
	}

	@RequestMapping(value = "/view/{docId}", method = RequestMethod.GET)
	public ModelAndView documentPreview(@PathVariable long docId) {

		ModelAndView mav = new ModelAndView("document/document-preview");
		final Document document = documentService.getDocumentById(docId);
		long fileId = document.getUpload().getId();
		String filePath = DOMAIN_PATH + "upload/fetch/" + fileId;

		mav.addObject("docPath", filePath);
		mav.addObject("document", document);
		
		List<DocumentComments> comments = commentService.getCommentsByDocumentId(document.getDocumentId());
		mav.addObject("comments", comments);

		return mav;
	}

	@RequestMapping(value = "/upload", method = RequestMethod.GET)
	public ModelAndView uploadDocs() {
		ModelAndView mav = new ModelAndView("docs/document-upload");
		return setSelectedMenu(mav);

	}

	@RequestMapping(value = "/favorite", method = RequestMethod.GET)
	public ModelAndView favDocs() {
		ModelAndView mav = new ModelAndView("docs/document-favorite");
		return setSelectedMenu(mav);

	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveDoc() {
		User user = getLoggedInUser();
		Upload upload = uploadService.getUploadById(Long.parseLong(request
				.getParameter("uploadId")));

		Document doc = new Document();
		doc.setDocumentTitle(request.getParameter("documentTitle"));
		doc.setDocumentDescription(request.getParameter("documentDescription"));
		doc.setTag(request.getParameter("tag"));
		doc.setDateUploaded(new Date());
		doc.setFileUrl(request.getParameter("fileUrl"));

		doc.setUser(user);
		doc.setUpload(upload);

		if (!request.getParameter("documentId").equals("")) {
			doc.setDocumentId(Long.parseLong(request.getParameter("documentId")));
		}

		doc = documentService.saveDocument(doc);
		if (doc.getDocumentId() > 0) {
			return new ModelAndView(new RedirectView("list"));
		}
		return null;
	}

	@RequestMapping(value = "/delete/{id}/{page}", method = RequestMethod.GET)
	public ModelAndView deleteDocument(@PathVariable Long id, @PathVariable String page) {

		User user = getLoggedInUser();
		final Document doc = documentService.getDocumentById(id);
		Long uploadId = doc.getUpload().getId();
		int docUserId = doc.getUser().getUserId();
		int userID = user.getUserId();

		if (userID == docUserId) {

			documentService.deleteDocumentbyID(id);
			uploadService.deleteUpload(uploadId);
		}	
		
		if(page.equals("fromGroup")) {
			Long groupId = doc.getGroup().getGroupId();
			return new ModelAndView(new RedirectView(DOMAIN_PATH + "group/view/" + groupId));
		} else {
			return new ModelAndView(new RedirectView(DOMAIN_PATH + "docs/list"));
		}

		
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editDocument(@PathVariable Long id) {
		final Document doc = documentService.getDocumentById(id);
		ModelAndView mav = new ModelAndView("docs/document-upload");
		mav.addObject("document", doc);
		return setSelectedMenu(mav);
						
		
		
	}
	
	@RequestMapping(value="/comment", method=RequestMethod.POST)
	@ResponseBody
	public Map<String, String> saveComment(){
		Map<String, String> result = new HashMap<String, String>();
		int documentId = Integer.parseInt(request.getParameter("documentId"));
		String comment = request.getParameter("comment");
		
		Document document = documentService.getDocumentById(documentId);
		if(document == null){
			result.put("result", "fail");
			result.put("message", "Document not found");
			return result;
		}
		
		List<Comment> comments = document.getComments();
		if (comments == null) {
			comments = new ArrayList<Comment>();
		}
		final Comment cmt = new Comment();
		cmt.setComment(comment);
		cmt.setCommentDate(new java.sql.Date(new Date().getTime()));
		cmt.setUser(getLoggedInUser());
		comments.add(cmt);

		document.setComments(comments);
		documentService.saveDocument(document);
		result.put("result", "success");

		return result;
	}	

	@RequestMapping(value = "/deleteComment/{id}", method = RequestMethod.GET)
	public ModelAndView deleteComment(@PathVariable int id) {
		final Comment comment = commentService.getCommentById(id);
		int documentId = commentService.getDocumentIdByCommentId(id);

		if (!(getLoggedInUser().getRole().equals(Role.ADMIN) || (getLoggedInUser()
				.getRole().equals(Role.MANAGER)))
				&& comment.getUser().getUserId() != getLoggedInUser()
						.getUserId()) {
			ModelAndView mav = new ModelAndView("docs/view");
			mav.addObject("error", "You cannot delete this comment");
			return new ModelAndView(new RedirectView(DOMAIN_PATH
					+ "docs/view/" + documentId));
		}

		documentService.deleteCommentById(id);
		log.debug("getting document id from comment: {}", documentId);
		return new ModelAndView(new RedirectView(DOMAIN_PATH
				+ "docs/view/" + documentId));
	}
}
