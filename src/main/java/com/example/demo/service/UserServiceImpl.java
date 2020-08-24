package com.example.demo.service;

import com.example.demo.dao.UserDAO;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;
    @Override
    @CachePut(value = "user",key = "user.id")
    public Boolean save(User user) {
        User u = userDAO.findOne(user.getUsername());
        if(u!=null){
            return false;
        }else {
            int row = userDAO.save(user);
            return row==1;
        }
    }

    @Override
    public User findByUsername(String username) {
        return userDAO.findOne(username);
    }

    @Override
    public Boolean delete(String username) {
        int row = userDAO.delete(username);
        return row==1?true:false;
    }

    @Override
    public List<User> findAll() {
        return userDAO.findAll();
    }

    @Override
    public Boolean update(User user) {
        int row = userDAO.update(user);
        return row==1?true:false;
    }
}
