package com.project.rnow.service;

import com.project.rnow.vo.UserVO;

public interface LoginService {
	//로그인 
	public UserVO login(UserVO dto);
	
	//비밀번호 암호화 얻기
	public String getEncodedPassword(String password);
	
	
	
}
