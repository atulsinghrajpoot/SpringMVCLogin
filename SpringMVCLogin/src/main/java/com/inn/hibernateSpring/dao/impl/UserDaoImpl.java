package com.inn.hibernateSpring.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;

import com.inn.hibernateSpring.dao.IUserDao;

public class UserDaoImpl implements IUserDao {

	@Autowired
	HibernateTemplate hibernateTemplate;

	@Override
	public boolean isValidLogin(String userName, String password) {
		Session session = hibernateTemplate.getSessionFactory().openSession();
		Query query = session.createQuery("from User where username=:userName and password=:password").setParameter("password", password).setParameter("userName", userName);
		if(query.uniqueResult()!=null){
			return true;
		}
		return false;
	}
	
	

}
