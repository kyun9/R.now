package dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dto.User;

@Repository
public class RegisterDAO {
	@Autowired
	SqlSession session = null;

	public boolean insert(User user) {
		String statement = "RegisterMapper.insert";
		if (session.insert(statement, user) != 1)
			return false;
		return true;
	}
}
