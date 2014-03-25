package com.cencolshare.service;

import java.util.List;

import com.cencolshare.model.User;

public interface UserService {
  
  public User loadUserByUsername(String username);

  public User insertUser(User user);
  
  public User loadUserByEmail(String email);

  public User verifyEmail(String token);

  public User loadUserById(long userId);
  
  public List<User> getAllUsers();
  
  public List<User> searchUsers(String criteria);

}
