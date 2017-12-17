package com.bdqn.dao;

import java.sql.Connection;

import com.bdqn.model.User;

public interface UserDao {
	
	User selectUserByUnUp(User user, Connection conn);

}
