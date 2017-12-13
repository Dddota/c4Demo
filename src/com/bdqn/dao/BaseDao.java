package com.bdqn.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class BaseDao {
	
	private static String url;
	private static String user;
	private static String password;
	private static String driver;
	Connection conn=null;

	static{
		init();
	}

	/**
	 * 初始化配置数据库连接信息
	 */
	public static void init(){
		//新建一个Properties对象
		Properties pp=new Properties();
		//获得配置文件的io对象
		InputStream io=BaseDao.class.getClassLoader().getResourceAsStream("database.properties");
		try {
			pp.load(io);//加载配置文件
		} catch (IOException e) {
			e.printStackTrace();
		}
		url=pp.getProperty("url");
		user=pp.getProperty("user");
		password=pp.getProperty("password");
		driver=pp.getProperty("driver");
			
	}

	/**
	 * 获得连接的方法
	 * @return
	 */
	public Connection getConnection(){
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;		
	}
	
	/**
	 * 增删改通用方法
	 * @param sql
	 * @param oo
	 * @return
	 */
	public int excuteUpdate(String sql,Object[] oo) {
		//获得连接
		conn=getConnection();
		//获得执行sql的对象
		PreparedStatement ps=null;
		int num=0;
		try {
			ps=conn.prepareStatement(sql);
			if (oo!=null) {
				for (int i = 0; i < oo.length; i++) {
					ps.setObject(i+1, oo[i]);//对sql中的占位符赋值
				}				
			}
			num=ps.executeUpdate();//执行sql,并返回影响行数
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//关闭连接
			colseAll(conn, ps, null);
		}
		return num;
	}
	
	/**
	 * 查询通用方法
	 * @param sql
	 * @param oo
	 * @return  select * from pet
	 */
	public ResultSet excuteQuery(String sql,Object[] oo) {
		//获得连接
		conn=getConnection();
		//获得执行sql的对象
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=conn.prepareStatement(sql);
			if (oo!=null) {
				for (int i = 0; i < oo.length; i++) {
					ps.setObject(i+1, oo[i]);//对sql中的占位符赋值
				}				
			}	
			rs=ps.executeQuery();//执行sql,并返回影响行数
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//关闭连接
			/*colseAll(conn, ps, null);*/
		}
		return rs;
	}

	/*
	 * 关闭连接的方法
	 */
	public void colseAll(Connection conn,PreparedStatement ps,ResultSet rs){
		if (rs!=null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		}
		if (ps!=null) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		}
		if (conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		}
		
		
		
	}
	
	
	
	
	
	
	




}
