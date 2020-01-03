package com.daqsoft.bean;

import java.io.Serializable;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class User implements Serializable,HttpSessionBindingListener{
	private int id;
	private String username;
	private String password;
	private String email;
	public User(int id, String username, String password, String email) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", email=" + email + "]";
	}
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public void valueBound(HttpSessionBindingEvent event) {
			HttpSession session = event.getSession();
			ServletContext application = session.getServletContext();
			Integer count = (Integer) application.getAttribute("count");
			if(count==null) {
				application.setAttribute("count", 1);
			}else {
				application.setAttribute("count", count+1);
			}
	}
	@Override
	public void valueUnbound(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
	
	
}
