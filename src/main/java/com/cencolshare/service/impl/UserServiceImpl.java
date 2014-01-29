package com.cencolshare.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cencolshare.enums.Role;
import com.cencolshare.model.User;
import com.cencolshare.repository.UserRepository;
import com.cencolshare.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public User loadUserByUsername(String username) {
		List<User> users = userRepository.findByUsername(username);
		if(users.size() != 0) {
			return users.get(0);
		}
		return null;
	}
	
	@Override
	public User insertUser(String username, String password) {
		
		User u = new User();
		u.setUsername(username);
		u.setPassword(password);
		u.setEnabled(true);
		u.setRole(Role.ROLE_USER);
		u = userRepository.save(u);
		return u;
	}

}
