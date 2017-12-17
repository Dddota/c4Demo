package com.bdqn.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.bdqn.dao.NewsDao;
import com.bdqn.dao.TopicDao;
import com.bdqn.dao.impl.NewsDaoImpl;
import com.bdqn.dao.impl.TopicDaoImpl;
import com.bdqn.model.Topic;
import com.bdqn.service.TopicService;
import com.bdqn.utils.BaseDao;
import com.bdqn.utils.DataSourceUtil;
import com.bdqn.utils.Page;

public class TopicServiceImpl implements TopicService {

	private TopicDao topicDao = new TopicDaoImpl();

	private NewsDao newsDao = new NewsDaoImpl();

	public List<Topic> getAllTopic() {

  		Connection conn = DataSourceUtil.getConnection();

		List<Topic> topicList = topicDao.getAllTopic(conn);

		DataSourceUtil.closeAll(null, conn, null);

		return topicList;
	}

	public int delTopicByTid(int tid) {

		Connection conn = DataSourceUtil.getConnection();
		int num = 0;
		try {
			conn.setAutoCommit(false);

			// 获取该主题下新闻的数量
			int count = newsDao.selectCountByTid(tid, conn);

			if (count == 0) {// 没新闻
				num = topicDao.delTopicByTid(conn, tid);
			} else {
				num = -1;// 标识有新闻
			}
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			DataSourceUtil.closeAll(null, conn, null);
		}
		return num;
	}

	public Topic selectTopicByTname(String tname) {
		Connection conn = DataSourceUtil.getConnection();

		Topic t = topicDao.selectTopicByTname(conn, tname);

		DataSourceUtil.closeAll(null, conn, null);

		return t;
	}

	public int addTopic(Topic topic) {
		Connection conn = DataSourceUtil.getConnection();
		int num = 0;
		try {
			conn.setAutoCommit(false);

			num = topicDao.addTopic(conn, topic);
			conn.commit();

		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			DataSourceUtil.closeAll(null, conn, null);
		}
		return num;
	}

	public int updateTopic(Topic topic) {
		Connection conn = DataSourceUtil.getConnection();
		int num = 0;
		try {
			conn.setAutoCommit(false);

			num = topicDao.updateTopic(conn, topic);
			conn.commit();

		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			DataSourceUtil.closeAll(null, conn, null);
		}
		return num;
	}

	public Topic selectTopicByTid(int tid) {
		Connection conn = DataSourceUtil.getConnection();

		Topic t = topicDao.selectTopicByTid(conn, tid);

		DataSourceUtil.closeAll(null, conn, null);

		return t;
	}

	public List<Topic> getTopicLikeName(String info) {//模糊查找
		Connection conn = DataSourceUtil.getConnection();

		List<Topic> topicList = topicDao.getTopicLikeName(info, conn);

		DataSourceUtil.closeAll(null, conn, null);

		return topicList;
	}

	public List<Topic> getTopicLikeNamePage(String info, Page page) {//模糊查找+分页

		Connection conn = DataSourceUtil.getConnection();

		List<Topic> topicList = topicDao.getTopicLikeNamePage(info, conn, page);

		DataSourceUtil.closeAll(null, conn, null);

		return topicList;
	}

	public int getTopicLikeNameCount(String info) { //模糊查询加记录数
		Connection conn = DataSourceUtil.getConnection();
		int count = topicDao.getTopicLikeNameCount(info, conn);
		DataSourceUtil.closeAll(null, conn, null);
		return count;
	}

}
