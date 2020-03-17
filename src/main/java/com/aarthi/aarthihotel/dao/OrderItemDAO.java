package com.aarthi.aarthihotel.dao;

import java.util.List;

import com.aarthi.aarthihotel.exception.DbException;
import com.aarthi.aarthihotel.model.OrderItem;

public interface OrderItemDAO {
	public List<OrderItem> findAll() throws DbException;

	public String updateStatus(int orderId, String comments) throws DbException;

	public int save(OrderItem ab) throws DbException;
}
