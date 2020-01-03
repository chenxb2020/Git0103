package com.daqsoft.dao;

import java.util.List;

import com.daqsoft.bean.User;

public interface UserDAO {
	
	
	User getUserNameAndPassword(String username,String password);

/**
 * �����û������Ҷ�Ӧ�ļ�¼
 * @param username
 * @return
 * turn �û����Ѵ���
 */
	boolean checkUserName(String username);
	
/**
 * ����һ������
 */
   void saveUser(String username, String password, String email);
   
   List<User> getUsers();
}
