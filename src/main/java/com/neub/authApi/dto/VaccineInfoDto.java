package com.neub.authApi.dto;

import java.util.List;
import java.util.Map;

public class VaccineInfoDto {
	private String vaccineId;
	
	private Integer startingAge; // in months
	
	private Integer endingAge; // in months
	
	private String gender; // universal(male, female both) / only male / only female
	
	private String preservationGuideline;
	
	private Map<String, Long> doses;

	public String getVaccineId() {
		return vaccineId;
	}

	public void setVaccineId(String vaccineId) {
		this.vaccineId = vaccineId;
	}

	public Integer getStartingAge() {
		return startingAge;
	}


	public Integer getEndingAge() {
		return endingAge;
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
	

	public Map<String, Long> getDoses() {
		return doses;
	}
	
	

	public void setDoses(Map<String, Long> doses) {
		this.doses = doses;
	}

	public void setStartingAge(Integer startingAge) {
		this.startingAge = startingAge;
	}

	public void setEndingAge(Integer endingAge) {
		this.endingAge = endingAge;
	}

	public VaccineInfoDto(String vaccineId, Integer starting_age, Integer ending_age, String gender,
			String preservationGuideline) {
		super();
		this.vaccineId = vaccineId;
		this.startingAge = starting_age;
		this.endingAge = ending_age;
		this.gender = gender;
		this.preservationGuideline = preservationGuideline;
	}
	
	
}
