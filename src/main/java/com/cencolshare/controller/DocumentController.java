package com.cencolshare.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
import com.cencolshare.model.Upload;
import com.cencolshare.model.User;
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

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView listDocument() {
		ModelAndView mav = new ModelAndView("docs/document-list");
		User user = getLoggedInUser();
		List<Document> documents = documentService.findAllDocumentByUser(user);
		mav.addObject("documents", documents);
		return setSelectedMenu(mav);
	}

	// @RequestMapping(value = "/preview", method = RequestMethod.GET)
	// public ModelAndView documentPreviewTest() {
	// ModelAndView mav = new ModelAndView("document/document-preview");
	// mav.addObject("title", "hello");
	// mav.addObject("docPath", "sample.doc");
	// return setSelectedMenu(mav);
	// }

	@RequestMapping(value = "/view/{docId}", method = RequestMethod.GET)
	public ModelAndView documentPreview(@PathVariable long docId) {

		ModelAndView mav = new ModelAndView("document/document-preview");
		final Document document = documentService.getDocumentById(docId);
		long fileId = document.getUpload().getId();
		String filePath = DOMAIN_PATH + "upload/fetch/" + fileId;

		mav.addObject("docPath", filePath);

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

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteDocument(@PathVariable Long id) {

		User user = getLoggedInUser();
		final Document doc = documentService.getDocumentById(id);
		Long uploadId = doc.getUpload().getId();
		int docUserId = doc.getUser().getUserId();
		int userID = user.getUserId();

		if (userID == docUserId) {

			documentService.deleteDocumentbyID(id);
			uploadService.deleteUpload(uploadId);
		}

		return new ModelAndView(new RedirectView("/cencolshare/docs/list"));
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editDocument(@PathVariable Long id) {
		final Document doc = documentService.getDocumentById(id);
		ModelAndView mav = new ModelAndView("docs/document-upload");
		mav.addObject("document", doc);
		return setSelectedMenu(mav);
	}
	
	

}
