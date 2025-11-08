package com.neub.authApi.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neub.authApi.dto.LoginUserDto;
import com.neub.authApi.dto.RegisterUserDto;
import com.neub.authApi.dto.VerificationRequestDto;
import com.neub.authApi.dto.VerifyDto;
import com.neub.authApi.entitiy.User;
import com.neub.authApi.exception.UserNotVerifiedError;
import com.neub.authApi.exception.UsernameAlreadyExists;
import com.neub.authApi.exception.VerificationMismatch;
import com.neub.authApi.response.LoginResponse;
import com.neub.authApi.service.AuthenticationService;
import com.neub.authApi.service.JwtService;
import com.neub.authApi.service.VerificationService;

import jakarta.servlet.http.HttpServletRequest;

@RequestMapping("/auth")
@RestController
public class AuthenticationController {
	
	private final JwtService jwtService;
	
	private final AuthenticationService authenticationService;
	
	private final VerificationService verificationService;
	
	//private final MailService mailService;
	
	
	
//	@PostMapping("/signup")
//	public ResponseEntity<Map<String, Object>> signup(@RequestBody RegisterUserDto registerUserDto) {
//		System.out.println("[debug] /auth/signup");
//		
//		String emailAuthToken = jwtService.buildEmailToken(registerUserDto);
//		String url = "http://localhost:8005";
//		
//		return ResponseEntity.ok(Map.of(
//				"message", "There is a link sent to your email. Click it to verify"));
//		
//	}
	
	public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService,
			VerificationService verificationService) {
		super();
		this.jwtService = jwtService;
		this.authenticationService = authenticationService;
		this.verificationService = verificationService;
	}
	
	@PostMapping("/signup")
	public ResponseEntity<User> register(@RequestBody RegisterUserDto registerUserDto) throws UsernameAlreadyExists {
		
		System.out.println("[debug] /auth/signup/email-verification");
		
		User registeredUser = authenticationService.signup(registerUserDto);
		
		return ResponseEntity.ok(registeredUser);
	}
	
	

	@PostMapping("/login")
	public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginUserDto loginUserDto) throws UserNotVerifiedError {
		
		System.out.println("[debug] /auth/login");
		
		User authenticatedUser = authenticationService.authenticate(loginUserDto);
		
		// user needs to be email verified
//		if (!authenticatedUser.isVerified()) {
//			return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
//		}
//		
		// Building JWT token with email and userId information
		Map<String, Object> extraClaims = new HashMap<>();
		extraClaims.put("userId", authenticatedUser.getUserId());
		
		
		String jwtToken = jwtService.generateToken(extraClaims, authenticatedUser);
		System.out.println(jwtService.extractUsername(jwtToken));
		
		LoginResponse loginResponse = new LoginResponse();
		loginResponse.setToken(jwtToken);
		loginResponse.setExpiresIn(jwtService.getExpirationTime());
		
		return ResponseEntity.ok(loginResponse);
	}
	
	@PostMapping("/logout")
	public ResponseEntity<String> logout(HttpServletRequest request) {
		String token = request.getHeader("Authorization");
		System.out.println("[logout] "+ token);
		// blacklist token
		
		return ResponseEntity.ok("Logged out successfully");
	}
	
	@PostMapping("/verify")
	public ResponseEntity<Map<String, Object>> verificationRequest(@RequestBody VerificationRequestDto verificationDto) {
		verificationService.verificationCodeSent(verificationDto.getEmail());
		return ResponseEntity.ok(Map.of("message", "Verification code sent"));
	}
	
	@PostMapping("/verify/confirm")
	public ResponseEntity<Map<String, Object>> verifyEmail(@RequestBody VerifyDto verificationDto) throws VerificationMismatch {
		verificationService.verificationCodeMatches(verificationDto.getEmail(), verificationDto.getOtp());
		return ResponseEntity.ok(Map.of("message", "Verification code matches"));
	}
	
}
