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
@Service
@WebServlet("/AddFood")

public class AddFood extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		FoodItemService food = new FoodItemService();
		// FoodItemsDAO ob = DAOFactory.getFoodItemsDAO();
		PrintWriter out = response.getWriter();
		String itemName = request.getParameter("itemname");
		String foodType = request.getParameter("foodtype");
		int price = Integer.parseInt(request.getParameter("price"));

		int menuId = Integer.parseInt(request.getParameter("menuid"));
		String images = request.getParameter("images");
		try {
			food.insertItems(itemName, foodType, price, menuId, images);
			out.print("<a href='swiggy.jsp'>home</a>");
		} catch (DbException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
