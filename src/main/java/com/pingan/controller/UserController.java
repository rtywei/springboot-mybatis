package com.pingan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.druid.support.json.JSONUtils;
import com.pingan.pojo.User;
import com.pingan.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController{

	@Autowired
	public UserService userService;
	
    @RequestMapping("/add")
    @ResponseBody
    public void add(User user) {
    	userService.add(user);
    }
    
    @RequestMapping("/queryById/{id}/{ip}")
    @ResponseBody
    public String queryById(@PathVariable String id,@PathVariable Integer ip) {
    	User user = null;
    	if(ip == 129){
    		user = userService.queryByIdOn129(id);
    	} else if(ip == 130) {
    		user = userService.queryByIdOn130(id);
    	} else if(ip == 131) {
    		user = userService.queryByIdOn131(id);
    	} else {
    		user = userService.queryById(id);
    	}
		return user.toString();
    }

    @RequestMapping("/queryAll")
    @ResponseBody
    public String queryAll() {
    	List<User> list = userService.queryAll();
    	return JSONUtils.toJSONString(list);
    }
}