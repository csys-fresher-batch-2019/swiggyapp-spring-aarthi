package com.aarthi.aarthihotel.dao;

import java.util.List;

import com.aarthi.aarthihotel.exception.DbException;
import com.aarthi.aarthihotel.model.FoodItem;
import com.aarthi.aarthihotel.model.Menu;

public interface MenuDAO {
	public List<Menu> findAll() throws DbException;

	public List<Menu> findCategory() throws DbException;

	public List<FoodItem> findFoods() throws DbException;

	public List<FoodItem> findSnacksAndShakes() throws DbException;

	public List<FoodItem> findDesserts() throws DbException;

	public List<FoodItem> findByItemName(String itemName) throws DbException;

	public String toUpp(String word) throws DbException;
}
