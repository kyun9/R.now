package com.project.rnow;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegisterController {
	
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String getLogin() {
		return "auth/register";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String postLogin(String email, String name, String pwd) {
		System.out.println("email : "+email +" name : " +name+ " pwd : "+ pwd);
		return "auth/register";
	}
	
}
