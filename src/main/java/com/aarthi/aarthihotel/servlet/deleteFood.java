package com.aarthi.aarthihotel.servlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.aarthi.aarthihotel.exception.DbException;
import com.aarthi.aarthihotel.service.FoodItemService;




/**
 * Servlet implementation class deleteFood
 */
@Service
@WebServlet("/deleteFood")
public class deleteFood extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		FoodItemService food = new FoodItemService();
		PrintWriter out = response.getWriter();
		// FoodItemsDAO ob=DAOFactory.getFoodItemsDAO();
		String itemName = request.getParameter("itemname");
		try {
			food.deleteFoods(itemName);
			out.print("<a href='swiggy.jsp'>home</a>");
		} catch (DbException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
