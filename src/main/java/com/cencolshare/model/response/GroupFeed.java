package com.cencolshare.model.response;

import java.util.Date;
import java.util.List;

import lombok.Data;

import com.cencolshare.enums.FeedType;
import com.cencolshare.model.Comment;
import com.cencolshare.model.Document;
import com.cencolshare.model.User;

@Data
public class GroupFeed {
	
	private int feedId;
	
	private String feedTitle;
	
	private String feedDescription;
	
	private User user;
	
	private List<Comment> comments;
	
	private FeedType feedType;
	
	private Document document;
	
	private Date dateCreated;

}
