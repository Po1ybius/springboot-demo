package com.example.demo.controller;


import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    //http://localhost:8080/post?username=alex&password=112358
    @RequestMapping("/post")
    public Map<String,Object> post(User user){
        Map<String,Object> map = new HashMap<>();
        Boolean state = userService.save(user);
        try {
            map.put("state",state);
            if(state==true){
                map.put("msg","save successful");
            }else {
                map.put("msg","save failure,username already exists");
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put("state",state);
            map.put("msg",e.getMessage());
        }
        return map;
    }
    //http://localhost:8080/put?username=admin
    @RequestMapping("/put")
    @ResponseBody
    public User put(String username){
        return userService.findByUsername(username);

    }

    //http://localhost:8080/delete?username=admin
    @RequestMapping("/delete")
    public Map<String,Object> delete(String username){
        Map<String,Object> map = new HashMap<>();
        Boolean state = userService.delete(username);
        try {
            map.put("state",state);
            if(state==true){
                map.put("msg","delete successful");
            }else {
                map.put("msg","delete failure");
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put("state",state);
            map.put("msg",e.getMessage());
        }
        return map;
    }

    //http://localhost:8080/put/users
    @RequestMapping("/put/users")
    @ResponseBody
    public List<User> findAll(){
        return userService.findAll();
    }

    //http://localhost:8080/update?id=8
    @RequestMapping("/update")
    public Map<String,Object> update(User user){
        Map<String,Object> map = new HashMap<>();
        Boolean state = userService.update(user);
        try {
            map.put("state",state);
            if(state==true){
                map.put("msg","update successful");
            }else {
                map.put("msg","update failure");
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put("state",state);
            map.put("msg",e.getMessage());
        }
        return map;
    }
}
