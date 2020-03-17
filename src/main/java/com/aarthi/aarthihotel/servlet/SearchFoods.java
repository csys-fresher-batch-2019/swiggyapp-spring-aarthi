package com.aarthi.aarthihotel.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.aarthi.aarthihotel.model.FoodItem;
import com.aarthi.aarthihotel.service.FoodItemService;
import com.aarthi.aarthihotel.service.MenuService;

@Service
@WebServlet("/SearchFoods")

public class SearchFoods extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		FoodItemService food = new FoodItemService();
		MenuService menu = new MenuService();
		// PrintWriter out = response.getWriter();
		String searchName = request.getParameter("itemname");
		List<FoodItem> l = new ArrayList<FoodItem>();
		try {
			String itemName = menu.toUpp(searchName);
			l = food.getFoodsDetailsBySearchName(itemName);
			request.setAttribute("searchlist", l);
			RequestDispatcher d = request.getRequestDispatcher("listfoods.jsp");
			d.forward(request, response);
		}

		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// RequestDispatcher d = request.getRequestDispatcher("listfoods4.jsp");
	// d.forward(request, response);

}
