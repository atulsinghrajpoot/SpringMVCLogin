package com.inn.hibernateSpring.dao;


public interface IUserDao {

	boolean isValidLogin(String userName, String password);


}