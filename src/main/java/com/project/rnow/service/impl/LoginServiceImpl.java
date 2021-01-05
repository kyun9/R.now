package com.project.rnow.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.rnow.dao.UserDAO;
import com.project.rnow.service.LoginService;
import com.project.rnow.vo.UserVO;

@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	UserDAO dao;
	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	@Override
	public UserVO login(UserVO vo) {
		
		if (passwordEncoder.matches(vo.getUserPassword(), dao.getPassword(vo.getUserEmail()))) {
			return dao.login(vo);
		} else {
			return null;
		}
	}

	@Override
	public String getEncodedPassword(String password) {
		return passwordEncoder.encode(password);
	}
}
