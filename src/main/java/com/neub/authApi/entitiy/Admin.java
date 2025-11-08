package com.neub.authApi.entitiy;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "admin")
@Entity
public class Admin {
	
	@Id
	@Column(unique = true, nullable = false)
	private Long adminId;
	
	@Column(nullable = false)
	private String password;
	
	@Column(nullable = false)
	private String email;
	
	@Column(nullable = false)
	private String role; // center_admin, health_admin
	
	@Column(nullable = true)
	private String otp;

	public Long getAdminId() {
		return adminId;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	public String getRole() {
		return role;
	}

	public String getOtp() {
		return otp;
	}
}
