package com.neub.authApi.dto;

public class LoginUserDto {
	
	private Long userId;
	
	private String password;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LoginUserDto(Long userId, String password) {
		super();
		this.userId = userId;
		this.password = password;
	}
	
	
}
