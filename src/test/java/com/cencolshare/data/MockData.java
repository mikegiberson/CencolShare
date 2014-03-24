package com.cencolshare.data;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cencolshare.enums.Role;
import com.cencolshare.model.Comment;
import com.cencolshare.model.Discussion;
import com.cencolshare.model.Document;
import com.cencolshare.model.Group;
import com.cencolshare.model.Upload;
import com.cencolshare.model.User;
import com.github.javafaker.Faker;

@Component
public class MockData {

	public Faker faker = new Faker();
	
	public User createUser() {
		final User user = new User();
		user.setFirstName(faker.firstName());
		user.setLastName(faker.lastName());
		user.setPassword(faker.firstName() + "password");
		user.setEmail(faker.firstName() + "@gmail.com");
		user.setOccupation("Associate of " + faker.name());
		user.setOrganization("University of " + faker.country());
		user.setRole(Role.USER);
		user.setEnabled(true);
		user.setRole(Role.USER);
		return user;
	}
	
	public Comment createComment(User user)
	{
		
		final Comment comment=new Comment();
		comment.setComment(faker.name());
		comment.setUser(user);
		comment.setCommentDate(new Date());;
		return comment;
	}

	public Upload createUpload()
	{
		final Upload upload=new Upload();
		Date date = new Date();
		
		upload.setFileName(faker.name());
		upload.setFileSize("123");
		upload.setFileType(".pdf");
		upload.setOriginalFileName("tram's doc");
		upload.setUploadDate(date);
		return upload;
	}

	
	public Discussion createDiscussion(User user, List<Comment> comment) {
		final Discussion discussion = new Discussion();
		//discussion.setDiscussionHeadline(faker.sentence(10));
		discussion.setDiscussionTopic(faker.name());
		discussion.setDiscussionContent(faker.paragraph(2));
		discussion.setDiscussionDate(new Date());
		discussion.setUser(user);
		discussion.setComments(comment);
		return discussion;
	}
	

	public Document createDocument() {
		Date date = new Date();
		
		final Document document = new Document();
		document.setDocumentTitle(faker.name());
		document.setDocumentDescription(faker.paragraph());
		document.setTag(faker.name());
		document.setDateUploaded(date);
		document.setFileUrl("");
		
		return document;
	}
	
	public Group createGroup() {
		final Group group = new Group();
		group.setGroupName(faker.name());
		group.setGroupDescription(faker.paragraph(2));
		group.setGroupImage("/cencolshare/resources/images/pdf.jpg");
		return group;
	}

}
