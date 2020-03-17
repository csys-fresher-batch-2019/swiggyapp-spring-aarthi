package com.aarthi.aarthihotel.service;

import java.util.List;

import com.aarthi.aarthihotel.dao.DAOFactory;
import com.aarthi.aarthihotel.dao.RatingDAO;
import com.aarthi.aarthihotel.exception.DbException;
import com.aarthi.aarthihotel.model.Rating;

public class RatingService {
	private RatingDAO rate = DAOFactory.getRatingDAO();

	public List<Rating> findAll() throws DbException {
		return rate.findAll();
	}

	public int insertRatings(Rating ob) throws DbException {
		return rate.save(ob);
	}

	public List<Rating> getRatings(String itemName) throws DbException {
		return rate.findByItemName(itemName);
	}

	public int getItemRatings(String itemName) throws DbException {
		return rate.findRate(itemName);
	}
}
