package com.daqsoft.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.daqsoft.dao.UserDAO;
import com.daqsoft.dao.impl.UserDAOImpl;


public class CheakUserNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
			String username = request.getParameter("username");
			UserDAO userDAO = new UserDAOImpl();
			boolean flag = userDAO.checkUserName(username);
			response.setContentType("text/html;charset=UTF-8");
			if(flag) {
				response.getWriter().write("用户已存在！");
			}else {
				response.getWriter().write("<font color='black'>用户名可用！</font>");
			}
			
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
