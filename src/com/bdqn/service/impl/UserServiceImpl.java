package com.bdqn.service.impl;

import java.sql.Connection;

import com.bdqn.dao.BaseDao;
import com.bdqn.dao.UserDao;
import com.bdqn.dao.impl.UserDaoImpl;
import com.bdqn.model.User;
import com.bdqn.service.UserService;
import com.bdqn.utils.DataSourceUtil;

public class UserServiceImpl implements UserService{

	private UserDao userDao=new UserDaoImpl();
	
	
	public User login(User user) {
		
		Connection conn= DataSourceUtil.getConnection();
		
		User nuser=userDao.selectUserByUnUp(user, conn);
		
		DataSourceUtil.closeAll(null, conn, null);
		
		return nuser;
	}

}
