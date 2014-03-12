package com.cencolshare.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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
	
	@ManyToOne(fetch = FetchType.LAZY, targetEntity=User.class)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
	
	@Column(name="discussion_topic", nullable=false)
	private String discussionTopic;
	
	@Column(name="discussion_content", nullable=false)
	private String discussionContent;
	
	@Column(name="discussion_date", nullable=false)
	private Date discussionDate;
	
	@ManyToMany(cascade =  {CascadeType.ALL})
	@JoinTable(name="discussion_to_comment", 
				joinColumns={@JoinColumn(name="discussion_id", referencedColumnName="discussion_id")},
				inverseJoinColumns={@JoinColumn(name="comment_id", referencedColumnName="comment_id")})
	@Fetch(FetchMode.JOIN)
	private List<Comment> comments;
}
