package com.neub.authApi.entitiy;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "transfer_vaccine")
@Entity
public class TransferVaccine {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long tnxId;
	
	private Long fromCenterId; // health ministry has a fixed center id, this will denote that the delivery was from ministry
	
	private Long toCenterId;
	
	private String vaccineId;
	
	private String doseId;
	
	private Date transferDate;
	
	private Date receivedDate;
	
	private String status; // in_transit, received
	
	private Long otp;

	public Long getTnxId() {
		return tnxId;
	}

	public void setTnxId(Long tnxId) {
		this.tnxId = tnxId;
	}

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getOtp() {
		return otp;
	}

	public void setOtp(Long otp) {
		this.otp = otp;
	}
	
	
}
