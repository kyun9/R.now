package com.project.rnow;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLogin() {
		return "auth/login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String postLogin(String email, String pwd) {
		System.out.println("email : "+email + " pwd : "+ pwd);
		return "auth/login";
	}
	
}
