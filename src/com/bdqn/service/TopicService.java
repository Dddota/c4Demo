package com.bdqn.service;

import java.sql.Connection;
import java.util.List;

import com.bdqn.model.Topic;
import com.bdqn.utils.Page;

public interface TopicService {
	
	List<Topic> getAllTopic();
	
	
	int delTopicByTid(int tid);
	
	Topic selectTopicByTname(String tname);
	
	int addTopic(Topic topic);
	
	int updateTopic(Topic topic);
	
	Topic selectTopicByTid(int tid);
	
	List<Topic> getTopicLikeName(String info);
	
	List<Topic> getTopicLikeNamePage(String info, Page page);
	
	int getTopicLikeNameCount(String info);

}
