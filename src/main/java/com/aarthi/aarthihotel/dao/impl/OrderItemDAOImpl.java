package com.aarthi.aarthihotel.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.aarthi.aarthihotel.dao.OrderItemDAO;
import com.aarthi.aarthihotel.exception.DbException;
import com.aarthi.aarthihotel.exception.ErrorConstant;
import com.aarthi.aarthihotel.model.OrderItem;
import com.aarthi.aarthihotel.util.ConnectionUtil;
import com.aarthi.aarthihotel.util.LoggerUtil;
@Repository
public class OrderItemDAOImpl implements OrderItemDAO {
	public static final LoggerUtil logger = LoggerUtil.getInstance();

	public String updateStatus(int orderId, String comments) throws DbException {

		String result = null;
		try (Connection con = ConnectionUtil.getConnection();
				CallableStatement cstmt = con.prepareCall("{call updatestatus(?,?,?)}")) {
			cstmt.setInt(1, orderId);
			cstmt.setString(2, comments);
			cstmt.registerOutParameter(3, java.sql.Types.VARCHAR);
			int row = cstmt.executeUpdate();
			result = cstmt.getString(3);
			logger.debug(result);
			logger.debug(row);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(ErrorConstant.INVALID_UPDATE);
		} catch (DbException e1) {
			e1.printStackTrace();
			throw new DbException(ErrorConstant.INVALID_CON_ERROR);
		}
		return result;
	}

	public List<OrderItem> findAll() throws DbException {
		List<OrderItem> l = new ArrayList<OrderItem>();
		String sql = "select order_item_id,order_id,item_id,quantity,total_amounts,status,order_date from order_items";
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {
			try (ResultSet ro = pst.executeQuery()) {
				while (ro.next()) {
					OrderItem ob = new OrderItem();
					ob.setOrderItemId(ro.getInt("order_item_id"));
					ob.setOrderId(ro.getInt("order_id"));
					ob.setItemId(ro.getInt("item_id"));
					ob.setQuantity(ro.getInt("quantity"));
					ob.setTotalAmounts(ro.getInt("total_amounts"));
					ob.setStatus(ro.getString("status"));
					ob.setOrderDate((ro.getTimestamp("order_date").toLocalDateTime()));
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
		return (l);
	}

	public int save(OrderItem ab) throws DbException {
		String sql = "insert into order_items(order_item_id,order_id,item_id,quantity,total_amounts,order_date)values(order_item_id.nextval,?,?,?,?,?)";
		int row1 = 0;
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {
			pst.setInt(1, ab.getOrderId());
			pst.setInt(2, ab.getItemId());
			pst.setInt(3, ab.getQuantity());
			pst.setInt(4, ab.getTotalAmount());
			pst.setTimestamp(5, Timestamp.valueOf(ab.getOrderDate()));
			row1 = pst.executeUpdate();
			logger.info(row1 + "row inserted");

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(ErrorConstant.INVALID_SAVE);
		} catch (DbException e1) {
			e1.printStackTrace();
			throw new DbException(ErrorConstant.INVALID_CON_ERROR);
		}
		return row1;
	}
}
