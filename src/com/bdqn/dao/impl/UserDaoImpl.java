package com.bdqn.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.bdqn.dao.BaseDao;
import com.bdqn.dao.UserDao;
import com.bdqn.model.User;

public class UserDaoImpl extends BaseDao implements UserDao {

	public boolean login(User user) {
		String sql="select * from news_users where uname=? and upwd=?";
		Object[] oo={user.getUname(),user.getUpwd()};
		ResultSet rs=excuteQuery(sql,oo);
		boolean isExist=false;
		try {
			if (rs.next()) {
				isExist=true;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		return isExist;
	}

}
