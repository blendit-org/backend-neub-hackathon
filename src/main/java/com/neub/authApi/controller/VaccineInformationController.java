package com.neub.authApi.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neub.authApi.dto.CenterInfoDto;
import com.neub.authApi.dto.LoginAdminDto;
import com.neub.authApi.dto.VaccineInfoDto;
import com.neub.authApi.entitiy.Center;
import com.neub.authApi.entitiy.DosageInformation;
import com.neub.authApi.entitiy.User;
import com.neub.authApi.entitiy.VaccineInformation;
import com.neub.authApi.repository.CenterRepository;
import com.neub.authApi.repository.DosesRepository;
import com.neub.authApi.repository.VaccineRepository;
import com.neub.authApi.response.LoginResponse;
import com.neub.authApi.service.JwtService;

import jakarta.servlet.http.HttpServletRequest;

@RequestMapping("/vaccine")
@RestController
public class VaccineInformationController {

	private JwtService jwtService;

	private final VaccineRepository vaccineRepository;

	private final DosesRepository dosesRepository;
	
	private final CenterRepository centerRepository;

	public VaccineInformationController(JwtService jwtService, VaccineRepository vaccineRepository,
			DosesRepository dosesRepository, CenterRepository centerRepository) {
		super();
		this.jwtService = jwtService;
		this.vaccineRepository = vaccineRepository;
		this.dosesRepository = dosesRepository;
		this.centerRepository = centerRepository;
	}

	@PostMapping("/add")
	public ResponseEntity<VaccineInformation> addNewVaccine(@RequestBody VaccineInfoDto vaccineInfoDto, HttpServletRequest request) {
		 String jwt = request.getHeader("Authorization").substring(7);
		 System.out.println(" " + jwt); 
		 if(jwtService.extractAllClaims(jwt).get("role").equals("health_admin")) {
			 VaccineInformation vaccineInformation = new VaccineInformation();
			 vaccineInformation.setVaccineId(vaccineInfoDto.getVaccineId());
			 vaccineInformation.setGender(vaccineInfoDto.getGender());
			 vaccineInformation.setStartingAge(vaccineInfoDto.getStartingAge());
			 vaccineInformation.setEndingAge(vaccineInfoDto.getEndingAge());
			 vaccineInformation.setPreservationGuideline(vaccineInfoDto.getPreservationGuideline());
		 
		 for(Map.Entry<String, Long> dose: vaccineInfoDto.getDoses().entrySet()) {
			 DosageInformation dosageInfo = new DosageInformation();
			 dosageInfo.setVaccineId(vaccineInfoDto.getVaccineId());
			 dosageInfo.setDoseId(dose.getKey()); dosageInfo.setDoseGap(dose.getValue());
			 dosesRepository.save(dosageInfo); 
		 }
		 
		 	return ResponseEntity.ok(vaccineRepository.save(vaccineInformation)); 
		 }
		return null;
	}
	
	@PostMapping("/add_center")
	public ResponseEntity<Center> addNewCenter(@RequestBody CenterInfoDto centerInfoDto, HttpServletRequest request) {
		System.out.println("hi");
		String jwt = request.getHeader("Authorization").substring(7);
		System.out.println(" " + jwt);
		
		if(jwtService.extractAllClaims(jwt).get("role").equals("health_admin")) {
			Center center = new Center();
			center.setCenterName(centerInfoDto.getCenterName());
			center.setDistrict(centerInfoDto.getDistrict());
			center.setDivision(centerInfoDto.getDivision());
			center.setUpozilla(centerInfoDto.getUpozilla());
			center.setUnionName(centerInfoDto.getUnionName());
			center.setLatitude(centerInfoDto.getLatitude());
			center.setLongitude(centerInfoDto.getLongitude());
			center.setHourlyCapacity(centerInfoDto.getHourlyCapacity());
			center.setPhoneNumber1(centerInfoDto.getPhoneNumber1());
			center.setPhoneNumber2(centerInfoDto.getPhoneNumber2());
			center.setEmail(centerInfoDto.getEmail());
			
			return ResponseEntity.ok(centerRepository.save(center));
		}
		return null;
	}
}


