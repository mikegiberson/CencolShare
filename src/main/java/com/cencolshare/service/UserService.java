package com.cencolshare.service;

import com.cencolshare.model.User;

public interface UserService {
  
  public User loadUserByUsername(String username);

  public User insertUser(User user);
  
  public User loadUserByEmail(String email);
  
  public User verifyEmail(String token);
  
}
