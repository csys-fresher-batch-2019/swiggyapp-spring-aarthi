package com.aarthi.aarthihotel.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.aarthi.aarthihotel.dao.RatingDAO;
import com.aarthi.aarthihotel.exception.DbException;
import com.aarthi.aarthihotel.exception.ErrorConstant;
import com.aarthi.aarthihotel.model.Rating;
import com.aarthi.aarthihotel.util.ConnectionUtil;
import com.aarthi.aarthihotel.util.LoggerUtil;
@Repository
public class RatingDAOImpl implements RatingDAO {
	public static final LoggerUtil logger = LoggerUtil.getInstance();

	public List<Rating> findAll() throws DbException {
		List<Rating> l = new ArrayList<Rating>();
		String sqlQuery = "select user_id,item_id,rating_points from ratings";
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement stmt = con.prepareStatement(sqlQuery)) {
			try (ResultSet ro = stmt.executeQuery()) {
				while (ro.next()) {
					Rating ob = new Rating();
					int a = ro.getInt("user_id");
					int b = ro.getInt("item_id");
					int c = ro.getInt("rating_points");
					ob.setUserId(a);
					ob.setItemId(b);
					ob.setRatingPoints(c);
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

	public int save(Rating ob) throws DbException {
		String sqlQuery = "insert into ratings(user_id,item_id,rating_points) values(?,?,?)";
		int row = 0;
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(sqlQuery)) {
			pst.setInt(1, ob.getUserId());
			pst.setInt(2, ob.getItemId());
			pst.setInt(3, ob.getRatingPoint());
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

	public int findRate(String itemName) throws DbException {
		List<Rating> ratings = findByItemName(itemName);
		int sum = 0;
		float avg = 0;
		int rate = 0;
		for (Rating ratingDetails : ratings) {
			sum = sum + ratingDetails.getRatingPoint();
		}
		if (!ratings.isEmpty()) {
			avg = (float) (sum / ratings.size());
			rate = (int) avg;
		}
		return rate;
	}

	public List<Rating> findByItemName(String itemName) throws DbException {
		int sum = 0, c = 0;
		String query = "select r.user_id,f.item_id, f.item_name, r.rating_points from ratings r,foodstuff_items f where f.item_id=r.item_id and item_name=? order by r.created_date desc";
		List<Rating> list = new ArrayList<Rating>();
		try (Connection con = ConnectionUtil.getConnection(); PreparedStatement pst = con.prepareStatement(query);) {
			pst.setString(1, itemName);
			try (ResultSet ro1 = pst.executeQuery()) {
				while (ro1.next()) {
					Rating ob = new Rating();
					ob.setUserId(ro1.getInt("user_id"));
					ob.setItemId(ro1.getInt("item_id"));
					ob.setItemName(ro1.getString("item_name"));
					ob.setRatingPoints(ro1.getInt("rating_points"));
					sum = sum + ob.getRatingPoint();
					c++;
					list.add(ob);
				}
				float avg = 0;
				if (c != 0) {
					avg = sum / c;
				}
				logger.debug((int) avg);
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
}
