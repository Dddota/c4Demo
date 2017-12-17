package com.bdqn.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DataSourceUtil {
	private static DataSource dataSource;

	static{
		getDataSource();
	}
	
	/**
	 * 获得数据源的方法
	 * @return
	 */
	public static void getDataSource() {
		Context context=null;
		try {
			context = new InitialContext();
			dataSource=(DataSource)context.lookup("java:comp/env/news");
		} catch (NamingException e) {
			e.printStackTrace();
		}		
		
	}
	/**
	 *
	 * 获得连接
	 * @return
	 */
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn= dataSource.getConnection();		
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		return conn;
	}
	
	/**
	 * 共有执行方法
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
	 * 共有查询
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
	 * 关闭资源
	 * @param ps
	 * @param conn
	 * @param rs
	 */
	public static void closeAll(PreparedStatement ps, Connection conn,
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
