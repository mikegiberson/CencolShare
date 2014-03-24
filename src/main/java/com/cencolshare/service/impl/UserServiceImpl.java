package com.cencolshare.service.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;
import org.omg.PortableInterceptor.USER_EXCEPTION;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cencolshare.enums.Role;
import com.cencolshare.model.Email;
import com.cencolshare.model.User;
import com.cencolshare.repository.UserRepository;
import com.cencolshare.service.UserService;
import com.cencolshare.util.GeneralUtils;
import com.cencolshare.util.MailgunEmail;

@Transactional
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	GeneralUtils utils;

	@PersistenceContext
	EntityManager em;

	@Autowired
	MailgunEmail mailgunEmail;

	@Value("${domainPath}")
	private String DOMAIN_PATH;

	@Override
	public User loadUserByUsername(String username) {
		// List<User> users = userRepository.findByUsername(username);
		// if(users.size() != 0) {
		// return users.get(0);
		// }
		return null;
	}

	@Override
	public User loadUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public User insertUser(User user) {
		
		if(user.getUserId() > 0) {
			// exisitng user
			return userRepository.save(user);
		}
		
		user.setDateJoined(utils.getCurrentTimeStamp());
		user.setEnabled(false);
		user.setRole(Role.USER);
		user.setVerifyToken(utils.generateToken());
		final User u = userRepository.save(user);
		if (u != null) {
			// send verification email
			final Email email = new Email();
			email.setTo(u.getEmail());
			email.setContent("Thank u for signing up. Please click the below link to verify your email. <br /><br />"
					+ DOMAIN_PATH + "verify/" + u.getVerifyToken()
					+ "<br /><br />Thanks,<br />CencolShare Team");
			email.setSubject("Hey " + user.getFirstName() + ", Welcome to CencolShare!");
			mailgunEmail.sendEmail(email);
		}
		return u;
	}

	@Override
	public User verifyEmail(String token) {
		final User user = userRepository.findByVerifyToken(token);
		if(user == null) {
			return null;
		} else {
			user.setEnabled(true);
			user.setVerifyToken("token processed");
			return user;
		}
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
