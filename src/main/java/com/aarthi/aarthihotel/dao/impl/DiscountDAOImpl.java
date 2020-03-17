package com.aarthi.aarthihotel.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.aarthi.aarthihotel.dao.DiscountDAO;
import com.aarthi.aarthihotel.dto.Item;
import com.aarthi.aarthihotel.exception.DbException;
import com.aarthi.aarthihotel.exception.ErrorConstant;
import com.aarthi.aarthihotel.util.ConnectionUtil;
import com.aarthi.aarthihotel.util.LoggerUtil;
@Repository
public class DiscountDAOImpl implements DiscountDAO {
	public static final LoggerUtil logger = LoggerUtil.getInstance();

	public int findDiscount(int orderId) throws DbException {
		float discount = 0;
		int discountAmt = 0;
		String sql = "select total_amt from orders where order_id=?";
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {
			pst.setInt(1, orderId);
			try (ResultSet ro = pst.executeQuery()) {
				int amt = 0;
				if (ro.next()) {
					amt = ro.getInt("total_amt");
				}
				if (amt >= 100 && amt <= 999) {
					discount = (float) (amt * .10);
				} else if (amt >= 1000 && amt <= 1999) {
					discount = (float) (amt * .25);
				} else {
					discount = (float) (amt * .50);
				}
				discountAmt = amt - (int) discount;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(ErrorConstant.INVALID_SELECT);
		} catch (DbException e1) {
			e1.printStackTrace();
			throw new DbException(ErrorConstant.INVALID_CON_ERROR);
		}

		return discountAmt;
	}

	public int updateDiscount(int orderId) throws DbException {
		int discount = findDiscount(orderId);
		int rows = 0;
		String sql = "update orders set after_discount=?  where order_id=?";
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {
			pst.setInt(1, discount);
			pst.setInt(2, orderId);
			rows = pst.executeUpdate();
			logger.info(rows + "row updated");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(ErrorConstant.INVALID_UPDATE);
		}
		catch (DbException e) {
			e.printStackTrace();
			throw new DbException(ErrorConstant.INVALID_CON_ERROR);
		}
		return rows;
	}

	@Override
	public List<Item> findByOrderId(int orderId) throws DbException {
		String sql = "select order_id,item_id,quantity,total_amounts,status,order_date from order_items where order_id=?";
		List<Item> list = new ArrayList<Item>();
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {
			pst.setInt(1, orderId);
			try (ResultSet ro = pst.executeQuery()) {
				while (ro.next()) {
					Item ob = new Item();
					ob.setOrderId(ro.getInt("order_id"));
					ob.setItemId(ro.getInt("item_id"));
					ob.setQuantity(ro.getInt("quantity"));
					ob.setTotalAmount(ro.getInt("total_amounts"));
					ob.setStatus(ro.getString("status"));
					ob.setOrderedDate((ro.getTimestamp("order_date").toLocalDateTime()));
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

	@Override
	public String findItemName(int itemId) throws DbException {
		String sql1 = "select item_name from foodstuff_items where item_id=? ";
		String itemName = null;
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sql1)) {
			pst.setInt(1, itemId);
			try (ResultSet ro1 = pst.executeQuery()) {
				if (ro1.next()) {
					itemName = ro1.getString("item_name");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(ErrorConstant.INVALID_SELECT);
		} catch (DbException e1) {
			e1.printStackTrace();
			throw new DbException(ErrorConstant.INVALID_CON_ERROR);
		}
		return itemName;
	}
}
