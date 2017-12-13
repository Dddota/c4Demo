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
	 * ��ʼ���������ݿ�������Ϣ
	 */
	public static void init(){
		//�½�һ��Properties����
		Properties pp=new Properties();
		//��������ļ���io����
		InputStream io=BaseDao.class.getClassLoader().getResourceAsStream("database.properties");
		try {
			pp.load(io);//���������ļ�
		} catch (IOException e) {
			e.printStackTrace();
		}
		url=pp.getProperty("url");
		user=pp.getProperty("user");
		password=pp.getProperty("password");
		driver=pp.getProperty("driver");
			
	}

	/**
	 * ������ӵķ���
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
	 * ��ɾ��ͨ�÷���
	 * @param sql
	 * @param oo
	 * @return
	 */
	public int excuteUpdate(String sql,Object[] oo) {
		//�������
		conn=getConnection();
		//���ִ��sql�Ķ���
		PreparedStatement ps=null;
		int num=0;
		try {
			ps=conn.prepareStatement(sql);
			if (oo!=null) {
				for (int i = 0; i < oo.length; i++) {
					ps.setObject(i+1, oo[i]);//��sql�е�ռλ����ֵ
				}				
			}
			num=ps.executeUpdate();//ִ��sql,������Ӱ������
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//�ر�����
			colseAll(conn, ps, null);
		}
		return num;
	}
	
	/**
	 * ��ѯͨ�÷���
	 * @param sql
	 * @param oo
	 * @return  select * from pet
	 */
	public ResultSet excuteQuery(String sql,Object[] oo) {
		//�������
		conn=getConnection();
		//���ִ��sql�Ķ���
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=conn.prepareStatement(sql);
			if (oo!=null) {
				for (int i = 0; i < oo.length; i++) {
					ps.setObject(i+1, oo[i]);//��sql�е�ռλ����ֵ
				}				
			}	
			rs=ps.executeQuery();//ִ��sql,������Ӱ������
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			//�ر�����
			/*colseAll(conn, ps, null);*/
		}
		return rs;
	}

	/*
	 * �ر����ӵķ���
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
