package com.project.rnow;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dao.UserDAO;
import dto.User;
import service.UserService;

@Controller
public class LoginController {
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	@Autowired
	UserService service;
	@Autowired
	UserDAO dao;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLogin() {
		return "auth/login";
	}

	@RequestMapping(value = "/rnow/login", method = RequestMethod.POST)
	public String postLogin(HttpSession session, User user) {
		String returnURL = "";
		if (session.getAttribute("login") != null) {
			// 기존에 login이란 세션 값이 존재한다면
			session.removeAttribute("login"); // 기존값을 제거해 준다.
		}

		// 로그인이 성공하면 UserVO 객체를 반환함.
		User vo = service.login(user);
		
		
		if (vo != null) { // 로그인 성공
			System.out.println("email : " + vo.getEmail() + " pwd : " + vo.getPassword() +"        로그인 완료");
			session.setAttribute("login", vo); // 세션에 login인이란 이름으로 UserVO 객체를 저장해 놈.
			returnURL = "redirect:/"; // 로그인 성공시 게시글 목록페이지로 바로 이동하도록 하고
		} else { // 로그인에 실패한 경우
			System.out.println("로그인실패");
			returnURL = "redirect:test/login"; // 로그인 폼으로 다시 가도록 함
		}

		return returnURL; // 위에서 설정한 returnURL 을 반환해서 이동시킴
	}

	// 로그아웃 하는 부분
	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) {
		session.invalidate(); // 세션 전체를 날려버림
//      session.removeAttribute("login"); // 하나씩 하려면 이렇게 해도 됨.
		return "home"; // 로그아웃 후 게시글 목록으로 이동하도록...함
	}

}
