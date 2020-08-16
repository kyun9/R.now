package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

// Bcrypt 이용한 간단한 암호화
@Service
public class LoginUtil {
	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	public String getEncodedPassword(String password) {
		return passwordEncoder.encode(password);
	}
}
