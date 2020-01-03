package com.daqsoft.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.daqsoft.utils.JDBCUtils;

public class BasicDAO {
	QueryRunner queryRunner = new QueryRunner();
	
	public int update(String sql,Object... args){
		Connection connection = JDBCUtils.getConnection();
		int count=0;
		try {
			count = queryRunner.update(connection,sql, args);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtils.free();
		}	
		return count;
	}

	public <T> T getBean(Class<T> clazz,String sql,Object... args){
		Connection connection = JDBCUtils.getConnection();
		T t = null;
		try {
			t = queryRunner.query(connection, sql, new BeanHandler<T>(clazz), args);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtils.free();
		}
		return t;
	}
	public <T> List<T> getBeanList(Class<T> clazz,String sql,Object... args){
		Connection connection = JDBCUtils.getConnection();
		List<T> beanList = null;
		try {
			beanList = queryRunner.query(connection, sql, new BeanListHandler<T>(clazz), args);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtils.free();
		}
		return beanList;
	}
}
