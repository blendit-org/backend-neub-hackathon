package com.neub.authApi.dto;

public class VerifyDto {
	private long otp;
	private String email;
	public long getOtp() {
		return otp;
	}
	public void setOtp(long otp) {
		this.otp = otp;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public VerifyDto(long otp, String email) {
		super();
		this.otp = otp;
		this.email = email;
	}
	
}
