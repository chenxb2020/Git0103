package com.daqsoft.dao;

import java.util.List;

import com.daqsoft.bean.User;

public interface UserDAO {
	
	
	User getUserNameAndPassword(String username,String password);

/**
 * 根据用户名查找对应的记录
 * @param username
 * @return
 * turn 用户名已存在
 */
	boolean checkUserName(String username);
	
/**
 * 插入一条数据
 */
   void saveUser(String username, String password, String email);
   
   List<User> getUsers();
}
