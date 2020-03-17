package com.aarthi.aarthihotel.service;

import java.util.List;

import com.aarthi.aarthihotel.dao.DAOFactory;
import com.aarthi.aarthihotel.dao.OrderItemDAO;
import com.aarthi.aarthihotel.exception.DbException;
import com.aarthi.aarthihotel.model.OrderItem;

public class OrderItemService {
	private OrderItemDAO orderitem = DAOFactory.getOrderItemDAO();

	public int insertorderitems(OrderItem ab) throws DbException {
		return orderitem.save(ab);
	}

	public List<OrderItem> findAll() throws DbException {
		return orderitem.findAll();
	}

	public String updateStatus(int orderId, String comments) throws DbException {
		return orderitem.updateStatus(orderId, comments);
	}

}
