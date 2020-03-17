package com.aarthi.aarthihotel.dao;

import com.aarthi.aarthihotel.exception.DbException;
import com.aarthi.aarthihotel.model.Order;


public interface OrderDAO {
	public int updateDeliveredDateAndStatus(int orderId) throws DbException;

	public int findTotalAmt(int orderId) throws DbException;

	public int updateTotalAmt(int orderId) throws DbException;

	public int save(Order ob) throws DbException;

	public int updateDeliveredDate(int orderId) throws DbException;
}
