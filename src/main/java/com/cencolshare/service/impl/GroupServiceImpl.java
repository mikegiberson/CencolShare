package com.cencolshare.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cencolshare.model.Group;
import com.cencolshare.model.User;
import com.cencolshare.repository.GroupRepository;
import com.cencolshare.service.GroupService;
import com.cencolshare.service.UserService;

@Service
@Slf4j
@Transactional
public class GroupServiceImpl implements GroupService {


	@Autowired
	GroupRepository groupRepository;
	
	@PersistenceContext
	EntityManager em;
	
	public Group saveGroup(Group grp) {
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
	public long getMemberCountbyGroupId(long groupId) {
		final String query = "SELECT COUNT(*) FROM user_to_group WHERE group_id="+ groupId;
		final Query q = em.createNativeQuery(query);
		Object[] temp  = (Object [])q.getSingleResult();
		Long rank = (Long) temp[0];
		return rank;
	}
	
	
}
