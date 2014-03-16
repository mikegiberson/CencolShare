package com.cencolshare.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Accessors(chain = true)

@Entity
@Table(name = "tbl_upload")
public class Upload {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_upload_id")
  @SequenceGenerator(name = "seq_upload_id", sequenceName = "seq_upload_id")
  @Column(name = "upload_id")
  private Long id;

  @Column(name = "original_file_name", nullable = false)
  private String originalFileName;
  
  @Column(name = "file_name", nullable = false)
  private String fileName;

  @Column(name = "upload_date", nullable = false)
  private Date uploadDate;

  @Column(name = "file_path", nullable = false)
  private String filePath;

  @Column(name = "file_type", nullable = false)
  private String fileType;
}