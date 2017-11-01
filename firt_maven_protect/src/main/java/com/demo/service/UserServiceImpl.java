package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.UserDao;
import com.demo.entity.User;
@Service
public class UserServiceImpl implements UserService {
	 @Autowired 
	 private UserDao userDao;  


	@Override
	public User selectUserById(Integer userId) {
		return userDao.selectUserById(userId);
	}

}
