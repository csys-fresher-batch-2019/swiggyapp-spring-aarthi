package com.aarthi.aarthihotel.dao;

import com.aarthi.aarthihotel.dao.impl.DiscountDAOImpl;
import com.aarthi.aarthihotel.dao.impl.FoodItemDAOImpl;
import com.aarthi.aarthihotel.dao.impl.MenuDAOImpl;
import com.aarthi.aarthihotel.dao.impl.OrderDAOImpl;
import com.aarthi.aarthihotel.dao.impl.OrderItemDAOImpl;
import com.aarthi.aarthihotel.dao.impl.RatingDAOImpl;
import com.aarthi.aarthihotel.dao.impl.UserDAOImpl;

public class DAOFactory {
	public static DiscountDAO getDiscountDAO() {
		DiscountDAO d = new DiscountDAOImpl();
		return d;
	}

	public static FoodItemDAO getFoodItemDAO() {
		FoodItemDAO f = new FoodItemDAOImpl();
		return f;
	}

	public static MenuDAO getMenuDAO() {
		MenuDAO m = new MenuDAOImpl();
		return m;
	}

	public static OrderDAO getOrderDAO() {
		OrderDAO ob = new OrderDAOImpl();
		return ob;
	}

	public static OrderItemDAO getOrderItemDAO() {
		OrderItemDAO obj = new OrderItemDAOImpl();
		return obj;
	}

	public static RatingDAO getRatingDAO() {
		RatingDAO r = new RatingDAOImpl();
		return r;
	}

	public static UserDAO getUserDAO() {
		UserDAO u = new UserDAOImpl();
		return u;
	}

}
