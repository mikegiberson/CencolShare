package com.cencolshare.data;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.cencolshare.enums.Role;
import com.cencolshare.model.Discussion;
import com.cencolshare.model.Document;
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
		user.setEnabled(true);
		user.setRole(Role.USER);
		return user;
	}
	
	public Upload createUpload()
	{
		final Upload upload=new Upload();
		Date date = new Date();
		
		upload.setFileName(faker.name());
		upload.setFilePath("");
		upload.setFileSize("123");
		upload.setFileType(".pdf");
		upload.setOriginalFileName("tram's doc");
		upload.setUploadDate(date);
		return upload;
	}
	
	public Discussion createDiscussion(User user) {
		final Discussion discussion = new Discussion();
		//discussion.setDiscussionHeadline(faker.sentence(10));
		discussion.setDiscussionContent(faker.paragraph(2));
		discussion.setUser(user);
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
	
}
