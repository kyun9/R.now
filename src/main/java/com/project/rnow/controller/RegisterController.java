package com.project.rnow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project.mapper.UserSQL;
import com.project.rnow.service.LoginService;
import com.project.rnow.vo.UserVO;

@Controller
public class RegisterController {
	@Autowired
	UserSQL userSQL;
	@Autowired
	LoginService service;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String getLogin() {
		return "auth/register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView postLogin(UserVO user) {
		ModelAndView mav = new ModelAndView();

		// Bcrypt 이용한 간단한 암호화
		user.setUserPassword(service.getEncodedPassword(user.getUserPassword()));

		System.out.println(
				"email : " + user.getUserEmail() + " name : " + user.getUserName() + " pwd : " + user.getUserPassword());

		if (userSQL.insert(user)) {
			System.out.println("회원 추가 완료");
		} else {
			System.out.println("회원 추가 실패");
		}
		mav.setViewName("auth/login");
		return mav;
	}

}
