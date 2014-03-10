package com.cencolshare.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cencolshare.model.User;
import com.cencolshare.repository.UserRepository;
import com.cencolshare.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public User loadUserByUsername(String username) {
		//List<User> users = userRepository.findByUsername(username);
		//if(users.size() != 0) {
			//return users.get(0);
		//}
		return null;
	}
	
	@Override
	public User loadUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	
	@Override
	public User insertUser(User user) {

		final User u = userRepository.save(user);
		return u;
	}

}
