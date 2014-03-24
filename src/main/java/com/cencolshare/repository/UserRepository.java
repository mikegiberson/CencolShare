package com.cencolshare.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cencolshare.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {

    
    List<User> findAll();
    
    User findByEmail(String email);
    
    User findByVerifyToken(String token);
    
    
}
