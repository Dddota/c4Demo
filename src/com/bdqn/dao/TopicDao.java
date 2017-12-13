package com.bdqn.dao;

import java.util.List;

import com.bdqn.model.Topic;

public interface TopicDao {
	
	public List<Topic> listAllTopic();
	
	public int addTopic(Topic topic);
	
	public int delTopicByTid(int tid);
	
	public int updateTopicByTid(Topic topic);

	public Topic findTopicByTid(int tid);
}
