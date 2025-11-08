package com.neub.authApi.dto;

public class RequestVaccineDto {
	private String vaccineId;
	private String doseId;
	private long quantity;
	private String priority;
	private String notes;
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
	public long getQuantity() {
		return quantity;
	}
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	
}
