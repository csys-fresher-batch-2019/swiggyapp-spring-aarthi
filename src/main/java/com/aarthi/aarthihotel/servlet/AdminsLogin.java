package com.aarthi.aarthihotel.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.aarthi.aarthihotel.service.UserService;

/**
 * Servlet implementation class AdminsLogin
 */
@Service
@WebServlet("/AdminsLogin")
public class AdminsLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserService user = new UserService();

		String userName = request.getParameter("username");
		String passWord = request.getParameter("password");
		try {
			String msg = user.adminLogin(userName, passWord);
			// out.println(msg);
			if (msg.equals("Welcome")) {
				response.sendRedirect("AddFoods.jsp");

			} else {
				response.sendRedirect("AdminLogin.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
