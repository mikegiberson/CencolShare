package com.cencolshare.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;
import org.omg.PortableInterceptor.USER_EXCEPTION;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cencolshare.model.User;
import com.cencolshare.repository.UserRepository;
import com.cencolshare.service.UserService;
@Transactional
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@PersistenceContext
	EntityManager em;
	
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

	@Override
	public User loadUserById(long userId) {
		final List<User> user= userRepository.findAll();
		 User matchedUser=new User();
		for(int i=0;i<user.size();i++)
		{
			if(user.get(i).getUserId()==userId)
			{
				matchedUser=user.get(i);
				break;
			}
		}
		return matchedUser;
	}

	
	

}
