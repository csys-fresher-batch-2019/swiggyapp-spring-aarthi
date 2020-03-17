package com.aarthi.aarthihotel.dao;

import java.util.List;

import com.aarthi.aarthihotel.exception.DbException;
import com.aarthi.aarthihotel.model.Rating;

public interface RatingDAO {
	public List<Rating> findAll() throws DbException;

	public int save(Rating ob) throws DbException;

	public List<Rating> findByItemName(String itemName) throws DbException;

	public int findRate(String itemName) throws DbException;
}
