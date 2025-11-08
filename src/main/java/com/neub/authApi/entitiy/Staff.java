package com.neub.authApi.entitiy;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "staff")
@Entity
public class Staff {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long staffId;
	
    private Long centerId;

    private String name;

    private String phoneNumber;

    private String email;

    private String nidOrBirthCertificate;

    @Column(nullable = false)
    private String password;

    private Boolean isActive;

    private LocalDate createdDate;

	public Long getStaffId() {
		return staffId;
	}

	public void setStaffId(Long staffId) {
		this.staffId = staffId;
	}

	public Long getCenterId() {
		return centerId;
	}

	public void setCenterId(Long centerId) {
		this.centerId = centerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNidOrBirthCertificate() {
		return nidOrBirthCertificate;
	}

	public void setNidOrBirthCertificate(String nidOrBirthCertificate) {
		this.nidOrBirthCertificate = nidOrBirthCertificate;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}
    
    
}
