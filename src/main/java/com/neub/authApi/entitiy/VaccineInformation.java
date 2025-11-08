package com.neub.authApi.entitiy;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "vaccine_information")
@Entity
public class VaccineInformation {
	@Id
	@Column(nullable = false, unique = true)
	private String vaccineId;
	
	private Integer startingAge; // in months
	
	private Integer endingAge; // in months
	
	private String gender; // universal(male, female both) / only male / only female
	
	private String preservationGuideline;

	public String getVaccineId() {
		return vaccineId;
	}

	public void setVaccineId(String vaccineId) {
		this.vaccineId = vaccineId;
	}

	public Integer getStartinAge() {
		return startingAge;
	}

	public void setStartingAge(Integer starting_age) {
		this.startingAge = starting_age;
	}

	public Integer getEndingAge() {
		return endingAge;
	}

	public void setEndingAge(Integer endingAge) {
		this.endingAge = endingAge;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPreservationGuideline() {
		return preservationGuideline;
	}

	public void setPreservationGuideline(String preservationGuideline) {
		this.preservationGuideline = preservationGuideline;
	}
}
