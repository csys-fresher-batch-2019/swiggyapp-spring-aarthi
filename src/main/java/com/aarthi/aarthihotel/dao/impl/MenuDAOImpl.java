package com.aarthi.aarthihotel.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.aarthi.aarthihotel.dao.MenuDAO;
import com.aarthi.aarthihotel.exception.DbException;
import com.aarthi.aarthihotel.exception.ErrorConstant;
import com.aarthi.aarthihotel.model.FoodItem;
import com.aarthi.aarthihotel.model.Menu;
import com.aarthi.aarthihotel.util.ConnectionUtil;
import com.aarthi.aarthihotel.util.LoggerUtil;
@Repository
public class MenuDAOImpl implements MenuDAO {
	public static final LoggerUtil logger = LoggerUtil.getInstance();

	public List<Menu> findAll() throws DbException {
		List<Menu> l = new ArrayList<Menu>();
		String sql1 = "select menu_id,category from menus";
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement stmt = con.prepareStatement(sql1)) {
			try (ResultSet ro1 = stmt.executeQuery()) {
				while (ro1.next()) {
					Menu ob = new Menu();
					ob.setMenuId(ro1.getInt("menu_id"));

					ob.setCategory(ro1.getString("category"));

					l.add(ob);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(ErrorConstant.INVALID_SELECT);
		} catch (DbException e1) {
			e1.printStackTrace();
			throw new DbException(ErrorConstant.INVALID_CON_ERROR);
		}
		return l;
	}

	public List<Menu> findCategory() throws DbException {
		String sql1 = "select category from menus";
		List<Menu> l3 = new ArrayList<Menu>();
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement stmt = con.prepareStatement(sql1)) {
			try (ResultSet ro1 = stmt.executeQuery()) {
				while (ro1.next()) {
					Menu ob = new Menu();
					ob.setCategory(ro1.getString("category"));
					l3.add(ob);

				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(ErrorConstant.INVALID_SELECT);
		} catch (DbException e1) {
			e1.printStackTrace();
			throw new DbException(ErrorConstant.INVALID_CON_ERROR);
		}
		return l3;
	}

	public List<FoodItem> findByItemName(String itemName) throws DbException {
		String sql1 = "select item_name,price from foodstuff_items where item_name like ?";
		List<FoodItem> l4 = new ArrayList<FoodItem>();
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sql1)) {
			pst.setString(1, "%" + itemName + "%");
			try (ResultSet rs = pst.executeQuery()) {
				while (rs.next()) {
					FoodItem obj = new FoodItem();
					obj.setItemName(rs.getString("item_name"));
					obj.setPrice(rs.getInt("price"));
					l4.add(obj);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(ErrorConstant.INVALID_SELECT);
		} catch (DbException e1) {
			e1.printStackTrace();
			throw new DbException(ErrorConstant.INVALID_CON_ERROR);
		}
		return l4;
	}

	@Override
	public List<FoodItem> findFoods() throws DbException {
		List<FoodItem> l = new ArrayList<FoodItem>();
		String sql = "select f.item_id,f.item_name,f.food_type,f.price,f.images from foodstuff_items f,menus m where f.menu_id=m.menu_id and  m.menu_id=1";
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {
			try (ResultSet ro = pst.executeQuery()) {
				while (ro.next()) {
					FoodItem ob = new FoodItem();
					ob.setItemId(ro.getInt("item_id"));
					ob.setItemName(ro.getString("item_name"));
					ob.setFoodType(ro.getString("food_type"));
					ob.setPrice(ro.getInt("price"));
					ob.setImages(ro.getString("images"));
					l.add(ob);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(ErrorConstant.INVALID_SELECT);
		} catch (DbException e1) {
			e1.printStackTrace();
			throw new DbException(ErrorConstant.INVALID_CON_ERROR);
		}

		return l;
	}

	@Override
	public List<FoodItem> findSnacksAndShakes() throws DbException {
		List<FoodItem> l = new ArrayList<FoodItem>();
		String sql = "select f.item_id,f.item_name,f.food_type,f.price,f.images from foodstuff_items f,menus m where f.menu_id=m.menu_id and m.menu_id=2";
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {
			try (ResultSet ro = pst.executeQuery()) {
				while (ro.next()) {
					FoodItem ob = new FoodItem();
					ob.setItemId(ro.getInt("item_id"));
					ob.setItemName(ro.getString("item_name"));
					ob.setFoodType(ro.getString("food_type"));
					ob.setPrice(ro.getInt("price"));
					ob.setImages(ro.getString("images"));
					l.add(ob);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(ErrorConstant.INVALID_SELECT);
		} catch (DbException e1) {
			e1.printStackTrace();
			throw new DbException(ErrorConstant.INVALID_CON_ERROR);
		}
		return l;
	}

	@Override
	public List<FoodItem> findDesserts() throws DbException {
		List<FoodItem> l = new ArrayList<FoodItem>();
		String sql = "select f.item_id,f.item_name,f.food_type,f.price,f.images from foodstuff_items f,menus m where f.menu_id=m.menu_id and m.menu_id=3";
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {
			try (ResultSet ro = pst.executeQuery()) {
				while (ro.next()) {
					FoodItem ob = new FoodItem();
					ob.setItemId(ro.getInt("item_id"));
					ob.setItemName(ro.getString("item_name"));
					ob.setFoodType(ro.getString("food_type"));
					ob.setPrice(ro.getInt("price"));
					ob.setImages(ro.getString("images"));
					l.add(ob);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(ErrorConstant.INVALID_SELECT);
		} catch (DbException e1) {
			e1.printStackTrace();
			throw new DbException(ErrorConstant.INVALID_CON_ERROR);
		}
		return l;
	}

	public String toUpp(String word) throws DbException {
		String first = word.substring(0, 1);
		String f_after = word.substring(1);
		String res = first.toUpperCase() + f_after;
		return (res);
	}
}
