package com.aarthi.aarthihotel.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;
import org.springframework.stereotype.Component;

import com.aarthi.aarthihotel.exception.DbException;
@Component
public class ConnectionUtil {
	public static Connection getConnection() throws DbException {
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			con = DriverManager.getConnection("jdbc:oracle:thin:@13.235.147.120:1521:XE", "aarthi", "aarthi");
		} catch (ClassNotFoundException e) {
			throw new DbException("ClassNotFoundException");
		} catch (SQLException e) {
			throw new DbException("DB Connection Error");
		}
		System.out.println(con);
		return con;
	}

	public static Jdbi getjdbi() {
		Jdbi jdbi = null;
		try {
			Connection connection = getConnection();
			jdbi = Jdbi.create(connection);
			jdbi.installPlugin(new SqlObjectPlugin());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jdbi;

	}
}
