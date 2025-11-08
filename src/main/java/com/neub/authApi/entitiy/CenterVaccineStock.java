package com.neub.authApi.entitiy;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "center_vaccine_stock")
@Entity
public class CenterVaccineStock {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long stockId;
	
	private Long centerId;
	
	private String vaccineId;
	
	private String doseId;
	
	private Long numberOfVaccines;

	public Long getStockId() {
		return stockId;
	}

	public void setStockId(Long stockId) {
		this.stockId = stockId;
	}

	public Long getCenterId() {
		return centerId;
	}

	public void setCenterId(Long centerId) {
		this.centerId = centerId;
	}

	public String getVaccineId() {
		return vaccineId;
	}

	public void setVaccineId(String vaccineId) {
		this.vaccineId = vaccineId;
	}

	public String getDoseId() {
		return doseId;
	}

	public void setDoseId(String doseId) {
		this.doseId = doseId;
	}

	public Long getNumberOfVaccines() {
		return numberOfVaccines;
	}

	public void setNumberOfVaccines(Long numberOfVaccines) {
		this.numberOfVaccines = numberOfVaccines;
	}
	
	
}
