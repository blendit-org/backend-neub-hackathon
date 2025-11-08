package com.neub.authApi.entitiy;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "doseage_information")
@Entity
public class DosageInformation {
	@Id
	private String doseId;
	
	private String vaccineId;
	
	private Long doseGap;

	public String getDoseId() {
		return doseId;
	}

	public void setDoseId(String doseId) {
		this.doseId = doseId;
	}

	public String getVaccineId() {
		return vaccineId;
	}

	public void setVaccineId(String vaccineId) {
		this.vaccineId = vaccineId;
	}

	public Long getDoseGap() {
		return doseGap;
	}

	public void setDoseGap(Long doseGap) {
		this.doseGap = doseGap;
	}
	
	
}
