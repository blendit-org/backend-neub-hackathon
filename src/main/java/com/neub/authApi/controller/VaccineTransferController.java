package com.neub.authApi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neub.authApi.dto.CenterInfoDto;
import com.neub.authApi.dto.ConfirmationOnVaccineReceiveDto;
import com.neub.authApi.dto.TransferVaccineDto;
import com.neub.authApi.entitiy.Center;
import com.neub.authApi.entitiy.TransferVaccine;
import com.neub.authApi.repository.TransferVaccineRepository;
import com.neub.authApi.service.JwtService;

import jakarta.servlet.http.HttpServletRequest;

@RequestMapping("/transfer")
@RestController
public class VaccineTransferController {
	
	private JwtService jwtService;
	
	private final TransferVaccineRepository transferVaccineRepository;
	
	
	
	public VaccineTransferController(JwtService jwtService, TransferVaccineRepository transferVaccineRepository) {
		super();
		this.jwtService = jwtService;
		this.transferVaccineRepository = transferVaccineRepository;
	}

	@PostMapping("/send")
	public ResponseEntity<TransferVaccine> sendToCenter(@RequestBody TransferVaccineDto transferInfoDto, HttpServletRequest request) {
		System.out.println("hi");
		String jwt = request.getHeader("Authorization").substring(7);
		System.out.println(" " + jwt);
		
		if(jwtService.extractAllClaims(jwt).get("role").equals("health_admin")) {
			TransferVaccine tnx = new TransferVaccine();
			
			tnx.setVaccineId(transferInfoDto.getVaccineId());
			tnx.setDoseId(transferInfoDto.getDoseId());
			tnx.setFromCenterId(transferInfoDto.getFromCenterId());
			tnx.setToCenterId(transferInfoDto.getToCenterId());
			tnx.setStatus("in_transit");
			tnx.setOtp(1234L); // set later
			
			return ResponseEntity.ok(transferVaccineRepository.save(tnx));
		}
		return null;
	}
	
	@PostMapping("/receive")
	public ResponseEntity<TransferVaccine> approveFromCenter(@RequestBody ConfirmationOnVaccineReceiveDto conf, HttpServletRequest request) {
		System.out.println("hi");
		String jwt = request.getHeader("Authorization").substring(7);
		System.out.println(" " + jwt);
		
		if(jwtService.extractAllClaims(jwt).get("role").equals("center_admin") || jwtService.extractAllClaims(jwt).get("role").equals("health_admin")) {
			TransferVaccine tnx = transferVaccineRepository.findByTnxId(conf.getTnxId()).get();
			
			System.out.println("tnx: "+tnx.getTnxId());
			
			if (tnx != null && tnx.getOtp().equals(conf.getOtp())) {
				tnx.setTnxId(conf.getTnxId());
				tnx.setStatus("received");
				return ResponseEntity.ok(transferVaccineRepository.save(tnx));
			}
		}
		
		return null;
	}
}
