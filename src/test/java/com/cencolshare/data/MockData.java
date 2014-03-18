package com.cencolshare.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cencolshare.enums.Role;
import com.cencolshare.model.Comment;
import com.cencolshare.model.Discussion;
import com.cencolshare.model.Group;
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
		user.setRole(Role.USER);
		user.setEnabled(true);
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
	
	public Group createGroup() {
		final Group group = new Group();
		group.setGroupName(faker.name());
		group.setGroupDescription(faker.paragraph(2));
		group.setGroupImage("/cencolshare/resources/images/pdf.jpg");
		return group;
	}
}
