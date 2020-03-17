package com.aarthi.aarthihotel.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.aarthi.aarthihotel.exception.DbException;
import com.aarthi.aarthihotel.service.UserService;

@Service
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserService user = new UserService();
		HttpSession session = request.getSession();
		String a = null;
		// boolean inserted = false;
		String name = request.getParameter("name");
		PrintWriter out = response.getWriter();
		Long phoneNo = Long.parseLong(request.getParameter("number"));
		try {
			a = user.login(name, phoneNo);
			out.println(a);
			if (a.equals("Welcome" + " " + name)) {

				response.sendRedirect("listfoods.jsp");
				session.setAttribute("name", name);
				session.setAttribute("phoneno", phoneNo);

			} else {

				response.sendRedirect("login.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		/*
		 * if(inserted) { /*RequestDispatcher
		 * dispatch=request.getRequestDispatcher("orderfood.jsp");
		 * dispatch.forward(request,response);
		 */
		/*
		 * response.sendRedirect("orderfood.jsp"); } else { /*RequestDispatcher
		 * dispatch=request.getRequestDispatcher("login.jsp");
		 * dispatch.forward(request,response);
		 */
		// response.sendRedirect("login.jsp");
		// }
		try {
			int userId = user.getUserId(name, phoneNo);
			session.setAttribute("UserId", userId);
			// request.setAttribute("ID",userId);
		} catch (DbException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
