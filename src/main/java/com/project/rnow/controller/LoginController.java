package com.project.rnow.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.rnow.service.LoginService;
import com.project.rnow.vo.UserVO;

@Controller
public class LoginController {
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	@Autowired
	LoginService service;
	@Autowired

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLogin() {
		return "auth/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String postLogin(HttpSession session, UserVO user) {
		String returnURL = "";
		if (session.getAttribute("user") != null) {
			// 기존에 login이란 세션 값이 존재한다면
			session.removeAttribute("user"); // 기존값을 제거해 준다.
		}

		// 로그인이 성공하면 UserVO 객체를 반환함.
		UserVO vo = service.login(user);
		System.out.println(user);
		System.out.println(vo);
		
		if (vo != null) { // 로그인 성공
			System.out.println("email : " + vo.getUserEmail() + " pwd : " + vo.getUserPassword() +"        로그인 완료");
			session.setAttribute("user", vo); // 세션에 login인이란 이름으로 UserVO 객체를 저장해 놈.
			returnURL = "redirect:/"; // 로그인 성공시 게시글 목록페이지로 바로 이동하도록 하고
			System.out.println(session.getAttribute("user"));
		} else { // 로그인에 실패한 경우
			System.out.println("로그인실패");
			returnURL = "redirect:/login"; // 로그인 폼으로 다시 가도록 함
		}

		return returnURL; // 위에서 설정한 returnURL 을 반환해서 이동시킴
	}

	// 로그아웃 하는 부분
	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) {
		session.invalidate(); // 세션 전체를 날려버림
//      session.removeAttribute("login"); // 하나씩 하려면 이렇게 해도 됨.
		return "redirect:/login"; // 로그아웃 후 게시글 목록으로 이동하도록...함
	}

}
