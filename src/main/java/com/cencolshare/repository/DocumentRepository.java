package com.cencolshare.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cencolshare.model.Document;
import com.cencolshare.model.Group;
import com.cencolshare.model.User;


public interface DocumentRepository extends JpaRepository<Document, Long>{

	List<Document> findByUser (User user);
	
	List<Document> findByGroup(Group group);
	
	@Query(value = "select COALESCE(sum(up.file_size) ,0) as used_space "
			+ "from tbl_upload up, tbl_document d, tbl_user u "
			+ "where up.upload_id = d.upload_id "
			+ "and d.user_id = u.user_id "
			+ "and u.user_id = :userId", nativeQuery = true)
	double getUsedSpaceByUser(@Param("userId") int userId);
	
}