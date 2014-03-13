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
@Table(name="tbl_document")

public class Document {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="document_id")
	private int documentId;
	
	@Column(name="document_title", nullable=false)
	private String documentTitle;
	
	@Column(name="document_description")
	private String documentDescription;
	
	@Column(name="file_url", nullable=false)
	private String fileUrl;
	
	@Column(name="date_uploaded", nullable=false)
	private Date dateUploaded;
	
	@Column(name="tag", nullable=false)
	private String tag;
	
	@Column(name="size", nullable=false)
	private int size;
	
	@Column(name="format", nullable=false)
	private String format;
}
