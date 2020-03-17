package com.aarthi.aarthihotel.dao;

import java.util.List;

import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import com.aarthi.aarthihotel.exception.DbException;
import com.aarthi.aarthihotel.mapper.FoodItemRowMapper;
import com.aarthi.aarthihotel.model.FoodItem;

public interface FoodItemDAO {
	@SqlUpdate("insert into foodstuff_items(item_id,item_name,food_type,price,menu_id,images)values(item_id.nextval,:itemName,:foodType,:price,:menuId,:images)")
	public int save(@Bind("itemName") String itemName, @Bind("foodType") String foodType, @Bind("price") int price,
			@Bind("menuId") int menuId, @Bind("images") String images) throws DbException;

	@SqlUpdate("update foodstuff_items set menu_id=? where item_name=?")
	public int updateMenuId(@Bind("menuId") int MenuId, @Bind("itemName") String itemName) throws DbException;

	@SqlQuery("select * from foodstuff_items")
	@RegisterRowMapper(FoodItemRowMapper.class)
	public List<FoodItem> findAll() throws DbException;

	@SqlQuery("select * from foodstuff_items where item_name like ('%'||?||'%')")
	@RegisterRowMapper(FoodItemRowMapper.class)
	public List<FoodItem> findBySearchName(String searchname) throws DbException;

	@SqlQuery("select * from foodstuff_items where food_type=upper(?)")
	@RegisterRowMapper(FoodItemRowMapper.class)
	public List<FoodItem> findByFoodType(String foodType) throws DbException;

	@SqlUpdate("delete from foodstuff_items where item_name=?")
	public int deleteItem(String itemName) throws DbException;

}
