package com.cencolshare.model.response;

import lombok.Data;

@Data
public class StatResponse {
	
	private int documentsCount;
	
	private int groupsCount;
	
	private int discussionsCount;
	
	private int ownedGroupsCount;
	
	private String usedSpace;
	
	private int favouritesCount;

}
