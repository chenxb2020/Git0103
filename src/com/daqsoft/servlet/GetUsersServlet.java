package com.daqsoft.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.daqsoft.bean.User;
import com.daqsoft.dao.UserDAO;
import com.daqsoft.dao.impl.UserDAOImpl;

/**
 * Servlet implementation class GetUsersServlet
 */
public class GetUsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDAO userDAO = new UserDAOImpl();
		List<User> users = userDAO.getUsers();
		request.setAttribute("users", users);
		request.getRequestDispatcher("/pages/main.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
