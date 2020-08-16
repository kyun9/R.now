package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import dao.UserDAO;
import dto.User;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserDAO dao;
	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	@Override
	public User login(User dto) {
		if(passwordEncoder.matches(dto.getPassword(), dao.getPassword(dto.getEmail()))) {
			return dao.login(dto);
		}else {
			return null;
		}
	}

}
