package com.cencolshare.service;

import com.cencolshare.model.User;

public interface UserService {
  
  public User loadUserByUsername(String username);

  public User insertUser(String username, String password);
}
