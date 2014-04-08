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
@Table(name="tbl_document")

public class Document {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="document_id")
	private Long documentId;
	
	@Column(name="document_title", nullable=false)
	private String documentTitle;
	
	@Column(name="document_description", length=2000)
	private String documentDescription;
	
	@Column(name="file_url", nullable=false)
	private String fileUrl;
	
	@Column(name="date_uploaded", nullable=false)
	private Date dateUploaded;
	
	@Column(name="tag", nullable=false)
	private String tag;
	
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = User.class)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
	
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Upload.class)
	@JoinColumn(name = "upload_id", nullable = false)
	private Upload upload;
	
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Group.class)
	@JoinColumn(name = "group_id", nullable = true)
	private Group group;
	
	@ManyToMany(cascade =  {CascadeType.ALL})
	@JoinTable(name="document_to_comment", 
				joinColumns={@JoinColumn(name="document_id", referencedColumnName="document_id")},
				inverseJoinColumns={@JoinColumn(name="comment_id", referencedColumnName="comment_id")})
	@Fetch(FetchMode.JOIN)
	private List<Comment> comments;
}
