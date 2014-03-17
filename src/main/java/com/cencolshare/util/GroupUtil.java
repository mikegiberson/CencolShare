package com.cencolshare.util;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cencolshare.model.Group;

@Component
public class GroupUtil {

	public Boolean checkUserInGroup(List<Group> groups, Group group)
	{
		Boolean check=false;
		for(int i=0;i<groups.size();i++)
		{
			if(group.getGroupId().equals(groups.get(i).getGroupId()))
			{
				check=true;
				break;
			}
			
		}
		return check;
		
	}
}
