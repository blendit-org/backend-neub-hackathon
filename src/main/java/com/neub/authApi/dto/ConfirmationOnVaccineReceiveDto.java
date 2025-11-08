package com.neub.authApi.dto;

public class ConfirmationOnVaccineReceiveDto {
	private Long otp;
	private Long tnxId;
	public Long getOtp() {
		return otp;
	}
	public void setOtp(Long otp) {
		this.otp = otp;
	}
	public Long getTnxId() {
		return tnxId;
	}
	public void setTnxId(Long tnxId) {
		this.tnxId = tnxId;
	}
	
}
