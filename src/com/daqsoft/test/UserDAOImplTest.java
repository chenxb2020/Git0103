package com.daqsoft.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.daqsoft.bean.User;
import com.daqsoft.dao.BasicDAO;
import com.daqsoft.dao.UserDAO;
import com.daqsoft.dao.impl.UserDAOImpl;

class UserDAOImplTest {

	UserDAO userDAO = new UserDAOImpl();
	@Test
	void testGetUserNameAndPassword() {
		User user = userDAO.getUserNameAndPassword("admin", "1234567");
		System.out.println(user);
	}

	@Test
	void testcheckUserName() {
		boolean flag = userDAO.checkUserName("atguigu1");
		System.out.println(flag);
	}
	
	@Test
	void testSave() {
		userDAO.saveUser("atguigu", "233", "233@sina.com");
	}
	
	@Test
	void testgetUsers() {
		List<User> users = userDAO.getUsers();
		for(User user:users) {
			System.out.println(user);
		}
	}
}
