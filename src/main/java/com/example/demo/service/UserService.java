package com.example.demo.service;

import com.example.demo.entity.User;

import java.util.List;

public interface UserService {

    Boolean save(User user);
    User findByUsername(String username);
    Boolean delete(String username);
    List<User> findAll();
    Boolean update(User user);
}
