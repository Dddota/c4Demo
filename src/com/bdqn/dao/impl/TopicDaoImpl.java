package com.bdqn.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.bdqn.model.Topic;
import com.bdqn.dao.BaseDao;
import com.bdqn.dao.TopicDao;
public class TopicDaoImpl extends BaseDao implements TopicDao {


	public List<Topic> listAllTopic() {
		String sql="select * from topic";
		ResultSet rs=excuteQuery(sql, null);
		List<Topic> topicList=new ArrayList<Topic>();
		try {
			while (rs.next()) {
				Topic topic=new Topic();
				topic.setTid(rs.getInt(1));
				topic.setTname(rs.getString(2));
				topicList.add(topic);	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return topicList;
	}

	public int addTopic(Topic topic) {
		String sql="insert into topic (tname) values (?)";
		Object[] oo={topic.getTname()};
		
		int num=excuteUpdate(sql, oo);
		
		
		
		return num;
	}

	public int delTopicByTid(int tid) {
		String sql="delete from topic where tid =?";
		Object[] oo={tid};
		int num=excuteUpdate(sql, oo);
		return num;
	}

	public int updateTopicByTid(Topic topic) {
		String sql="update topic set  tname=? where tid=?";
		Object[] oo={topic.getTname(),topic.getTid()};
		int num=excuteUpdate(sql, oo);
		return num;
	}

	public Topic findTopicByTid(int tid){//查找topic根据tid
		String sql="select * from topic where tid =?";
		Object[] oo={tid};
		ResultSet rs=excuteQuery(sql, oo);
		Topic topic=new Topic();
		try {
			while (rs.next()){
				topic.setTid(rs.getInt(1));
				topic.setTname(rs.getString(2));
            }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return topic;
	}



}
