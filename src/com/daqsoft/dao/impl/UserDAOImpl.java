package com.daqsoft.dao.impl;

import java.util.List;

import com.daqsoft.bean.User;
import com.daqsoft.dao.BasicDAO;
import com.daqsoft.dao.UserDAO;

public class UserDAOImpl implements UserDAO{
	BasicDAO basicDAO = new BasicDAO();
	
	@Override
	public User getUserNameAndPassword(String username, String password) {
		String sql = "select id,username,password,email from users where username=? and password=?";
		User user = basicDAO.getBean(User.class, sql, username,password);
		return user;
	}

	@Override
	public boolean checkUserName(String username) {
		String sql = "select id,username,password,email from users where username=?";
		User bean = basicDAO.getBean(User.class, sql, username);
		return bean != null;
	}

	@Override
	public void saveUser(String username, String password, String email) {
		// TODO Auto-generated method stub
		String sql = "insert into users(username,password,email) values(?,?,?)";
		basicDAO.update(sql, username,password,email);
	}

	@Override
	public List<User> getUsers() {
		String sql ="select id,username,password,email from users";
		List<User> beanList = basicDAO.getBeanList(User.class, sql);
		return beanList;
	}

}
