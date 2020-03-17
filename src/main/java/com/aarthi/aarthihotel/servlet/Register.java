package com.aarthi.aarthihotel.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.aarthi.aarthihotel.model.User;
import com.aarthi.aarthihotel.service.UserService;

/**
 * Servlet implementation class Register
 */
@Service
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserService user = new UserService();
		// UsersDAO ob = DAOFactory.getUsersDAO();
		User obj = new User();
		PrintWriter out = response.getWriter();
		obj.setUserName(request.getParameter("name"));
		// System.out.println("<html><body>"+"Welcome "+name+"</body></html>");

		out.println(obj.getUserName());
		obj.setPhoneNo(Long.parseLong(request.getParameter("phoneno")));
		out.println(obj.getPhoneNo());
		obj.setAddress(request.getParameter("address"));
		out.println(obj.getAddress());
		obj.setCity(request.getParameter("cities"));
		out.println(obj.getCity());
		try {
			user.insertUserInfo(obj);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher d = request.getRequestDispatcher("login.jsp");
		d.forward(request, response);
	}

}
