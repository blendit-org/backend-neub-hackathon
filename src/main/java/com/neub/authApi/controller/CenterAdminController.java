package com.neub.authApi.controller;

import java.util.Date;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neub.authApi.dto.LoginAdminDto;
import com.neub.authApi.dto.RecordCitizenTakingVaccineDto;
import com.neub.authApi.dto.RequestVaccineDto;
import com.neub.authApi.entitiy.Appointment;
import com.neub.authApi.entitiy.CenterVaccineStock;
import com.neub.authApi.entitiy.Notifications;
import com.neub.authApi.entitiy.RequestVaccine;
import com.neub.authApi.entitiy.Staff;
import com.neub.authApi.repository.AppointmentRepository;
import com.neub.authApi.repository.CenterVaccineStockRepository;
import com.neub.authApi.repository.NotificationRepository;
import com.neub.authApi.repository.RequestVaccineRepository;
import com.neub.authApi.repository.StaffRepository;
import com.neub.authApi.response.StockQueryResponse;
import com.neub.authApi.service.JwtService;

import jakarta.servlet.http.HttpServletRequest;

@RequestMapping("/center")
@RestController
public class CenterAdminController {
	
	private JwtService jwtService;
	
	private final CenterVaccineStockRepository centerVaccineStockRepository;
	
	private final StaffRepository staffRepository;
	
	private final AppointmentRepository appointmentRepository;
	
	private final RequestVaccineRepository requestVaccineRepository;

	private final NotificationRepository notificationRepository;
	
	

	public CenterAdminController(JwtService jwtService, CenterVaccineStockRepository centerVaccineStockRepository,
			StaffRepository staffRepository, AppointmentRepository appointmentRepository,
			RequestVaccineRepository requestVaccineRepository, NotificationRepository notificationRepository) {
		super();
		this.jwtService = jwtService;
		this.centerVaccineStockRepository = centerVaccineStockRepository;
		this.staffRepository = staffRepository;
		this.appointmentRepository = appointmentRepository;
		this.requestVaccineRepository = requestVaccineRepository;
		this.notificationRepository = notificationRepository;
	}

	@GetMapping("/stock_query")
	public ResponseEntity<StockQueryResponse> stockQuery(HttpServletRequest request) {
		System.out.println("hi");
		List<CenterVaccineStock> vaxs = centerVaccineStockRepository.findAll();
		StockQueryResponse sqr = new StockQueryResponse();
		
		sqr.setCenterVaccineStockList(vaxs);
		
		return ResponseEntity.ok(sqr);
	}
	
	@GetMapping("/staff_query")
	public ResponseEntity<List<Staff>> staffQuery(HttpServletRequest request) {
		return ResponseEntity.ok(staffRepository.findAll());
	}
	
	@PostMapping("/record_vaccine")
	public ResponseEntity<Appointment> recordVaccine(@RequestBody RecordCitizenTakingVaccineDto recordCitizen) {
		Appointment app = appointmentRepository.findByUserIdAndVaccineIdAndDoseId(recordCitizen.getUserId(), recordCitizen.getVaccineId(), recordCitizen.getDoseId()).get();
		app.setStaffId(recordCitizen.getStaffId());
		app.setStatus("completed");
		app.setVaccinationDate(new Date());
		
		return ResponseEntity.ok(appointmentRepository.save(app));
	}
	
	@PostMapping("/request_vaccine")
	public ResponseEntity<RequestVaccine> requestVaccine(@RequestBody RequestVaccineDto requestVaccineDto) {
		RequestVaccine rv = new RequestVaccine();
		
		rv.setDoseId(requestVaccineDto.getDoseId());
		rv.setNotes(requestVaccineDto.getNotes());
		rv.setPriority(requestVaccineDto.getPriority());
		rv.setQuantity(requestVaccineDto.getQuantity());
		rv.setRequestDate(new Date());
		rv.setStatus("pending");
		rv.setVaccineId(requestVaccineDto.getVaccineId());
		
		requestVaccineRepository.save(rv);
		
		return ResponseEntity.ok(rv);
	}
	
	@PostMapping("/notifications")
    public ResponseEntity<List<Notifications>> allNotifications(@RequestBody LoginAdminDto admin) {
    	return ResponseEntity.ok(notificationRepository.findByUserId(admin.getAdminId()));
    }
}
