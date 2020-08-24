package com.example.demo.dao;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;


@Mapper
@Component(value = "UserDAO")
public interface UserDAO {

    int save(User user);
    User findOne(String username);
    int delete(String username);
    List<User> findAll();
    int update(User user);
}
