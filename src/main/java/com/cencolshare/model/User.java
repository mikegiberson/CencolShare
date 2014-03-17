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
	
	@Column(name="email", nullable=false)
	private String email;
	
	@Column(name="password", nullable=false)
    private String password;

	@Column(name="enabled", nullable=false)
    public Boolean enabled;
	
	@Column(name="role", nullable=false)
    public Role role;
	
	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(name = "user_to_group", 
	joinColumns = { @JoinColumn(name = "user_id", referencedColumnName = "user_id") }, 
	inverseJoinColumns = { @JoinColumn(name = "group_id", referencedColumnName = "group_id") })
	@Fetch(FetchMode.JOIN)
	private List<Group> groups;
	    
}