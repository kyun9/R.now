package com.project.rnow.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.rnow.vo.UserVO;

@Repository
public class UserDAO {
	@Autowired
	SqlSession session = null;

	public boolean insert(UserVO user) {
		String statement = "UserMapper.insert";
		if (session.insert(statement, user) != 1)
			return false;
		return true;
	}

	public UserVO login(UserVO user) {
		String statement = "UserMapper.getUserInfo";
		return session.selectOne(statement, user.getUserEmail());
	}
	
	public String getPassword(String email) {
		String statement = "UserMapper.getPassword";
		String encodedPassword = session.selectOne(statement, email);
		return encodedPassword;
	}
}
