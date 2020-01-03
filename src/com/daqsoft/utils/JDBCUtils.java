package com.daqsoft.utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

public class JDBCUtils {
   private static DataSource ds;
   private static ThreadLocal<Connection> local;
   
   public static DataSource getDs() {
	return ds;
}

static {
	   try {
		Properties prop = new Properties();
		prop.load(JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties"));
		ds= DruidDataSourceFactory.createDataSource(prop);
		local = new ThreadLocal();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
   
   public static Connection getConnection()  {
	   Connection conn = local.get();
	   if(conn==null) {
		   try {
			conn=ds.getConnection();
			local.set(conn);
		   } catch (SQLException e) {
			e.printStackTrace();
		   }
	   }
	   return conn;
   }

   public static void free() {
	   try {
		   Connection conn = local.get();
	   		if(conn!=null) {
	   			local.remove();
	   			conn.setAutoCommit(true);
	   			conn.close();
	   		}
	   } catch (SQLException e) {
		  e.printStackTrace();
		}
   }
}
