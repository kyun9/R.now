package dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dto.User;

@Repository
public class UserDAO {
	@Autowired
	SqlSession session = null;

	public boolean insert(User user) {
		String statement = "UserMapper.insert";
		if (session.insert(statement, user) != 1)
			return false;
		return true;
	}

	public User login(User user) {
		String statement = "UserMapper.getUserInfo";
		return session.selectOne(statement, user.getEmail());
	}
	
	public String getPassword(String id) {
		String statement = "UserMapper.getPassword";
		String encodedPassword = session.selectOne(statement, id);
		return encodedPassword;
	}
}
