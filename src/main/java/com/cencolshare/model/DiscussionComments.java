package com.cencolshare.model;

import java.util.Date;

import lombok.Data;

@Data
public class DiscussionComments {
	private int commentId;
	private int userId;
	private Date commentDate;
	private String comment;
	private String firstName;
	private String lastName;
}
