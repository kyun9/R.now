package com.project.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.project.rnow.vo.UserVO;

@Mapper
public interface UserSQL {

	public boolean insert(UserVO user);

	public UserVO getUserInfo(UserVO user);

	public String getPassword(String email);
}
