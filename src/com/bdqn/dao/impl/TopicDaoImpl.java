package com.bdqn.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.bdqn.dao.TopicDao;
import com.bdqn.model.Topic;
import com.bdqn.model.User;
import com.bdqn.utils.DataSourceUtil;
import com.bdqn.utils.Page;

public class TopicDaoImpl implements TopicDao {
	

	
	public List<Topic> getAllTopic(Connection conn) {
			
		int row =0;
		PreparedStatement ps=null;
		ResultSet rs=null;
	
		List<Topic> topicList=new ArrayList<Topic>();
		Topic t=null;

		String sql="select * from topic";	
		try {
			Object[] oo=null;
			rs=DataSourceUtil.executeQuery(conn, ps, sql, oo);
			
			while (rs.next()) {
				t=new Topic();
				
				t.settId(rs.getInt(1));
				t.settName(rs.getString(2));
				
				topicList.add(t);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DataSourceUtil.closeAll(ps, null,rs);
		}
		return topicList;
	}

	public int delTopicByTid(Connection conn, int tid) {
		int row =0;
		PreparedStatement ps=null;
		String sql = "delete from  topic where tid=?";
		Object[] oo={tid};
		try {	
		 row=DataSourceUtil.executeUpdate(conn, ps, sql, oo);
		}finally{
			DataSourceUtil.closeAll(ps, null,null);
		}
		return row;

	}

	public Topic selectTopicByTname(Connection conn, String tname) {
		int row =0;
		PreparedStatement ps=null;
		ResultSet rs=null;
	
		
		Topic t=null;

		String sql="select * from topic where tname=?";	
		try {
			Object[] oo={tname};
			rs=DataSourceUtil.executeQuery(conn, ps, sql, oo);
			
			while (rs.next()) {
				t=new Topic();
				
				t.settId(rs.getInt(1));
				t.settName(rs.getString(2));
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DataSourceUtil.closeAll(ps, null,rs);
		}
		return t;
	}

	public int addTopic(Connection conn, Topic topic) {
		int row =0;
		PreparedStatement ps=null;
		String sql = "insert into topic (tname) values (?)";
		Object[] oo={topic.gettName()};
		try {	
		 row=DataSourceUtil.executeUpdate(conn, ps, sql, oo);
		}finally{
			DataSourceUtil.closeAll(ps, null,null);
		}
		return row;
	}

	public int updateTopic(Connection conn, Topic topic) {
		int row =0;
		PreparedStatement ps=null;
		String sql = "update  topic set tname=? where tid=?";
		Object[] oo={topic.gettName(),topic.gettId()};
		try {	
		 row=DataSourceUtil.executeUpdate(conn, ps, sql, oo);
		}finally{
			DataSourceUtil.closeAll(ps, null,null);
		}
		return row;
	}

	public Topic selectTopicByTid(Connection conn, int tid) {
		int row =0;
		PreparedStatement ps=null;
		ResultSet rs=null;
	
		
		Topic t=null;

		String sql="select * from topic where tid=?";	
		try {
			Object[] oo={tid};
			rs=DataSourceUtil.executeQuery(conn, ps, sql, oo);
			
			while (rs.next()) {
				t=new Topic();
				t.settId(rs.getInt(1));
				t.settName(rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DataSourceUtil.closeAll(ps, null,rs);
		}
		return t;
	}

	public List<Topic> getTopicLikeName(String info, Connection conn) {

		PreparedStatement ps=null;
		ResultSet rs=null;
	
		List<Topic> topicList=new ArrayList<Topic>();
		Topic t=null;

		String sql="select * from topic where tname like concat('%',?,'%')";	
		try {
			Object[] oo={info};
			rs=DataSourceUtil.executeQuery(conn, ps, sql, oo);
			
			while (rs.next()) {
				t=new Topic();
				
				t.settId(rs.getInt(1));
				t.settName(rs.getString(2));
				
				topicList.add(t);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DataSourceUtil.closeAll(ps, null,rs);
		}
		return topicList;
	}

	public List<Topic> getTopicLikeNamePage(String info, Connection conn,
			Page page) {
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<Topic> topicList=new ArrayList<Topic>();
		Topic t=null;
		String sql="select * from topic where tname like concat('%',?,'%') limit ?,?";	
		try {
			Object[] oo={info,page.getStartIndex(),page.getPageSize()};
			rs=DataSourceUtil.executeQuery(conn, ps, sql, oo);
			while (rs.next()) {
				t=new Topic();
				t.settId(rs.getInt(1));
				t.settName(rs.getString(2));
				topicList.add(t);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DataSourceUtil.closeAll(ps, null,rs);
		}
		return topicList;
	}

	public int getTopicLikeNameCount(String info, Connection conn) {
		PreparedStatement ps=null;
		ResultSet rs=null;
		int count=0;
		String sql="select count(1) from topic where tname like concat('%',?,'%')";	
		try {
			Object[] oo={info};
			rs=DataSourceUtil.executeQuery(conn, ps, sql, oo);
			while (rs.next()) {	
				count=rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DataSourceUtil.closeAll(ps, null,rs);
		}
		return count;
	}

}
