package com.cencolshare.service.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cencolshare.enums.FeedType;
import com.cencolshare.model.Discussion;
import com.cencolshare.model.Document;
import com.cencolshare.model.Group;
import com.cencolshare.model.User;
import com.cencolshare.model.response.GroupFeed;
import com.cencolshare.repository.GroupRepository;
import com.cencolshare.service.DiscussionService;
import com.cencolshare.service.DocumentService;
import com.cencolshare.service.GroupService;
import com.cencolshare.util.GeneralUtils;

@Service
@Slf4j
@Transactional
public class GroupServiceImpl implements GroupService {


	@Autowired
	GroupRepository groupRepository;
	
	@Autowired
	GeneralUtils generalUtils;
	
	@Autowired
	DiscussionService discussionService;
	
	@Autowired
	DocumentService documentService;
	
	@PersistenceContext
	EntityManager em;
	
	public Group saveGroup(Group grp) {
		grp.setCreatedDate(generalUtils.getCurrentTimeStamp());
		grp = groupRepository.save(grp);
		log.debug("New Group saved by group service: {}", grp.getGroupName());
		return grp;
	}
	
	public Group getGroupById(Long groupId) {
		final Group grp = groupRepository.findOne(groupId);
		return grp;
	}


	@Override
	public List<Group> getAllGroupsByUser(final User user) {
		
		final List<Group> groups= (List<Group>) groupRepository.findByUser(user);
		log.debug("groups count: {}", groups.size());
		return groups;
	}

	@Override
	public List<Group> searchGroupsByNameDescription(String groupName) {
		
		final String query = "SELECT * FROM tbl_group WHERE (group_name LIKE '%"+groupName+"%' OR group_description LIKE '%"+groupName+"%')";
		final Query q = em.createNativeQuery(query, Group.class);
		return q.getResultList();
	}

	@Override
	public boolean deleteGroupbyID(Long groupId) {
		groupRepository.delete(groupId);
		return true;
	}

	@Override
	public boolean removeUserFromGroup(long userId, long groupId) {
		final String query = "DELETE FROM user_to_group WHERE user_id= "+userId+" AND group_id =" + groupId;
		final Query q = em.createNativeQuery(query);
		q.executeUpdate();

		return true;
		
	}
	
	@Override
	public Boolean addUserToGroup(long userId, long groupId) {
		final String query = "INSERT INTO user_to_group VALUES ('"+ userId +"','"+groupId+"')";
		final Query q = em.createNativeQuery(query);
		q.executeUpdate();
		return true;
		}

	@Override
	public BigInteger getMemberCountbyGroupId(long groupId) {
		final String query = "SELECT COUNT(*) FROM user_to_group WHERE group_id="+ groupId;
		final Query q = em.createNativeQuery(query);
		BigInteger member = (BigInteger) q.getSingleResult();
		return member;
	}

	@Override
	public List<User> getAllMembersOfGroup(long groupId) {
		final String query = "SELECT u.* FROM user_to_group ug, tbl_user u WHERE u.user_id=ug.user_id AND ug.group_id="+groupId;
		final Query q=em.createNativeQuery(query,User.class);
		return q.getResultList();
	}

	@Override
	public List<GroupFeed> getFeedsByGroup(Group group, User loggedInUser) {
		
		List<GroupFeed> groupFeeds = new ArrayList<GroupFeed>();
		
		List<Discussion> groupDiscussions = discussionService.getDiscussionsByGroup(group);
		for (Discussion discussion : groupDiscussions) {
			final GroupFeed groupFeedItem = new GroupFeed();
			groupFeedItem.setFeedId(discussion.getDiscussionId());
			groupFeedItem.setFeedTitle(discussion.getDiscussionTopic());
			groupFeedItem.setFeedDescription(discussion.getDiscussionContent());
			groupFeedItem.setUser(discussion.getUser());
			groupFeedItem.setDateCreated(discussion.getDiscussionDate());
			groupFeedItem.setFeedType(FeedType.DISCUSSION);
			groupFeedItem.setComments(discussion.getComments());
			
			if(loggedInUser.getUserId() == discussion.getUser().getUserId() || isAdminOfGroup(group, loggedInUser)) {
				groupFeedItem.setDeleteAccess(Boolean.TRUE);
			} else {
				groupFeedItem.setDeleteAccess(Boolean.FALSE);
			}
			
			groupFeeds.add(groupFeedItem);
		}
		
		List<Document> groupDocuments = documentService.getDocumentByGroup(group);
		for(Document document : groupDocuments) {
			final GroupFeed groupFeedItem = new GroupFeed();
			groupFeedItem.setFeedId(document.getDocumentId().intValue());
			groupFeedItem.setFeedTitle(document.getDocumentTitle());
			groupFeedItem.setFeedDescription(document.getDocumentDescription());
			groupFeedItem.setUser(document.getUser());
			groupFeedItem.setDateCreated(document.getDateUploaded());
			groupFeedItem.setFeedType(FeedType.DOCUMENT);
			groupFeedItem.setComments(null);
			
			if(loggedInUser.getUserId() == document.getUser().getUserId() || isAdminOfGroup(group, loggedInUser)) {
				groupFeedItem.setDeleteAccess(Boolean.TRUE);
			} else {
				groupFeedItem.setDeleteAccess(Boolean.FALSE);
			}
			
			groupFeeds.add(groupFeedItem);
		}
		
		
		return groupFeeds;
	}

	@Override
	public Boolean isAdminOfGroup(Group group, User user) {
		
		if(group.getUser().getUserId() == user.getUserId()) {
			return Boolean.TRUE;
		} else {
			return Boolean.FALSE;
		}
	}
	
	@Override
	public List<Group> getjoinedGroups(int userId) {
		final String query = "SELECT * FROM tbl_group WHERE group_id IN (SELECT group_id FROM user_to_group WHERE user_id ="+userId+")";
		final Query q=em.createNativeQuery(query,Group.class);
		return q.getResultList();
	}
	
}

	
