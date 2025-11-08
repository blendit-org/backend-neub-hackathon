package com.neub.authApi.dto;

import java.util.Date;

public class RegisterUserDto {
	private Long nid;
	private String fullName;
	private Date dateOfBirth;
	private String gender;
	private String fatherName;
	private String motherName;
	private String division;
	private String district;
	private String upozilla;
	private String unionName;
	private Integer postalCode;
	private String villageOrRoad;
	private String phoneNumber;
	private String email;
	private String password;
	public Long getNid() {
		return nid;
	}
	public void setNid(Long userId) {
		this.nid = userId;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public String getMotherName() {
		return motherName;
	}
	public void setMotherName(String motherName) {
		this.motherName = motherName;
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
	public Integer getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(Integer postalCode) {
		this.postalCode = postalCode;
	}
	public String getVillageOrRoad() {
		return villageOrRoad;
	}
	public void setVillageOrRoad(String villageOrRoad) {
		this.villageOrRoad = villageOrRoad;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public RegisterUserDto(Long nid, String fullName, Date dateOfBirth, String gender, String fatherName,
			String motherName, String division, String district, String upozilla, String unionName, Integer postalCode,
			String villageOrRoad, String phoneNumber, String email, String password) {
		super();
		this.nid = nid;
		this.fullName = fullName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.fatherName = fatherName;
		this.motherName = motherName;
		this.division = division;
		this.district = district;
		this.upozilla = upozilla;
		this.unionName = unionName;
		this.postalCode = postalCode;
		this.villageOrRoad = villageOrRoad;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.password = password;
	}
	
	
}
