package com.bdqn.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bdqn.dao.NewsDao;
import com.bdqn.model.Topic;
import com.bdqn.utils.DataSourceUtil;

public class NewsDaoImpl implements NewsDao {

	public int selectCountByTid(int tid,Connection conn) {
		
		int count =0;
		PreparedStatement ps=null;
		ResultSet rs=null;
	
		String sql="select count(1) from news where ntid=?";	
		try {
			Object[] oo={tid};
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
