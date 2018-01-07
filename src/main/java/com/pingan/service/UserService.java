package com.pingan.service;

import java.util.List;

import com.pingan.pojo.User;

public interface UserService extends BaseService{

	public void add(User user);

	public User queryById(String id);

	public List<User> queryAll();
	
	public User queryByIdOn129(String id);
	
	public User queryByIdOn130(String id);
	
	public User queryByIdOn131(String id);
}
