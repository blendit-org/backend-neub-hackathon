package com.neub.authApi.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.neub.authApi.dto.LoginUserDto;
import com.neub.authApi.dto.RegisterUserDto;
import com.neub.authApi.entitiy.User;
import com.neub.authApi.exception.UserNotVerifiedError;
import com.neub.authApi.exception.UsernameAlreadyExists;
import com.neub.authApi.repository.UserRepository;

@Service
public class AuthenticationService {
	private final UserRepository userRepository;
	
	private final PasswordEncoder passwordEncoder;
	
	private final AuthenticationManager authenticationManager;	
	
	public AuthenticationService(UserRepository userRepository, PasswordEncoder passwordEncoder,
			AuthenticationManager authenticationManager, MailService mailService) {
		super();
		System.out.println("[debug] AuthenticationService() constructor called");
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
		this.authenticationManager = authenticationManager;
	}
	
	public User signup(RegisterUserDto input) throws UsernameAlreadyExists {
		
		User user = new User();
		user.setFullName(input.getFullName());
		user.setEmail(input.getEmail());
		user.setPassword(passwordEncoder.encode(input.getPassword()));
		user.setVerified(false);
		user.setDateOfBirth(input.getDateOfBirth());
		user.setGender(input.getGender());
		user.setFatherName(input.getFatherName());
		user.setMotherName(input.getMotherName());
		user.setDivision(input.getDivision());
		user.setDistrict(input.getDistrict());
		user.setUnionName(input.getUnionName());
		user.setPostalCode(input.getPostalCode());
		user.setUpozilla(input.getUpozilla());
		user.setVillageOrRoad(input.getVillageOrRoad());
		user.setPhoneNumber(input.getPhoneNumber());
		
		
		System.out.println("[debug] AuthenticationService::signup(ResgisterUserDto input)");
		
		if (userRepository.existsById(input.getNid())) {
			throw new UsernameAlreadyExists("This user id " + input.getNid() + " already exists");
		}

		
		user.setUserId(input.getNid());
		
		return userRepository.save(user);
	}
	
	public User authenticate(LoginUserDto input) throws UserNotVerifiedError {
		System.out.println("hi: " + input.getUserId());
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(input.getUserId().toString(), input.getPassword()));
		System.out.println("[DEBUG]: AuthenticationService::authenticate(LoginUserDto input) called");
		User user = userRepository.findById(input.getUserId()).orElseThrow();
		
		System.out.println("this email, " + user.getEmail() + "isVerified" + user.isVerified());
		
		// check if user is verified
		
		if (!user.isVerified()) {
			throw new UserNotVerifiedError("This user is not verified");
		}
		return user;
	}
}
