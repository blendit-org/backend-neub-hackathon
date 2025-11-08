package com.neub.authApi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neub.authApi.dto.LoginAdminDto;
import com.neub.authApi.dto.LoginUserDto;
import com.neub.authApi.entitiy.Admin;
import com.neub.authApi.entitiy.Notifications;
import com.neub.authApi.entitiy.User;
import com.neub.authApi.exception.UserNotVerifiedError;
import com.neub.authApi.repository.NotificationRepository;
import com.neub.authApi.response.LoginResponse;
import com.neub.authApi.service.AdminAuthenticationService;
import com.neub.authApi.service.JwtService;

@RequestMapping("/admin")
@RestController
public class AdminController {
	
	private final AdminAuthenticationService adminAuthenticationService;
	
	private final JwtService jwtService;
	
	private final NotificationRepository notificationRepository;
	
	public AdminController(AdminAuthenticationService adminAuthenticationService, JwtService jwtService,
			NotificationRepository notificationRepository) {
		super();
		this.adminAuthenticationService = adminAuthenticationService;
		this.jwtService = jwtService;
		this.notificationRepository = notificationRepository;
	}

	@PostMapping("/login")
	public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginAdminDto loginAdminDto) throws UserNotVerifiedError {
		
		System.out.println("[debug] /auth/login");
		
		Admin admin= adminAuthenticationService.authenticate(loginAdminDto);
		
		
		String jwtToken = jwtService.buildAdminToken(admin);
		System.out.println(jwtService.extractUsername(jwtToken));
		
		LoginResponse loginResponse = new LoginResponse();
		loginResponse.setToken(jwtToken);
		loginResponse.setExpiresIn(jwtService.getExpirationTime());
		
		return ResponseEntity.ok(loginResponse);
	}
	
	@PostMapping("/notifications")
    public ResponseEntity<List<Notifications>> allNotifications(@RequestBody LoginAdminDto admin) {
    	return ResponseEntity.ok(notificationRepository.findByUserId(admin.getAdminId()));
    }
    
}
