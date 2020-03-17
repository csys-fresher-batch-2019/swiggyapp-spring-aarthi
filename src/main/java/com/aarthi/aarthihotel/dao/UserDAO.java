package com.aarthi.aarthihotel.dao;

import java.util.HashMap;
import java.util.List;

import com.aarthi.aarthihotel.exception.DbException;
import com.aarthi.aarthihotel.model.User;

public interface UserDAO {
	public List<User> findAll() throws DbException;

	public HashMap<String, Integer> findByNameAndTotalAmt(int orderId) throws DbException;

	public int save(User ob) throws DbException;

	public String findByNameAndPhoneNo(String name, Long phoneno) throws DbException;

	public int findUserId(String name, Long phoneno) throws DbException;

	public String findByNameAndPassWord(String userName, String passWord) throws DbException;

	public int findOrderId(int userId) throws DbException;

	public int ValidNumber(Long phoneNo) throws DbException;
}
