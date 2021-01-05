package com.project.rnow.vo;

public class UserVO {
	String userName;
	String userPassword;
	String userEmail;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	@Override
	public String toString() {
		return "UserVO [userName=" + userName + ", userPassword=" + userPassword + ", userEmail=" + userEmail + "]";
	}
	
	
	
}
