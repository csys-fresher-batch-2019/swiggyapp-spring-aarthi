package com.aarthi.aarthihotel.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.springframework.stereotype.Repository;

import com.aarthi.aarthihotel.dao.OrderDAO;
import com.aarthi.aarthihotel.exception.DbException;
import com.aarthi.aarthihotel.exception.ErrorConstant;
import com.aarthi.aarthihotel.model.Order;
import com.aarthi.aarthihotel.util.ConnectionUtil;
import com.aarthi.aarthihotel.util.LoggerUtil;
@Repository
public class OrderDAOImpl implements OrderDAO {
	public static final LoggerUtil logger = LoggerUtil.getInstance();

	public int updateDeliveredDateAndStatus(int orderId) throws DbException {
		String sqlQuery = "update orders set delivered_date=systimestamp,status_info='delivered' where order_id=?";
		int row1 = 0;
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sqlQuery)) {
			pst.setInt(1, orderId);
			logger.debug(sqlQuery);
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

	public int findTotalAmt(int orderId) throws DbException {
		String sql = "select sum(total_amounts) as amounts from order_items where order_id=?";
		int totalAmts = 0;
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {
			pst.setInt(1, orderId);
			try (ResultSet ro = pst.executeQuery()) {
				if (ro.next()) {
					totalAmts = ro.getInt("amounts");
					logger.debug(totalAmts);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(ErrorConstant.INVALID_SELECT);
		} catch (DbException e1) {
			e1.printStackTrace();
			throw new DbException(ErrorConstant.INVALID_CON_ERROR);
		}
		return totalAmts;
	}

	public int updateTotalAmt(int orderId) throws DbException {

		String sql = "update orders set total_amt = ( select sum(total_amounts)as amounts from order_items  where order_id=?)  where order_id =?";
		int rows = 0;
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {
			pst.setInt(1, orderId);
			pst.setInt(2, orderId);
			System.out.print(sql);
			rows = pst.executeUpdate();
			logger.info("row updated" + rows);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(ErrorConstant.INVALID_UPDATE);
		} catch (DbException e1) {
			e1.printStackTrace();
			throw new DbException(ErrorConstant.INVALID_CON_ERROR);
		}
		return rows;
	}

	public int getOrderId() {
		int orderId = 0;
		String sql = "select order_id.nextval as orderId from dual";
		try (Connection con = ConnectionUtil.getConnection();
				PreparedStatement pst = con.prepareStatement(sql);
				ResultSet rs = pst.executeQuery()) {
			if (rs.next()) {
				orderId = rs.getInt("orderId");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return orderId;
	}

	public int save(Order obj) throws DbException {
		int orderId = getOrderId();
		System.out.println("ORderID=" + orderId);
		String sql = "insert into orders(order_id,user_id,ordered_date,approxDeliveryTime)values(?,?,?,?)";
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {

			pst.setInt(1, orderId);
			pst.setInt(2, obj.getUserId());
			pst.setTimestamp(3, Timestamp.valueOf(obj.getOrderedDate()));

			pst.setTimestamp(4, Timestamp.valueOf(obj.getApproxDeliveryTime()));
			int row1 = pst.executeUpdate();
			logger.info(row1 + "row inserted");
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(ErrorConstant.INVALID_SAVE);
		} catch (DbException e1) {
			e1.printStackTrace();
			throw new DbException(ErrorConstant.INVALID_CON_ERROR);
		}
		return orderId;
	}

	public int updateDeliveredDate(int orderId) throws DbException {
		String sql = "select ordered_date from orders where order_id=?";
		int c = 0;
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {
			pst.setInt(1, orderId);
			try (ResultSet rs = pst.executeQuery()) {
				String s = null;
				if (rs.next()) {
					s = rs.getTimestamp("ordered_date") + " ";
					logger.debug(s);
					c++;

				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DbException(ErrorConstant.INVALID_SELECT);
		} catch (DbException e1) {
			e1.printStackTrace();
			throw new DbException(ErrorConstant.INVALID_CON_ERROR);
		}
		return c;
	}
}
