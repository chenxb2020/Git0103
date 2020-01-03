package com.daqsoft.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.daqsoft.dao.UserDAO;
import com.daqsoft.dao.impl.UserDAOImpl;

/**
 * Servlet implementation class RegistServlet
 */
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		UserDAO userDAO = new UserDAOImpl();
		boolean flag = userDAO.checkUserName("username");
		if(flag) {
			request.setAttribute("msg", "用户名已存在！");
			request.getRequestDispatcher("/pages/regist.jsp").forward(request, response);
		}else {
			userDAO.saveUser(username, password, email);
			response.sendRedirect(request.getContextPath()+"/pages/login.jsp");
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
