package com.neub.authApi.dto;

public class LoginAdminDto {
	private Long adminId;
	
	private String password;
	
	private String email;

	public Long getAdminId() {
		return adminId;
	}

	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LoginAdminDto(Long adminId, String password, String email) {
		super();
		this.adminId = adminId;
		this.password = password;
		this.email = email;
	}
	
	
}
