package com.cencolshare.model;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="tbl_group")
public class Group {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="group_id")
	private Long groupId;
	
	@Column(name="group_name", nullable=false)
	private String groupName;
	
	@Column(name="group_description")
	private String groupDescription;
	
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = User.class)
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
	
	@Column(name="group_image")
	private String groupImage;
	
	@Transient
	private String isJoined = "0";
	
	@Transient
	private BigInteger member=BigInteger.ZERO;

}
