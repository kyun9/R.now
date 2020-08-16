package com.project.rnow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.RegisterDAO;
import dto.User;
import service.LoginUtil;

@Controller
public class RegisterController {
	@Autowired
	RegisterDAO dao;
	@Autowired
	LoginUtil loginUtil;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String getLogin() {
		return "auth/register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView postLogin(User user) {
		ModelAndView mav = new ModelAndView();

		// Bcrypt 이용한 간단한 암호화
		user.setPassword(loginUtil.getEncodedPassword(user.getPassword()));
		
		System.out.println(
				"email : " + user.getEmail() + " name : " + user.getUsername() + " pwd : " + user.getPassword());

		if (dao.insert(user)) {
			System.out.println("회원 추가 완료");
		} else {
			System.out.println("회원 추가 실패");
		}
		mav.setViewName("auth/login");
		return mav;
	}

}
