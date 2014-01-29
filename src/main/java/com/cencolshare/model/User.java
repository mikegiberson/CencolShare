package com.cencolshare.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.cencolshare.enums.Role;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="tbl_user")
public class User {
        
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="seq_user_id")
	@SequenceGenerator(name="seq_user_id", sequenceName="seq_user_id")
	@Column(name="user_id")
    private Integer id;

	@Column(name="username", nullable=false)
    public String username;

	@Column(name="password", nullable=false)
    public String password;

	@Column(name="enabled", nullable=false)
    public Boolean enabled;
	
	@Enumerated(EnumType.STRING)
	@Column(name="role", nullable=false)
    public Role role;
        
}