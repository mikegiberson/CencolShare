package com.cencolshare.model;

import lombok.Data;

@Data
public class DiscussionComments {
	private int commentId;
	private int userId;
	private String commentDate;
	private String comment;
	private String firstName;
	private String lastName;
	private String photo;
	private Boolean showDelete;
}
