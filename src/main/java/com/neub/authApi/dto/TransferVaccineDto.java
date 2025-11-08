package com.neub.authApi.dto;

import java.util.Date;

public class TransferVaccineDto {
	private Long fromCenterId; // health ministry has a fixed center id, this will denote that the delivery was from ministry
	
	private Long toCenterId;
	
	private String vaccineId;
	
	private String doseId;
	
	private Date transferDate;
	
	private Date receivedDate;

	public Long getFromCenterId() {
		return fromCenterId;
	}

	public void setFromCenterId(Long fromCenterId) {
		this.fromCenterId = fromCenterId;
	}

	public Long getToCenterId() {
		return toCenterId;
	}

	public void setToCenterId(Long toCenterId) {
		this.toCenterId = toCenterId;
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

	public Date getTransferDate() {
		return transferDate;
	}

	public void setTransferDate(Date transferDate) {
		this.transferDate = transferDate;
	}

	public Date getReceivedDate() {
		return receivedDate;
	}

	public void setReceivedDate(Date receivedDate) {
		this.receivedDate = receivedDate;
	}

	public TransferVaccineDto(Long fromCenterId, Long toCenterId, String vaccineId, String doseId, Date transferDate,
			Date receivedDate) {
		super();
		this.fromCenterId = fromCenterId;
		this.toCenterId = toCenterId;
		this.vaccineId = vaccineId;
		this.doseId = doseId;
		this.transferDate = transferDate;
		this.receivedDate = receivedDate;
	}
	
	
	
	
}
