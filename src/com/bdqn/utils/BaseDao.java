package com.bdqn.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 工具类
 * 
 * @author Administrator
 * 
 */
public class BaseDao {

	private static String url = null;
	private static String user = null;
	private static String password = null;
	private static String driver = null;
	
	static{
		init();
	}
	
	/**
	 * 属性初始化
	 */
	public static void init() {
		String dir = "database.properties";

		Properties pp = new Properties();

		InputStream is = BaseDao.class.getClassLoader().getResourceAsStream(dir);

		try {
			pp.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}

		url = pp.getProperty("url");
		user = pp.getProperty("user");
		password = pp.getProperty("password");
		driver = pp.getProperty("driver");
	}

	/**
	 * 获得连接
	 * 
	 * @return
	 */
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * 公有的增删改的方法
	 */
	public static int executeUpdate(Connection conn, PreparedStatement ps,
			String sql, Object[] oo) {
		int row = 0;
		try {
			ps = conn.prepareStatement(sql);

			if (oo != null) {
				for (int i = 0; i < oo.length; i++) {
					ps.setObject(i + 1, oo[i]);
				}
			}
			row = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return row;
	}

	/**
	 * 公有的查询方法
	 */
	public static ResultSet executeQuery(Connection conn, PreparedStatement ps,
			String sql, Object[] oo) {
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);

			if (oo != null) {
				for (int i = 0; i < oo.length; i++) {
					ps.setObject(i + 1, oo[i]);
				}
			}
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;

	}

	/**
	 * 关闭连接
	 * 
	 * @param ps
	 * @param conn
	 * @param rs
	 */
	public static void colseAll(PreparedStatement ps, Connection conn,
			ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

	}

}
