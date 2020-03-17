package com.aarthi.aarthihotel.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.aarthi.aarthihotel.dao.FoodItemDAO;
import com.aarthi.aarthihotel.exception.DbException;
import com.aarthi.aarthihotel.exception.ErrorConstant;
import com.aarthi.aarthihotel.model.FoodItem;
import com.aarthi.aarthihotel.util.ConnectionUtil;
import com.aarthi.aarthihotel.util.LoggerUtil;

@Repository
public class FoodItemDAOImpl implements FoodItemDAO {
	public static final LoggerUtil logger = LoggerUtil.getInstance();

	public List<FoodItem> findAll() throws DbException {
		List<FoodItem> l = new ArrayList<FoodItem>();
		String sql = "select item_id,item_name,food_type,price,menu_id,images from foodstuff_items";
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {
			try (ResultSet ro = pst.executeQuery()) {
				while (ro.next()) {
					FoodItem ob = new FoodItem();
					ob.setItemId(ro.getInt("item_id"));
					ob.setItemName(ro.getString("item_name"));
					ob.setFoodType(ro.getString("food_type"));
					ob.setPrice(ro.getInt("price"));
					ob.setMenuId(ro.getInt("menu_id"));
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

	public int updateMenuId(int menuId, String itemName) throws DbException {
		String sqlQuery = "update foodstuff_items set menu_id=? where item_name=?";
		int row1 = 0;
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sqlQuery)) {
			pst.setInt(1, menuId);
			pst.setString(2, itemName);
			row1 = pst.executeUpdate();
			logger.info(row1 + "row updated");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(ErrorConstant.INVALID_UPDATE);
		} catch (DbException e1) {
			e1.printStackTrace();
			throw new DbException(ErrorConstant.INVALID_CON_ERROR);
		}
		return row1;
	}

	public int save(String itemName, String foodType, int price, int menuId, String images) throws DbException {
		String sqlQuery = "insert into foodstuff_items(item_id,item_name,food_type,price,menu_id,images)values(item_id.nextval,?,?,?,?,?)";
		int row = 0;
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sqlQuery)) {
			pst.setString(1, itemName);
			pst.setString(2, foodType);
			pst.setInt(3, price);
			pst.setInt(4, menuId);
			pst.setString(5, images);
			logger.debug(sqlQuery);
			row = pst.executeUpdate();
			logger.info(row + "row inserted");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(ErrorConstant.INVALID_SAVE);
		} catch (DbException e1) {
			e1.printStackTrace();
			throw new DbException(ErrorConstant.INVALID_CON_ERROR);
		}
		return row;
	}

	public List<FoodItem> findByFoodType(String foodType) throws DbException {
		String sql1 = "select item_name,price from foodstuff_items where food_type=?";
		List<FoodItem> list = new ArrayList<FoodItem>();
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sql1)) {
			pst.setString(1, foodType);
			try (ResultSet ro1 = pst.executeQuery()) {
				while (ro1.next()) {
					FoodItem ob = new FoodItem();
					ob.setItemName(ro1.getString("item_name"));
					ob.setPrice(ro1.getInt("price"));
					list.add(ob);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(ErrorConstant.INVALID_SELECT);
		} catch (DbException e1) {
			e1.printStackTrace();
			throw new DbException(ErrorConstant.INVALID_CON_ERROR);
		}
		return list;
	}

	public List<FoodItem> findBySearchName(String searchname) throws DbException {
		List<FoodItem> l1 = new ArrayList<FoodItem>();
		String sql = "select item_id,item_name,food_type,price,menu_id,images from foodstuff_items where item_name like ?";
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {
			pst.setString(1, "%" + searchname + "%");
			try (ResultSet ro = pst.executeQuery()) {
				while (ro.next()) {
					FoodItem ob = new FoodItem();
					ob.setItemId(ro.getInt("item_id"));
					ob.setItemName(ro.getString("item_name"));
					ob.setFoodType(ro.getString("food_type"));
					ob.setPrice(ro.getInt("price"));
					ob.setMenuId(ro.getInt("menu_id"));
					ob.setImages(ro.getString("images"));
					l1.add(ob);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(ErrorConstant.INVALID_SELECT);
		} catch (DbException e1) {
			e1.printStackTrace();
			throw new DbException(ErrorConstant.INVALID_CON_ERROR);
		}

		return l1;
	}

	public int deleteItem(String itemName) throws DbException {
		String sqlQuery = "delete from foodstuff_items where item_name=?";
		int row = 0;
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sqlQuery)) {
			pst.setString(1, itemName);
			logger.debug(sqlQuery);
			row = pst.executeUpdate();
			logger.info(row + "row deleted");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(ErrorConstant.INVALID_DELETE);
		} catch (DbException e1) {
			e1.printStackTrace();
			throw new DbException(ErrorConstant.INVALID_CON_ERROR);
		}
		return row;
	}
}
