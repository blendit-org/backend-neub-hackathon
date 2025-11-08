package com.neub.authApi.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neub.authApi.dto.LoginAdminDto;
import com.neub.authApi.entitiy.Admin;
import com.neub.authApi.entitiy.RequestVaccine;
import com.neub.authApi.exception.UserNotVerifiedError;
import com.neub.authApi.repository.RequestVaccineRepository;
import com.neub.authApi.response.LoginResponse;

@RequestMapping("/powertool")
@RestController
public class AdminPowerTool {
	
	private final RequestVaccineRepository requestVaccineRepository;
	
	
	
	public AdminPowerTool(RequestVaccineRepository requestVaccineRepository) {
		super();
		this.requestVaccineRepository = requestVaccineRepository;
	}



	@PostMapping("/grant_vaccine_request")
	public ResponseEntity<RequestVaccine> authenticate(@RequestBody RequestVaccine requestVaccine) {
		
		RequestVaccine rv = requestVaccineRepository.findById(requestVaccine.getReqId()).get();
		
		rv.setStatus("granted");
		
		requestVaccineRepository.save(rv);
		
		return ResponseEntity.ok(rv);
	}
	
}
