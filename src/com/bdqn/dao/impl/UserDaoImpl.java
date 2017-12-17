package com.bdqn.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.bdqn.dao.UserDao;

import com.bdqn.model.User;
import com.bdqn.utils.DataSourceUtil;

public class UserDaoImpl implements UserDao {

	public User selectUserByUnUp(User user, Connection conn) {
		int row =0;
		PreparedStatement ps=null;
		ResultSet rs=null;
		User nuser=null;

		String sql = "select * from news_users where uname=? and upwd=?";		
		try {
			Object[] oo={user.getuName(),user.getuPwd()};
			rs=DataSourceUtil.executeQuery(conn, ps, sql, oo);
			while (rs.next()) {
				nuser=new User();
				nuser.setuId(rs.getInt(1));
				nuser.setuName(rs.getString(2));
				nuser.setuPwd(rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DataSourceUtil.closeAll(ps, null,rs);
		}
		return nuser;
	}

}
