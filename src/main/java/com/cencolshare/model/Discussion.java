package com.cencolshare.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="tbl_discussion")
public class Discussion {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="discussion_id")
	private int discussionId;
	
	@Column(name="discussion_topic", nullable=false)
	private String discussionTopic;
	
	@Column(name="discussion_date", nullable=false)
	private Date discussionDate;
}
