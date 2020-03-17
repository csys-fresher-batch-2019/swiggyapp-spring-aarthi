package com.aarthi.aarthihotel.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import com.aarthi.aarthihotel.model.FoodItem;

public class FoodItemRowMapper implements RowMapper<FoodItem> {

	@Override
	public FoodItem map(ResultSet rs, StatementContext ctx) throws SQLException {
		FoodItem food = new FoodItem();
		food.setItemId(rs.getInt("item_id"));
		food.setItemName(rs.getString("item_Name"));
		food.setFoodType(rs.getString("food_type"));
		food.setPrice(rs.getInt("price"));
		food.setMenuId(rs.getInt("menu_id"));
		food.setImages(rs.getString("images"));
		return food;
	}

}
