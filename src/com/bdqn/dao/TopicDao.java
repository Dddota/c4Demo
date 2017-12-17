package com.bdqn.dao;

import java.sql.Connection;
import java.util.List;

import com.bdqn.model.Topic;
import com.bdqn.utils.Page;

public interface TopicDao {
	
	/**
	 * ���
	 * @param conn
	 * @return
	 */
	List<Topic> getAllTopic(Connection conn);	
	/**
	 * 获取所有主题�
	 * @param conn
	 * @param tid
	 * @return
	 */
	int delTopicByTid(Connection conn, int tid);
	/**
	 * �删除主题 通过tid��
	 * @param conn
	 * @param tname
	 * @return
	 */
	Topic selectTopicByTname(Connection conn, String tname);
	/**
	 * 获取主题通过名称�
	 * @param conn
	 * @param topic
	 * @return
	 */
	int addTopic(Connection conn, Topic topic);
	/**
	 * 更改主题
	 * @param conn
	 * @param topic
	 * @return
	 */
	int updateTopic(Connection conn, Topic topic);
	/**
	 * 获取主题通过tid
	 * @param conn
	 * @param tid
	 * @return
	 */
	Topic selectTopicByTid(Connection conn, int tid);
	
	/**
	 * 模糊查找
	 * @param conn
	 * @param info 查找关键字
	 * @return
	 */
	List<Topic> getTopicLikeName(String info, Connection conn);
	
	/**
	 * 模糊查询  +分页
	 * @param info
	 * @param conn
	 * @param page
	 * @return
	 */
	List<Topic> getTopicLikeNamePage(String info, Connection conn, Page page);

	/**
	 * 模糊查询  记录数
	 * @param info
	 * @param conn
	 * @return
	 */
	int getTopicLikeNameCount(String info, Connection conn);
}
