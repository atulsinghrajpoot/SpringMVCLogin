package com.inn.hibernateSpring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.inn.hibernateSpring.dao.IUserDao;
import com.inn.hibernateSpring.service.IUserService;

public class UserServiceImpl implements IUserService {

	@Autowired
	IUserDao userDao;

	@Override
	public boolean isValidLogin(String userName, String password) {
		return userDao.isValidLogin( userName, password) ;
	}
	
	

}
