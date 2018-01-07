package com.pingan.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pingan.config.TargetDataSource;
import com.pingan.dao.UserMapper;
import com.pingan.pojo.User;
import com.pingan.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	public UserMapper userMapper;	
	
	public void add(User user) {
		userMapper.insert(user);
	}

	public User queryByIdOn129(String id) {
		return userMapper.selectByPrimaryKey(Integer.parseInt(id));
	}
	
	@TargetDataSource(name="ds2")
	public User queryByIdOn131(String id) {
		return userMapper.selectByPrimaryKey(Integer.parseInt(id));
	}
	
	@TargetDataSource(name="ds1")
	public User queryByIdOn130(String id) {
		return userMapper.selectByPrimaryKey(Integer.parseInt(id));
	}

	@Override
	public List<User> queryAll() {
//		return userMapper.queryAll();
		return new ArrayList<>();
	}


	@Override
	public User queryById(String id) {
		return userMapper.selectByPrimaryKey(Integer.parseInt(id));
	}
	
}
