package com.neub.authApi.entitiy;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "center_information")
@Entity
public class Center {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long centerId;
	
	private String centerName;
	
	private String division;
	
	private String district;
	
	private String upozilla;
	
	private String unionName;
	
	private String latitude;
	
	private String longitude;
	
	private Long hourlyCapacity;
	
	private String phoneNumber1;
	
	private String phoneNumber2;
		
	private String email;

	public Long getCenterId() {
		return centerId;
	}

	public void setCenterId(Long centerId) {
		this.centerId = centerId;
	}

	public String getCenterName() {
		return centerName;
	}

	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getUpozilla() {
		return upozilla;
	}

	public void setUpozilla(String upozilla) {
		this.upozilla = upozilla;
	}

	public String getUnionName() {
		return unionName;
	}

	public void setUnionName(String unionName) {
		this.unionName = unionName;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public Long getHourlyCapacity() {
		return hourlyCapacity;
	}

	public void setHourlyCapacity(Long hourlyCapacity) {
		this.hourlyCapacity = hourlyCapacity;
	}

	public String getPhoneNumber1() {
		return phoneNumber1;
	}

	public void setPhoneNumber1(String phoneNumber1) {
		this.phoneNumber1 = phoneNumber1;
	}

	public String getPhoneNumber2() {
		return phoneNumber2;
	}

	public void setPhoneNumber2(String phoneNumber2) {
		this.phoneNumber2 = phoneNumber2;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
