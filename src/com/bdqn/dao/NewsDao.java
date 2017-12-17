package com.bdqn.dao;

import java.sql.Connection;

public interface NewsDao {
	
	/**
	 * 根据tid  查找  新闻的数量
	 * @param tid
	 * @return
	 */
	int selectCountByTid(int tid, Connection conn);
	
	

}
