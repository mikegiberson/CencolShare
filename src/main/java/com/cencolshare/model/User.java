package com.cencolshare.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.cencolshare.enums.Role;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="tbl_user")
public class User {
        
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="user_id")
    private int userId;

	@Column(name="first_name", nullable=false)
	private String firstName;

	@Column(name="last_name", nullable=false)
	private String lastName;
	
	@Column(name="occupation", nullable=true)
	private String occupation;
	
	@Column(name="organization", nullable=true)
	private String organization;
	
	@Column(name="email", nullable=false, unique=true)
	private String email;
	
	@Column(name="about", nullable=true)
	private String about;

	@Column(name="photo", nullable=true)
	private String photo;

	@Column(name="address", nullable=true)
	private String address;

	@Column(name="city", nullable=true)
	private String city;

	@Column(name="provience", nullable=true)
	private String provience;

	@Column(name="country", nullable=true)
	private String country;
	
	@Column(name="password", nullable=false)
    private String password;

	@Column(name="enabled", nullable=false)
    public Boolean enabled;
	
	@Column(name="verification_token", nullable=true)
	private String verifyToken;
	
	@Column(name="date_joined", nullable=true)
	private String dateJoined;
	
	@Column(name="role", nullable=false)
    public Role role;
	
	@Transient
	public Boolean fromAdmin;
	
	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(name = "user_to_group", 
	joinColumns = { @JoinColumn(name = "user_id", referencedColumnName = "user_id") }, 
	inverseJoinColumns = { @JoinColumn(name = "group_id", referencedColumnName = "group_id") })
	@Fetch(FetchMode.JOIN)
	private List<Group> groups;
	    
}