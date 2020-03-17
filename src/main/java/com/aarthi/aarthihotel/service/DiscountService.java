package com.aarthi.aarthihotel.service;

import java.util.List;

import com.aarthi.aarthihotel.dao.DAOFactory;
import com.aarthi.aarthihotel.dao.DiscountDAO;
import com.aarthi.aarthihotel.dto.Item;
import com.aarthi.aarthihotel.exception.DbException;

public class DiscountService {
	private DiscountDAO discount = DAOFactory.getDiscountDAO();

	public int calculateDiscountAmt(int orderId) throws DbException {
		return discount.findDiscount(orderId);

	}

	public int updateDiscountAmt(int orderId) throws DbException {
		return discount.updateDiscount(orderId);
	}

	public List<Item> getItemList(int orderId) throws DbException {
		return discount.findByOrderId(orderId);
	}

	public String getItemName(int itemId) throws DbException {
		return discount.findItemName(itemId);

	}

}
