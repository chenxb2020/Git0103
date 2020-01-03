package com.daqsoft.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;

import com.daqsoft.bean.User;
import com.daqsoft.dao.UserDAO;
import com.daqsoft.dao.impl.UserDAOImpl;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UserDAO userDAO = new UserDAOImpl();
		User user = userDAO.getUserNameAndPassword(username, password);
		if(user!=null) {
			HttpSession session = request.getSession();
			session.setAttribute("user",user );
		 response.sendRedirect(request.getContextPath()+"/GetUsersServlet");
		}else {
			request.setAttribute("msg", "”√ªß√˚√‹¬Î¥ÌŒÛ£°");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/login.jsp");
			dispatcher.forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
